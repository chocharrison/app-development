package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class scorescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorescreen);


        TextView SuccessScore = (TextView) findViewById(R.id.SuccessScore);
        TextView FailureScore = (TextView) findViewById(R.id.FailureScore);

        //success screen
        Bundle b = getIntent().getExtras();
        int success = -1;
        int failure = -1;// or other values


        if(b != null) {
            success = b.getInt("success");
            failure = b.getInt("failure");
        }
        SuccessScore.setText("Successful guesses " + success);

        //fail screen
        FailureScore.setText("Failure guesses " + failure);

    }
    public void BackScreen(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
