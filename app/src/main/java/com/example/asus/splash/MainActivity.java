package com.example.asus.splash;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    EditText edit;
    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageView) findViewById(R.id.Button);
        button.setOnClickListener(this);

        text = (TextView) findViewById(R.id.TextView);
        edit = (EditText) findViewById(R.id.EditText);

        Button button_about = (Button) findViewById(R.id.button_1);
        Button button_exit = (Button) findViewById(R.id.button_2);
        button_about.setOnClickListener(this);
        button_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Button:
                text.setText(edit.getText().toString());
            case R.id.button_1:
                AlertDialog.Builder info = new AlertDialog.Builder(MainActivity.this);
                info.setMessage("Dibuat oleh Asdi Prayudha Rahadi\n\n2017").setCancelable(false).setPositiveButton("Lanjut", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                });
                AlertDialog dialog = info.create();
                dialog.setTitle("Tentang Aplikasi");
                dialog.show();
                TextView text = (TextView) dialog.findViewById(android.R.id.message);
                text.setTextSize(15);
                break;
            case R.id.button_2 :
                AlertDialog.Builder keluar = new AlertDialog.Builder(MainActivity.this);
                keluar.setMessage("Apakah Anda yakin ingin keluar?").setCancelable(false).setPositiveButton("Ya", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        System.exit(0);
                    }
                }).setNegativeButton("Tidak", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog1 = keluar.create();
                dialog1.setTitle("Keluar");
                dialog1.show();

            case R.id.btn_web:
                Intent i = new Intent(MainActivity.this, activity_webview.class);
                startActivity(i);
        }
    }
}
