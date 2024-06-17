package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WesternActivity extends Activity {
    FileManager fileManager;
    TextView wesFoodText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western);
        setTitle("양식");

        fileManager = new FileManager();
        wesFoodText = (TextView) findViewById(R.id.westernFoodText);
        String FoodText = fileManager.getSortedScoresAsString(this,"westernFood.txt");

        Button btnReturn = (Button) findViewById(R.id.return1);

        wesFoodText.setText(FoodText);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
