package com.example.ict814.template;

/**
 * Created by ict814 on 2018/02/19.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    static final String ACTION_TIME_LEFT = "com.example.ict814.template";
    //カウントダウンの現在地
    private static int count;

    private Service thisService;
    Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();

        thisService = this;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        count = intent.getIntExtra("countSecond", 0);

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                count--; //1秒ごとにカウンダウン

                //カウントを送信
                Intent actionIntent = new Intent(ACTION_TIME_LEFT);
                actionIntent.putExtra("count", count);
                sendBroadcast(actionIntent);

                //カウントが0になった時にストップする
                if (count <= 0) {
                    thisService.stopSelf();
                }
            }
        }, 1000, 1000); //1秒ごと繰り返し

        return START_NOT_STICKY; //新しいインテントが作成されるまでインテントを再作成しない
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel(); //ストップを押してタイマーをやめる
    }
}
