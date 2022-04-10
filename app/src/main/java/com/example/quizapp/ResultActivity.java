package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView scoretv,questiontv;
    String scoreS,questionS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoretv=findViewById(R.id.scoreRTV_id);
        questiontv=findViewById(R.id.questionRTV_id);

        Intent intent = getIntent();
         scoreS = intent.getStringExtra("score");
         questionS = intent.getStringExtra("questionnumber");

         scoretv.setText("Your Score is : "+scoreS);
         questiontv.setText("you attempts questions number"+ questionS);



    }
}