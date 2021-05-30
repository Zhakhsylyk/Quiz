package com.example.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion, hindView;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton, hindButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int tryCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        hindView = (TextView) findViewById(R.id.hindview);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);
        hindButton = (Button)findViewById(R.id.hindButton);

        updateQuestion();

        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == true) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("cheat",tryCount);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("cheat",tryCount);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });




        //Logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == false) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("cheat",tryCount);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        bundle.putInt("cheat",tryCount);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

        hindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tryCount < 3){
                    Toast toast;
                    if (QuizBook.answers[mQuestionNumber]){
                        toast = Toast.makeText(QuizActivity.this, "False", Toast.LENGTH_LONG);
                    }
                    else {
                        toast = Toast.makeText(QuizActivity.this, "True", Toast.LENGTH_LONG);
                    }
                    toast.show();
                    tryCount++;
                }
                else {
                    Toast a = Toast.makeText(QuizActivity.this, "You cheat 3 times. You can not cheat anymore", Toast.LENGTH_LONG);
                    a.show();
                }
            }
        });



    }


    private void updateQuestion() {
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

//    public void clickExit(View view) {
//        askToClose();
//    }


//    @Override
//    public void onBackPressed() {
//        askToClose();
//    }
//
//    private void askToClose (){
//        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
//        builder.setMessage("Are you sure you want to quit?");
//        builder.setCancelable(true);
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//                finish();
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.cancel();
//
//            }
//        });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
}
