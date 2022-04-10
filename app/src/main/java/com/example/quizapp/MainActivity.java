package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView optionaA,optionaB,optionaC,optionaD;
    private TextView cheekout1,cheekout2;
    private TextView questionNumber,question,score;
    int currentIndex;
    int msScore=0;
    int qn=1;
    Dialog dialog;
    private ProgressBar progressBar;
    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;


    AnswerQustion [] questionBank =new AnswerQustion[] {
            new AnswerQustion(R.string.question_1,R.string.question_1_A,R.string.question_1_B,R.string.question_1_C,R.string.question_1_D,R.string.answer_1),
            new AnswerQustion(R.string.question_2,R.string.question_2_A,R.string.question_2_B,R.string.question_2_C,R.string.question_2_D,R.string.answer_2),
            new AnswerQustion(R.string.question_3,R.string.question_3_A,R.string.question_3_B,R.string.question_3_C,R.string.question_3_D,R.string.answer_3),
            new AnswerQustion(R.string.question_4,R.string.question_4_A,R.string.question_4_B,R.string.question_4_C,R.string.question_4_D,R.string.answer_4),
            new AnswerQustion(R.string.question_5,R.string.question_5_A,R.string.question_5_B,R.string.question_5_C,R.string.question_5_D,R.string.answer_5),
    };

    final int Progress_Bar= (int) Math.ceil(100/questionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionaA=findViewById(R.id.optionA);
        optionaB=findViewById(R.id.optionB);
        optionaC=findViewById(R.id.optionC);
        optionaD=findViewById(R.id.optionD);

        question=findViewById(R.id.question_id);
        score=findViewById(R.id.score_id);
        questionNumber=findViewById(R.id.questionNumber_id);

        cheekout1=findViewById(R.id.selectedOption_id);
        cheekout2=findViewById(R.id.correctAnswer_id);
        progressBar=findViewById(R.id.progressBar_id);

        //set Question
        CurrentQuestion= questionBank[currentIndex].getQuestionId();
        question.setText(CurrentQuestion);

        //set Option A
        CurrentOptionA= questionBank[currentIndex].getOptionA();
        optionaA.setText(CurrentOptionA);

        //set Option B
        CurrentOptionB= questionBank[currentIndex].getOptionB();
        optionaB.setText(CurrentOptionB);

        //set Option C
        CurrentOptionC= questionBank[currentIndex].getOptionC();
        optionaC.setText(CurrentOptionC);

        //set Option D
        CurrentOptionD= questionBank[currentIndex].getOptionD();
        optionaD.setText(CurrentOptionD);

        optionaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheekAnswer(CurrentOptionA);
                updateQuestion();
            }
        });

        optionaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheekAnswer(CurrentOptionB);
                updateQuestion();
            }
        });

        optionaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheekAnswer(CurrentOptionC);
                updateQuestion();
            }
        });

        optionaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheekAnswer(CurrentOptionD);
                updateQuestion();
            }
        });


    }

    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;

        if (currentIndex==0)
        {

          AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Quiz End");
            alert.setIcon(R.drawable.winning_2);
            alert.setCancelable(false);
            alert.setMessage("Your Score : "+ msScore +"  Answer Question : "+ questionBank.length  );
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    msScore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score " + msScore + "/" + questionBank.length);
                    questionNumber.setText(qn +"/" + questionBank.length+"Question");

                }
            });
            alert.show();
        }

        //set Question
        CurrentQuestion= questionBank[currentIndex].getQuestionId();
        question.setText(CurrentQuestion);

        //set Option A
        CurrentOptionA= questionBank[currentIndex].getOptionA();
        optionaA.setText(CurrentOptionA);

        //set Option B
        CurrentOptionB= questionBank[currentIndex].getOptionB();
        optionaB.setText(CurrentOptionB);

        //set Option C
        CurrentOptionC= questionBank[currentIndex].getOptionC();
        optionaC.setText(CurrentOptionC);

        //set Option D
        CurrentOptionD= questionBank[currentIndex].getOptionD();
        optionaD.setText(CurrentOptionD);

        qn =qn+1;
        if (qn<=questionBank.length)
        {
            questionNumber.setText(qn +"/" + questionBank.length+" Question");
        }
        score.setText("Score " + msScore + "/" + questionBank.length);
        progressBar.incrementProgressBy(Progress_Bar);
    }

    private void CheekAnswer(int userSelection) {

        int correctanswer =questionBank[currentIndex].getAnswerId();



        cheekout1.setText(userSelection);
        cheekout2.setText(correctanswer);

        String m=cheekout1.getText().toString().trim();
        String n=cheekout2.getText().toString().trim();

        if (m.equals(n))
        {
            Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT).show();
            msScore=msScore+1;

        }else
        {
            Toast.makeText(getApplicationContext(), "!Ops Wrong", Toast.LENGTH_SHORT).show();

        }


    }
}









