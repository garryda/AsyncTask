package com.example.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by 刘鹏达 on 2017/10/4.
 */

public class MyAsyncTask extends AsyncTask<Integer,Integer,String>{

    //通常会把需要变化的组件放进该类进行处理
      private TextView txt;
      private ProgressBar pgbar;

     public MyAsyncTask(TextView txt,ProgressBar pgbar){
         super();
         this.txt=txt;
         this.pgbar=pgbar;
     }

    //执行一些初始化的操作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txt.setText("开始执行异步线程");
    }

    //执行一些耗时操作，只有这边，不可以对ui组件进行操作
    @Override
    protected String doInBackground(Integer... params) {
        DelayOperator delayOperator=new DelayOperator();
        int i=0;
        for(i=10;i<=100;i+=10)
        {
            delayOperator.delay();
            publishProgress(i);
        }
        return i+params[0].intValue()+"";
    }

    //当在后台方法中调用publishProgress()，过不久就会执行这个方法
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int value=values[0];
        pgbar.setProgress(value);
    }

    //

    //当后台方法执行完毕，也就是返回具体值（这边为String)之后，其就会调用该方法
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}

