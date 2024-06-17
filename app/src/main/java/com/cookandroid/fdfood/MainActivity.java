package com.cookandroid.fdfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView Korea, Japan, China, Western, Others;
    FileManager fileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("맛.ZIP");

        fileManager = new FileManager();

        fileManager.createFile(this, "koreaFood.txt");
        fileManager.createFile(this, "japanFood.txt");
        fileManager.createFile(this, "chinaFood.txt");
        fileManager.createFile(this, "westernFood.txt");
        fileManager.createFile(this, "othersFood.txt");

        Button btnadd = (Button) findViewById(R.id.btnAdd);
        Button btnrecommend = (Button) findViewById(R.id.btnRecommend);
        Button btnremove = (Button) findViewById(R.id.btnRemove);

        Korea = (ImageView) findViewById(R.id.korea);
        Japan= (ImageView) findViewById(R.id.japan);
        China = (ImageView) findViewById(R.id.china);
        Western = (ImageView) findViewById(R.id.western);
        Others = (ImageView) findViewById(R.id.others);

        Korea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KoreaActivity.class);
                startActivity(intent);
            }
        });
        Japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JapanActivity.class);
                startActivity(intent);
            }
        });
        China.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChinaActivity.class);
                startActivity(intent);
            }
        });
        Western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WesternActivity.class);
                startActivity(intent);
            }
        });
        Others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OthersActivity.class);
                startActivity(intent);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
            }
        });
        btnrecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RecommendActivity.class);
                startActivity(intent);
            }
        });
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RemoveActivity.class);
                startActivity(intent);
            }
        });
    }
}