package com.example.android.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView weekOne = (TextView) findViewById(R.id.week_one);
        TextView weekTwo = (TextView) findViewById(R.id.week_two);
        TextView weekThree = (TextView) findViewById(R.id.week_three);
        TextView weekFour = (TextView) findViewById(R.id.week_four);
        TextView weekFive = (TextView) findViewById(R.id.week_five);
        TextView weekSix = (TextView) findViewById(R.id.week_six);

        weekOne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekOneIntent = new Intent(MainActivity.this, WeekOneActivity.class);
                startActivity(weekOneIntent);
            }
        });

        weekTwo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekTwoIntent = new Intent(MainActivity.this, WeekTwoActivity.class);
                startActivity(weekTwoIntent);
            }
        });

        weekThree.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekThreeIntent = new Intent(MainActivity.this, WeekThreeActivity.class);
                startActivity(weekThreeIntent);
            }
        });

        weekFour.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekFourIntent = new Intent(MainActivity.this, WeekFourActivity.class);
                startActivity(weekFourIntent);
            }
        });

        weekFive.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekFiveIntent = new Intent(MainActivity.this, WeekFiveActivity.class);
                startActivity(weekFiveIntent);
            }
        });

        weekSix.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent weekSixIntent = new Intent(MainActivity.this, WeekSixActivity.class);
                startActivity(weekSixIntent);
            }
        });

    }
}
