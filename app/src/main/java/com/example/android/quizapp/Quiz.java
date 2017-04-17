package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    private final String tag = Quiz.class.toString();

    private ArrayList<CheckBox> answersQ1;
    private ArrayList<RadioButton> answersQ2;
    private EditText answersQ3;
    private ArrayList<RadioButton> answersQ4;
    private ArrayList<CheckBox> answersQ5;
    private EditText answersQ6;
    private EditText answersQ7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initObjects();
    }



    private  void initObjects(){
        Log.d(tag,"Init Objects");
        answersQ1 = new ArrayList<CheckBox>();
        answersQ2 = new ArrayList<RadioButton>();
        answersQ4 = new ArrayList<RadioButton>();
        answersQ5 = new ArrayList<CheckBox>();

        answersQ1.add((CheckBox)findViewById(R.id.question_1_answer_1));
        answersQ1.add((CheckBox)findViewById(R.id.question_1_answer_2));
        answersQ1.add((CheckBox)findViewById(R.id.question_1_answer_3));
        answersQ1.add((CheckBox)findViewById(R.id.question_1_answer_4));

        answersQ3 = (EditText) findViewById(R.id.question_3_answer_1);

        answersQ2.add((RadioButton)findViewById(R.id.question_2_answer_1));
        answersQ2.add((RadioButton)findViewById(R.id.question_2_answer_2));
        answersQ2.add((RadioButton)findViewById(R.id.question_2_answer_3));
        answersQ2.add((RadioButton)findViewById(R.id.question_2_answer_4));

        answersQ4.add((RadioButton)findViewById(R.id.question_4_answer_1));
        answersQ4.add((RadioButton)findViewById(R.id.question_4_answer_2));
        answersQ4.add((RadioButton)findViewById(R.id.question_4_answer_3));
        answersQ4.add((RadioButton)findViewById(R.id.question_4_answer_4));

        answersQ5.add((CheckBox)findViewById(R.id.question_5_answer_1));
        answersQ5.add((CheckBox)findViewById(R.id.question_5_answer_2));
        answersQ5.add((CheckBox)findViewById(R.id.question_5_answer_3));
        answersQ5.add((CheckBox)findViewById(R.id.question_5_answer_4));

        answersQ6 = (EditText) findViewById(R.id.question_6_answer_1);

        answersQ7 = (EditText) findViewById(R.id.question_7_answer_1);
    }

    public void submit(View view){
        Log.d(tag, "Submit clicked");
        checkAnswers();
    }

    private void checkAnswers(){
        if(!verifyQuizCompleted())
            return;

        verifyAnswers();
    }

    private boolean verifyQuizCompleted(){
        boolean question1Answered = false;
        boolean question2Answered = false;
        boolean question3Answered = false;
        boolean question4Answered = false;
        boolean question5Answered = false;
        boolean question6Answered = false;
        boolean question7Answered = false;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast;

        for(CheckBox chk : answersQ1){
            if(chk.isChecked())
                question1Answered = true;
        }

        for(RadioButton radioBtn : answersQ2){
            if(radioBtn.isChecked())
                question2Answered = true;
        }

        if (!TextUtils.isEmpty(answersQ3.getText().toString()))
            question3Answered = true;

        for(RadioButton radioBtn : answersQ4){
            if(radioBtn.isChecked())
                question4Answered = true;
        }

        for(CheckBox chk : answersQ5){
            if(chk.isChecked())
                question5Answered = true;
        }

        if (!TextUtils.isEmpty(answersQ6.getText().toString()))
            question6Answered = true;


        if (!TextUtils.isEmpty(answersQ7.getText().toString()))
            question7Answered = true;



        if(!question1Answered){
            toast = Toast.makeText(context,"Question 1 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question2Answered){
            toast = Toast.makeText(context,"Question 2 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question3Answered){
            toast = Toast.makeText(context,"Question 3 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question4Answered){
            toast = Toast.makeText(context,"Question 4 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question5Answered){
            toast = Toast.makeText(context,"Question 5 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question6Answered){
            toast = Toast.makeText(context,"Question 6 is not answered",duration);
            toast.show();
            return false;
        }

        if(!question7Answered){
            toast = Toast.makeText(context,"Question 7 is not answered",duration);
            toast.show();
            return false;
        }

        return true;
    }

    private void verifyAnswers(){
        int correctAnswers = 0;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast;


        if(!answersQ1.get(0).isChecked() && answersQ1.get(1).isChecked() && !answersQ1.get(2).isChecked() && answersQ1.get(3).isChecked())
            correctAnswers++;

        if (answersQ2.get(2).isChecked())
            correctAnswers++;

        if(answersQ3.getText().toString().toUpperCase().trim().equals("COBOL"))
            correctAnswers++;

        if(answersQ4.get(3).isChecked())
            correctAnswers++;

        if(answersQ5.get(0).isChecked() && !answersQ5.get(1).isChecked() && answersQ5.get(2).isChecked() && answersQ5.get(3).isChecked())
            correctAnswers++;

        if (answersQ6.getText().toString().toUpperCase().trim().equals("HTML"))
            correctAnswers++;

        if(answersQ7.getText().toString().toUpperCase().trim().equals("HERITAGE"))
            correctAnswers++;

        if(correctAnswers == 7){
            toast = Toast.makeText(context,"Congratulations, all the answers are correct", duration);
        } else {
            toast = Toast.makeText(context, "You have " + correctAnswers + "/7 answers correct", duration);
        }

        toast.show();
    }
}
