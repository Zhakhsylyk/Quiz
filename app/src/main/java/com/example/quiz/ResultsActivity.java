package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");
        int cheat = bundle.getInt("cheat");

        mFinalScore.setText("You scored " + score + " out of " + QuizBook.questions.length);

        if (cheat != 0){
            mGrade.setText("You cheat");
        }
        else {
            if (score == 9){
                mGrade.setText("Excellent");
            }else if (score == 8){
                mGrade.setText("Good Work");
            }else if (score == 7) {
                mGrade.setText("Norm");
            }else if (score == 0) {
                mGrade.setText("Try Again");
            }else {
                mGrade.setText("Not Bad");
            }
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}
