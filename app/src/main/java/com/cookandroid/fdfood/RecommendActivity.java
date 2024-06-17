package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RecommendActivity extends Activity {
    RadioGroup radiogroup;
    Button btnRecommend;
    TextView FoodInfoText;
    FileManager fileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        setTitle("추천");

        fileManager = new FileManager();
        radiogroup = (RadioGroup) findViewById(R.id.group);
        btnRecommend = (Button) findViewById(R.id.btnFoodRecommend);
        FoodInfoText = (TextView) findViewById(R.id.FoodRecommended);
        String[] whichFood;
        whichFood = new String[1];

        Button btnReturn = (Button) findViewById(R.id.return1);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioKorea){
                    whichFood[0] = "한식";
                } else if(checkedId == R.id.radioJapan){
                    whichFood[0] = "일식";
                } else if(checkedId == R.id.radioChina){
                    whichFood[0] = "중식";
                } else if(checkedId == R.id.radioWest){
                    whichFood[0] = "양식";
                } else if(checkedId == R.id.radioOthers){
                    whichFood[0] = "기타";
                }

            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randWhichFood = whichFood[0];
                int count;
                int randomNumber;
                Random random = new Random();
                String foodInfo = null;
                count = fileManager.countLines(RecommendActivity.this, "koreaFood.txt");
                if(randWhichFood.equals("한식")){
                    count = fileManager.countLines(RecommendActivity.this, "koreaFood.txt");
                    if (count > 0) {
                        randomNumber = random.nextInt(count) + 1;
                        foodInfo = fileManager.readLine(RecommendActivity.this, "koreaFood.txt", randomNumber);
                    }
                } else if(randWhichFood.equals("일식")){
                    count = fileManager.countLines(RecommendActivity.this, "japanFood.txt");
                    if (count > 0) {
                        randomNumber = random.nextInt(count) + 1;
                        foodInfo = fileManager.readLine(RecommendActivity.this, "japanFood.txt", randomNumber);
                    }
                } else if(randWhichFood.equals("중식")){
                    count = fileManager.countLines(RecommendActivity.this, "chinaFood.txt");
                    if (count > 0) {
                        randomNumber = random.nextInt(count) + 1;
                        foodInfo = fileManager.readLine(RecommendActivity.this, "chinaFood.txt", randomNumber);
                    }
                } else if(randWhichFood.equals("양식")){
                    count = fileManager.countLines(RecommendActivity.this, "westernFood.txt");
                    if (count > 0) {
                        randomNumber = random.nextInt(count) + 1;
                        foodInfo = fileManager.readLine(RecommendActivity.this, "westernFood.txt", randomNumber);
                    }
                } else if(randWhichFood.equals("기타")){
                    count = fileManager.countLines(RecommendActivity.this, "othersFood.txt");
                    if (count > 0) {
                        randomNumber = random.nextInt(count) + 1;
                        foodInfo = fileManager.readLine(RecommendActivity.this, "othersFood.txt", randomNumber);
                    }
                }

                if (foodInfo != null) {
                    FoodInfoText.setText(foodInfo);
                } else {
                    Toast.makeText(RecommendActivity.this, "내용이 비어 있습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
