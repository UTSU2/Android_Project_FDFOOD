package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChinaActivity extends Activity {
    FileManager fileManager;
    TextView chiFoodText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);
        setTitle("중식");

        fileManager = new FileManager();
        chiFoodText = (TextView) findViewById(R.id.chinaFoodText);

        String FoodText = fileManager.getSortedScoresAsString(this,"chinaFood.txt");

        Button btnReturn = (Button) findViewById(R.id.return1);

        chiFoodText.setText(FoodText);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
