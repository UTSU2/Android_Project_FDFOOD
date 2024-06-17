package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OthersActivity extends Activity {
    FileManager fileManager;
    TextView othFoodText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        setTitle("기타");

        fileManager = new FileManager();
        othFoodText = (TextView) findViewById(R.id.othersFoodText);
        String FoodText = fileManager.getSortedScoresAsString(this,"othersFood.txt");

        Button btnReturn = (Button) findViewById(R.id.return1);

        othFoodText.setText(FoodText);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
