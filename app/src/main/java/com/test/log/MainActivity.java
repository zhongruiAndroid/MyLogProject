package com.test.log;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.log.LG;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String json;
    Button btInitData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json = getJson();
        initView();

        initData();
    }

    private void initView() {
        findViewById(R.id.btInitData).setOnClickListener(this);
    }

    private void initData() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(3)         // (Optional) How many method line to show. Default 2
                .methodOffset(0)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();


        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

//        Logger.d(json);

//        LG.wtf("tag",json);
        LG.i("=================================");
        LG.d(json);
//        LG.e(json);
//        LG.i(json);
//        LG.w(json);
//        LG.v(json);
//        LG.wtf(json);
//        LG.i("=================================");
//        LG.d("tag",json);
//        LG.e("tag",json);
//        LG.i("tag",json);
//        LG.w("tag",json);
//        LG.v("tag",json);
//        LG.wtf("tag",json);
    }

    private String getJson(){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            InputStream open = getAssets().open("data.json");
            InputStreamReader inputStreamReader=new InputStreamReader(open);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String json;
            while ((json=bufferedReader.readLine())!=null){
                stringBuilder.append(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btInitData:
                initData();
            break;
        }
    }
}
