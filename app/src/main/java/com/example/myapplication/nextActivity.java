package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class nextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        if(savedInstanceState!=null)
        {
            success = savedInstanceState.getInt("success");
            failure = savedInstanceState.getInt("failure");
            answer = savedInstanceState.getInt("answer");

        }
    }


    int tries = 0;
    static int maxTries = 7;
    int answer = 50;
    public static int success = 0;
    public static int failure = 0;



    public void checkNumber(View view){
        Intent intentscore = new Intent(this, scorescreen.class);//passing value to next application
        Bundle score = new Bundle();
        Intent intentmain = new Intent(this, MainActivity.class);//passing value to next application

        Bundle ans = getIntent().getExtras();

        if(ans != null) {
            answer = ans.getInt("answer");
        }

        //manipulate text from xml
        TextView resultText = (TextView) findViewById(R.id.resultText);
        EditText guessNumber = (EditText) findViewById(R.id.guessNumber);
        String rawGuess = guessNumber.getText().toString(); // get value of number field

        //passing value to next application

        int guess = 0;

        //check if value entered is valid
        if (rawGuess.isEmpty() || Double.isNaN(Integer.parseInt(rawGuess))) {
            Toast myToast = Toast.makeText(this, "Not a number", Toast.LENGTH_SHORT);
            myToast.show();
        }

        else {
            guess = Integer.parseInt(rawGuess);



            if (guess == answer) {// correct
                resultText.setText("Correct!");
                tries = 0;
                success++;
                score.putInt("success", success); //bundling
                intentscore.putExtras(score);
                startActivity(intentmain);
                finish();//pass success to score screen


            } else if (guess < answer) {// lower
                resultText.setText("Go higher!");

            } else if (guess > answer) {// higher
                resultText.setText("Go lower!");

            } else {// everything else
                resultText.setText("Try again!");
            }



            if (tries >= maxTries) {
                // too many tries
                resultText.setText("You failed to guess the number!");
                failure++;
                score.putInt("failure", failure); //Your id
                intentscore.putExtras(score);
                startActivity(intentscore);//moves fail to screen
            }

            else {
                Toast myToast = Toast.makeText(this, (maxTries - tries) + " tries remaining",
                        Toast.LENGTH_SHORT);
                myToast.show();
            }

            tries++;
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putInt("success",success);
            outState.putInt("failure",failure);
            outState.putInt("answer",answer);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

    }



}
