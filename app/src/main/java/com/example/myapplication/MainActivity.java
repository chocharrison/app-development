package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guessscreen(View view) {
        Intent intent = new Intent(this, nextActivity.class);
        Bundle b = new Bundle();

        EditText ansNumber = (EditText) findViewById(R.id.ansNumber);
        String rawAns = ansNumber.getText().toString(); // get value of number field
        int answer = Integer.parseInt(rawAns);
        //check if value entered is valid
        if (rawAns.isEmpty() || Double.isNaN(answer)) {
            Toast myToast = Toast.makeText(this, "Not a number", Toast.LENGTH_SHORT);
            myToast.show();
        }


        else if(answer>=1 && answer<=100){
            b.putInt("answer", answer); //Your id
            intent.putExtras(b);
            startActivity(intent);
        }

        else {
            Toast myToast2 = Toast.makeText(this, "number must be between 1 and 100", Toast.LENGTH_SHORT);
            myToast2.show();
        }
    }
}
