package com.example.quizapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button yes , no;
    TextView que;
    String [] questions = {"You are Java?", "You are Java Developer?","You are freelancer?","Java introduce in 1675?","Java is a framework?"};
    boolean[] answer = {false, true , false , true ,false};
    int score = 0;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.Yes);
        no = findViewById(R.id.No);
        que = findViewById(R.id.Question);
        que.setText(questions[index]);


       yes.setOnClickListener(v -> {
           if (index <= questions.length - 1)
           {
               if (answer[index])
               {
                   score++;
               }
               index++;
               if (index <= questions.length - 1)
               {
                   que.setText(questions[index]);
               }
               else
               {
                   Toast toast = Toast.makeText(MainActivity.this, "Your score is: " + score + "/"+questions.length, Toast.LENGTH_SHORT);
                   toast.getView().setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                   toast.show();
               }

               }
           else
           {
               Toast toast = Toast.makeText(MainActivity.this, "Restart App again", Toast.LENGTH_SHORT);
               toast.getView().setBackgroundTintList(ColorStateList.valueOf(Color.RED));
               toast.show();
           }
           });

        no.setOnClickListener(v -> {
            if (index <= questions.length - 1)
            {
                if (!answer[index])
                {
                    score++;
                }
                index++;
                if (index <= questions.length - 1)
                {
                    que.setText(questions[index]);
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Your score is: " + score + "/"+questions.length, Toast.LENGTH_SHORT);
                    toast.getView().setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                    toast.show();
                }

            }
            else
            {
                Toast toast = Toast.makeText(MainActivity.this, "Restart App again", Toast.LENGTH_SHORT);
                toast.getView().setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                toast.show();
            }
        });


    }
}