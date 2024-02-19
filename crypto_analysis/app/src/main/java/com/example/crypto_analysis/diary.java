package com.example.crypto_analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class diary extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정 하기");
        } catch (IOException e) {
            edtDiary.setHint("내용을 입력해주세요");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);

        // Initializing components and variables
        setTitle("간단 일기장");
        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        Button returnBtn = findViewById(R.id.returnBtn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);


        // Enable btnWrite when user types in EditText
        edtDiary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                btnWrite.setEnabled(false);
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Enable btnWrite when there is text in the EditText
                btnWrite.setEnabled(charSequence.length() > 0);
            }
            @Override
            public void afterTextChanged(Editable editable) {
                btnWrite.setEnabled(editable.length() > 0);
            }
        });


        // Display saved text on TextView
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth+1)
                + "_" + Integer.toString(cDay) + ".txt";
        String str = readDiary(fileName);
        edtDiary.setText(str);


        // Disable btnWrite initially
        btnWrite.setEnabled(false);


        // 데이트피커를 init()메소드로 초기화
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt"; // fileName = 연_월_일.txtString str = readDiary(fileName); //현재 날짜의 파일을 읽어오는readDiary메소드edtDiary.setText(str);
                String str = readDiary(fileName); //현재 날짜의 파일을 읽어오는readDiary메소드
                edtDiary.setText(str);
                btnWrite.setEnabled(false);
            }
        });


        // Save text when btnWrite is clicked
        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                    btnWrite.setEnabled(false);

                }
                catch (IOException e) {
                    Toast.makeText(diary.this, "다시 저장해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}