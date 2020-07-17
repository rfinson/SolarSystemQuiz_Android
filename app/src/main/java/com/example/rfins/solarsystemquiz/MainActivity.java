//Robert Finson
//4.14.18
//Solar System Quiz App



package com.example.rfins.solarsystemquiz;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare views and buttons
    Button submit, reset;
    //TextView score;
    EditText q5text;
    RadioGroup q1rad,q2rad,q3rad,q4rad;
    RadioButton q1a1,q1a2,q1a3,q1a4,q2a1,q2a2,q2a3,q2a4,q3a1,q3a2,q3a3,q3a4,q4a1,q4a2,q4a3,q4a4;
    int scoreTracker = 0;
    String wrongTracker = "Incorrect: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);          //initialize views
        //score = findViewById(R.id.score);
        q5text = findViewById(R.id.q5text);
        reset = findViewById(R.id.reset);

        q1rad = findViewById(R.id.q1rad);
        q2rad = findViewById(R.id.q2rad);
        q3rad = findViewById(R.id.q3rad);
        q4rad = findViewById(R.id.q4rad);

        q1a1 = findViewById(R.id.q1a1);
        q1a2 = findViewById(R.id.q1a2);
        q1a3 = findViewById(R.id.q1a3);
        q1a4 = findViewById(R.id.q1a4);

        q2a1 = findViewById(R.id.q2a1);
        q2a2 = findViewById(R.id.q2a2);
        q2a3 = findViewById(R.id.q2a3);
        q2a4 = findViewById(R.id.q2a4);

        q3a1 = findViewById(R.id.q3a1);
        q3a2 = findViewById(R.id.q3a2);
        q3a3= findViewById(R.id.q3a3);
        q3a4 = findViewById(R.id.q3a4);

        q4a1 = findViewById(R.id.q4a1);
        q4a2 = findViewById(R.id.q4a2);
        q4a3 = findViewById(R.id.q4a3);
        q4a4 = findViewById(R.id.q4a4);



        submit.requestFocus();  // this line prevents the keyboard from popping up when rotating screen.

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q1rad.getCheckedRadioButtonId()==q1a3.getId())   //following if/else statements increment by 1 either the wrongTracker or scoreTracker
                {
                    scoreTracker++;
                }
                else
                {
                    wrongTracker += "1 ";
                }
                if (q2rad.getCheckedRadioButtonId()==q2a3.getId())
                {
                    scoreTracker++;
                }
                else
                {
                    wrongTracker += "2 ";
                }
                if (q3rad.getCheckedRadioButtonId()==q3a1.getId())
                {
                    scoreTracker++;
                }
                else
                {
                    wrongTracker += "3 ";
                }
                if (q4rad.getCheckedRadioButtonId()==q4a1.getId())
                {
                    scoreTracker++;
                }
                else
                {
                    wrongTracker += "4 ";
                }
                if (q5text.getText().toString().equalsIgnoreCase("no"))
                {
                    scoreTracker++;
                }
                else
                {
                    wrongTracker += "5 ";
                }
                if(scoreTracker!=5)
                {
                    Toast.makeText(getApplicationContext(), wrongTracker+"Score: "+scoreTracker,  //if the score is not 5, that means the users got at least one wrong
                            Toast.LENGTH_LONG).show();                                                 //this ensures "Incorrect" is displayed
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Score: "+scoreTracker,  //if they got everything right, it just displays the score
                            Toast.LENGTH_LONG).show();
                }
                //score.setText("Correct: "+ Integer.toString(scoreTracker));
                scoreTracker=0;
                wrongTracker = "Incorrect: ";  //resets trackers after displaying toast.



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //simple reset clears everything
                q1rad.clearCheck();
                q2rad.clearCheck();
                q3rad.clearCheck();
                q4rad.clearCheck();
                //score.setText("");
                q5text.setText("");

            }
        });
    }
}