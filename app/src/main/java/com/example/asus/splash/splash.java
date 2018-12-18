package com.example.asus.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {

    private static int progress = 0;
    private  int status = 0;
    ProgressBar progressBar;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status<100){
                    status = loading();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(status);
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent pindah = new Intent(splash.this, MainActivity.class);
                        startActivity(pindah);
                        finish();
                    }
                });
            }
            public int loading(){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                return ++progress;
            }
        }).start();
    }
}

