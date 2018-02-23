package com.example.ict814.template;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //各種遷移ボタンの変数宣言
    Button btn_ChangeBC;  //背景色変更画面への遷移ボタン
    Button btn_Sensor;  //センサー(照度計)への遷移ボタン
    Button btn_Service;  //サービス(タイマー)への遷移ボタン
    Button btn_Network;  //ネットワークへの遷移ボタン

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //各ボタンの紐づけ
        btn_ChangeBC=(Button)findViewById(R.id.btn_changeBackgroundColor);
        btn_Sensor=(Button)findViewById(R.id.btn_sensor);
        btn_Service=(Button)findViewById(R.id.btn_service);
        btn_Network=(Button)findViewById(R.id.btn_network);

        //各ボタンのオンクリックリスナーの設定
        btn_ChangeBC.setOnClickListener(this);
        btn_Sensor.setOnClickListener(this);
        btn_Service.setOnClickListener(this);
        btn_Network.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        Intent intent=new Intent();
        switch (view.getId()){    //押したボタンのIDを取得し条件分岐
            case R.id.btn_changeBackgroundColor: //背景色
                intent.setClass(this,SetColorActivity.class);
                startActivityForResult(intent,0); //SetColorActivityから結果を受け取る
                break;
            case R.id.btn_sensor: //センサー
                intent.setClass(this,IlluminometerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_service: //サービス
                intent.setClass(this,TimerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_network: //ネットワーク
                intent.setClass(this,NetActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    //setColorの結果受け取り
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.Linear);
        if(data!=null){
            linearLayout.setBackgroundColor(data.getIntExtra("checkedColor", Color.WHITE)); //白にする
        }
    }
}
