package com.cookandroid.fdfood;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddActivity extends Activity {
    FileManager fileManager;
    EditText storeText, scoreText, descText;
    RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("맛집 추가");
        fileManager = new FileManager();

        storeText = (EditText) findViewById(R.id.foodStore);
        scoreText = (EditText) findViewById(R.id.storeScore);
        descText = (EditText) findViewById(R.id.storedesc);
        Button btnReturn = (Button) findViewById(R.id.return1);
        Button btnfoodAdd = (Button) findViewById(R.id.btnFoodAdd);
        radiogroup = (RadioGroup) findViewById(R.id.group);

        String[] whichFood;
        whichFood = new String[1];

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        btnfoodAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String store = storeText.getText().toString();
                String score = scoreText.getText().toString();
                String desc = descText.getText().toString();
                String whichF = whichFood[0];
                System.out.println(score);
                if(whichF.equals("한식")){
                    fileManager.appendTextToFile(AddActivity.this, "koreaFood.txt", score+" "+store+" : "+desc+"\n");
                } else if(whichF.equals("일식")){
                    fileManager.appendTextToFile(AddActivity.this, "japanFood.txt", score+" "+store+" : "+desc+"\n");
                } else if(whichF.equals("중식")){
                    fileManager.appendTextToFile(AddActivity.this, "chinaFood.txt", score+" "+store+" : "+desc+"\n");
                } else if(whichF.equals("양식")){
                    fileManager.appendTextToFile(AddActivity.this, "westernFood.txt", score+" "+store+" : "+desc+"\n");
                } else if(whichF.equals("기타")){
                    fileManager.appendTextToFile(AddActivity.this, "othersFood.txt", score+" "+store+" : "+desc+"\n");
                }
                storeText.setText("");
                scoreText.setText("");
                descText.setText("");
            }
        });

    }
}
