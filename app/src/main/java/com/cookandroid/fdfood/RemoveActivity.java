package com.cookandroid.fdfood;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RemoveActivity extends Activity {
    FileManager fileManager;
    EditText storeText;
    Button removeBtn, removeAllBtn;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        fileManager = new FileManager();
        storeText = (EditText) findViewById(R.id.foodStore);
        removeBtn = (Button) findViewById(R.id.removeFromFile);
        removeAllBtn = (Button) findViewById(R.id.removeAll);
        Button btnReturn = (Button) findViewById(R.id.return1);
        radioGroup = (RadioGroup) findViewById(R.id.group);

        String[] whichFood;
        whichFood = new String[1];

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String store = storeText.getText().toString();
                String whichF = whichFood[0];

                if(whichF.equals("한식")){
                    fileManager.deleteLinesContainingText(RemoveActivity.this, "koreaFood.txt",store);
                } else if(whichF.equals("일식")){
                    fileManager.deleteLinesContainingText(RemoveActivity.this, "japanFood.txt",store);
                } else if(whichF.equals("중식")){
                    fileManager.deleteLinesContainingText(RemoveActivity.this, "chinaFood.txt",store);
                } else if(whichF.equals("양식")){
                    fileManager.deleteLinesContainingText(RemoveActivity.this, "westernFood.txt",store);
                } else if(whichF.equals("기타")){
                    fileManager.deleteLinesContainingText(RemoveActivity.this, "othersFood.txt",store);
                }
                storeText.setText("");
            }
        });
        removeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileManager.deleteFileContent(RemoveActivity.this,"koreaFood.txt");
                fileManager.deleteFileContent(RemoveActivity.this,"japanFood.txt");
                fileManager.deleteFileContent(RemoveActivity.this,"chinaFood.txt");
                fileManager.deleteFileContent(RemoveActivity.this,"westernFood.txt");
                fileManager.deleteFileContent(RemoveActivity.this,"othersFood.txt");
            }
        });
    }
}
