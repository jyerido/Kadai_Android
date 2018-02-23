package com.example.ict814.template;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ict814 on 2018/02/16.
 */

public class IlluminometerActivity extends AppCompatActivity  {
    //照度センサーのイベントリスナー
   private final LightSensorEventListener sensorEventListener=new LightSensorEventListener();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lluminometer);

        //戻るボタンの設定
        Button backButton=(Button)findViewById(R.id.btn_back_illmino);
        //戻るボタンのオンクリックリスナーの設定
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 押されたらfinishでdestroyへ
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        //センサーマネージャーの取得
        SensorManager sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //センサーマネージャーから照度センサーを取得
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //センサーマネージャーにイベントリスナーを登録
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    protected void onPause(){
        super.onPause();
        //センサーマネージャーを取得
        SensorManager sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //センサーマネージャーからイベントリスナーを解除
        sensorManager.unregisterListener(sensorEventListener);
    }

    private class LightSensorEventListener implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent event){
            //照度の値を変数lightに取得する
            float light=event.values[0];
            String l=String.format("%.0f",light); //小数切り捨て整数表示

            //照度の値を表示するテキストビューの設定
            TextView textView=(TextView)findViewById(R.id.luxTextView);
            //テキストビューに取得した照度をセットする
            textView.setText(String.valueOf(l));

            //照度の具合を記号で表示するテキストビューの設定
            TextView textJudge=(TextView)findViewById(R.id.judgeTextView);
            //条件
            if(light>=300){ //300以上
                textJudge.setText(R.string.lx_level1);
            }else if(light>=150){ //150以上
                textJudge.setText(R.string.lx_level2);
            }else if(light>=70){ //70以上
                textJudge.setText(R.string.lx_level3);
            }else if(light>=1) {
                textJudge.setText(R.string.lx_level4);
            }else{
                textJudge.setText(R.string.lx_level0); //真っ暗の時
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor,int accuracy){
        //センサーの精度を変更するメソッドなので中身はなくてよい
        }
    }
}
