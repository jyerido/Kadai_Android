package com.example.ict814.template;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by ict814 on 2018/02/15.
 */

public class SetColorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color);

        //ラジオグループの設定
        final  RadioGroup radioGroup=(RadioGroup)findViewById(R.id.rgroup);
        //決定ボタンの設定
        Button commitButton=(Button)findViewById(R.id.btn_commit);
        //オンクリックリスナーの設定
        commitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int checkedColor= Color.WHITE; //初期の選択位置の設定
                //押したボタンのIDで条件分岐
                switch (radioGroup.getCheckedRadioButtonId()){

                    case R.id.btn_white: //白
                        checkedColor=Color.WHITE;
                        break;
                    case R.id.btn_red: //赤
                        checkedColor=Color.RED;
                        break;
                    case R.id.btn_blue: //青
                        checkedColor=Color.BLUE;
                        break;
                    case R.id.btn_green: //緑
                        checkedColor=Color.GREEN;
                        break;
                    case R.id.btn_yellow: //黄色
                        checkedColor=Color.YELLOW;
                        break;
                    default:
                }

                //インテント作成
                Intent intent=new Intent();
                //　インテントに選んだ色を設定
                intent.putExtra("checkedColor",checkedColor);
                //セットリザルトに格納しMainに投げる
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
