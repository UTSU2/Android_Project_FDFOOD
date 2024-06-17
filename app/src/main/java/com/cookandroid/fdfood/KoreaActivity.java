package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class KoreaActivity extends Activity {
    FileManager fileManager;
    TextView korFoodText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korea);
        setTitle("한식");

        fileManager = new FileManager();
        korFoodText = (TextView) findViewById(R.id.koreaFoodText);

        String FoodText = fileManager.getSortedScoresAsString(this,"koreaFood.txt");

        Button btnReturn = (Button) findViewById(R.id.return1);

        korFoodText.setText(FoodText);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
