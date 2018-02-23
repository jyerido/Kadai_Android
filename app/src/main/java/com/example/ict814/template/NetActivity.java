package com.example.ict814.template;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ict814 on 2018/02/19.
 */

public class NetActivity extends AppCompatActivity {
    //今回表示させたいWEBページのURL設定
    private static final String WEB_SERVER_ADDRESS = "https://www.yahoo.co.jp/";
    //非同期処理を行う変数
    private HtmlShowAsyncTask htmlShowAsyncTask;
    //WEBページのコードを表示させるテキストビュー
    private TextView htmlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        htmlShowAsyncTask = new HtmlShowAsyncTask();
        //WEBページへの実行
        htmlShowAsyncTask.execute(WEB_SERVER_ADDRESS);
        //テキストビューの設定
        htmlTextView = (TextView) findViewById(R.id.htmlTextView);

        //戻るボタンの設定
        Button backButton=(Button)findViewById(R.id.btn_back_net);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

        if(htmlShowAsyncTask!=null){
            htmlShowAsyncTask.cancel(true);
        }
    }
    class HtmlShowAsyncTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String...params){
            String result=null;

            try{
                //コネクションの作成
                URL url=new URL(params[0]);
                URLConnection con=url.openConnection();//URLへ接続
                con.setDoOutput(true); //情報取得許可

                //送信用ストリーム作成
                OutputStreamWriter ow=new OutputStreamWriter(con.getOutputStream());
                BufferedWriter bw=new BufferedWriter(ow);

                //閉じる
                bw.close();
                ow.close();

                //受信
                InputStreamReader ir=new InputStreamReader(con.getInputStream());
                BufferedReader br=new BufferedReader(ir);

                StringBuilder stringBuilder=new StringBuilder();
                String line=null;
                while((line=br.readLine())!=null){
                    stringBuilder.append(line).append("\n");
                }
                br.close();
                ir.close();

                return stringBuilder.toString();
            }catch (IOException e){
                return e.toString();
            }

        }


        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            if(s!=null){
                htmlTextView.setText(s);
            }
        }
    }



}
