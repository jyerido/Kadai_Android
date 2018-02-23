package com.example.ict814.template;

/**
 * Created by ict814 on 2018/02/19.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener, NumberPicker.OnValueChangeListener {
    //各種変数宣言
    private NumberPicker minNumberPicker; //分のナンバーピッカー
    private NumberPicker secNumberPicker; //秒のナンバーピッカー
    private TextView timeLeftTextView; //残り時間のテキストビュー
    private Button startButton; //スタートボタン
    private Button stopButton; //ストップボタン
    private Button backButton; //戻るボタン
    private int countSecond; //残りをカウントする変数
    Intent intent = new Intent(); //TimerService用のインテント


    //残り時間を受け取るレシーバーのメソッド
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //"count"をキーにtimeLeftに値を受け取る
            int timeLeft = intent.getIntExtra("count", 0);

            if (timeLeft <= 0) {
                //音を鳴らす設定
                ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
                toneGenerator.startTone(ToneGenerator.TONE_SUP_PIP, 2000);

                //ボタンの有効設定
                startButton.setEnabled(true);//スタート押せる
                stopButton.setEnabled(false);//ストップ押せない
            }
            showTimeLeft(timeLeft); //時間の表示
        }
    };

    //残り時間を表示するメソッド
    private void showTimeLeft(int sec) {
        String s = String.valueOf(sec/60) + "分" + String.valueOf(sec%60) + "秒"; //時間の文字列作成
        timeLeftTextView.setText(s); //テキストビューにセット
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //各種ボタンの設定
        startButton = (Button) findViewById(R.id.btn_start); //スタート
        stopButton = (Button) findViewById(R.id.btn_stop); //ストップ
        backButton = (Button) findViewById(R.id.btn_back_service); //戻る

        //オンクリックリスナー作成
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

        //各残り時間の数字を扱う部分の設定
        minNumberPicker = (NumberPicker) findViewById(R.id.minNumberPicker);
        minNumberPicker.setMaxValue(10);
        minNumberPicker.setOnValueChangedListener(this);
        secNumberPicker = (NumberPicker) findViewById(R.id.secNumberPicker);
        secNumberPicker.setMaxValue(59);
        secNumberPicker.setOnValueChangedListener(this);

        //残り時間のテキストビューの設定
        timeLeftTextView = (TextView) findViewById(R.id.timeLeftTextView);//
        showTimeLeft(countSecond);

        //残り時間を受信する部分の設定
        IntentFilter filter = new IntentFilter();
        filter.addAction(TimerService.ACTION_TIME_LEFT);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(receiver, filter);


    }

    @Override
    public void onClick(View view) {
        if (view == backButton) { //戻るボタンを押した場合
            finish(); //閉じてデストロイへ
        } else { //戻る以外を押した場合

            intent.setClass(getApplicationContext(), TimerService.class); //TimerServiceをインテント

            if (view == startButton) { //スタートボタンを押した場合

                countSecond = minNumberPicker.getValue() * 60 + secNumberPicker.getValue(); //時間取得
                showTimeLeft(countSecond); //残り時間を取得

                if (countSecond > 0) { //カウントダウン中

                    intent.putExtra("countSecond", countSecond);
                    startService(intent);


                    //スタートを押して時間が減っている状態の時
                    startButton.setEnabled(false); //スタートボタン押せない
                    stopButton.setEnabled(true); //ストップボタン押せる
                }
            } else if (view == stopButton) { //ストップボタンを押した場合

                stopService(intent);  //インテントをやめる

                //カウントが止まっている場合
                startButton.setEnabled(true); //スタートボタン押せる
                stopButton.setEnabled(false); //ストップボタンが押せない
            }
        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        countSecond = minNumberPicker.getValue() * 60 + secNumberPicker.getValue();
        showTimeLeft(countSecond);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        /*何もせずに戻るボタンを押した場合intentの中身はnullなので
        条件文はintent=nullになる*/
        if(intent == null){  //nullの場合
            stopService(intent); //サービスの停止をする
        }
        unregisterReceiver(receiver); //レシーバーの解除
    }
}
