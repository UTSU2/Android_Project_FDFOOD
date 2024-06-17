package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class JapanActivity extends Activity {
    FileManager fileManager;
    TextView japFoodText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan);
        setTitle("일식");

        fileManager = new FileManager();
        japFoodText = (TextView) findViewById(R.id.japanFoodText);

        String FoodText = fileManager.getSortedScoresAsString(this,"japanFood.txt");

        Button btnReturn = (Button) findViewById(R.id.return1);

        japFoodText.setText(FoodText);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
