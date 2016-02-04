package com.example.derrickhu.crunchtime;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Part 1
        Button clickButton = (Button) findViewById(R.id.convert);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                String exercise = spinner.getSelectedItem().toString();
                EditText input1 = (EditText) findViewById(R.id.input1);
                if (input1.getText().toString().length() != 0) {
                    int number = Integer.valueOf(input1.getText().toString());
                    if (input1.length() != 0 && exercise.length() != 0) {
                        Log.d("HI", Integer.toString(convertNumberToCalories(number, exercise)));

                        int calories = convertNumberToCalories(number, exercise);
                        TextView output = (TextView) findViewById(R.id.output);
                        output.setText(Integer.toString(calories));
                    }
                } else {
                    TextView output = (TextView) findViewById(R.id.output);
                    output.setText("Please type in a number");
                }
            }
        });

        //Part 2
        Button clickButton2 = (Button) findViewById(R.id.convert2);
        clickButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                String exercise2 = spinner2.getSelectedItem().toString();
                Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
                String exercise3 = spinner3.getSelectedItem().toString();
                EditText input2 = (EditText) findViewById(R.id.input2);
                if (input2.getText().toString().length() != 0) {
                    int number2 = Integer.valueOf(input2.getText().toString());
                    if (input2.length() != 0) {
                        Log.d("HI", Integer.toString(convertNumberToCalories(number2, exercise2)));

                        int calories = convertNumberToCalories(number2, exercise2);

                        int numExercises = convertCaloriesToExercises(calories, exercise3);
                        TextView output2 = (TextView) findViewById(R.id.output2);
                        output2.setText(Integer.toString(numExercises));
                    }
                }
                else {
                    TextView output2 = (TextView) findViewById(R.id.output2);
                    output2.setText("Please type in a number");
                }
            }
        });

        //Part 3
        Button clickButton3 = (Button) findViewById(R.id.convert3);
        clickButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
                String exercise4 = spinner4.getSelectedItem().toString();
                EditText input3 = (EditText) findViewById(R.id.input3);
                if (input3.getText().toString().length() != 0) {
                    int number3 = Integer.valueOf(input3.getText().toString());
                    if (input3.length() != 0) {
                        //Log.d("HI", Integer.toString(convertNumberToCalories(number3, exercise4)));


                        int numOfExercises = convertCaloriesToExercises(number3, exercise4);
                        TextView output3 = (TextView) findViewById(R.id.output3);
                        output3.setText(Integer.toString(numOfExercises));
                    }
                } else {
                    TextView output3 = (TextView) findViewById(R.id.output3);
                    output3.setText("Please type in a number");
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView parent, View view, int pos, long id) {
        String item = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView arg0) {

    }

    public int convertNumberToCalories(int input, String exercise) {
        if (exercise.equals("Minutes of Cycling")) {
            return numberToCal(input, 12);
        }
        if (exercise.equals("Minutes of Jogging")) {
            return numberToCal(input, 12);
        }
        if (exercise.equals("Minutes of Jumping Jacks")) {
            return numberToCal(input, 10);
        }
        if (exercise.equals("Minutes of Leg-Lifts")) {
            return numberToCal(input, 350);
        }
        if (exercise.equals("Minutes of Planks")) {
            return numberToCal(input, 25);
        }
        if (exercise.equals("Reps of Pullups")) {
            return numberToCal(input, 100);
        }
        if (exercise.equals("Reps of Pushups")) {
            return numberToCal(input, 350);
        }
        if (exercise.equals("Reps of Situps")) {
            return numberToCal(input, 200);
        }
        if (exercise.equals("Minutes of Stair-Climbing")) {
            return numberToCal(input, 15);
        }
        if (exercise.equals("Reps of Squats")) {
            return numberToCal(input, 225);
        }
        if (exercise.equals("Minutes of Swimming")) {
            return numberToCal(input, 13);
        }
        if (exercise.equals("Minutes of Walking")) {
            return numberToCal(input, 20);
        }
        else {
            return -1;
        }
    }

    public int numberToCal(int numberOfEx, int calsPerExercise) {
        return 100 * numberOfEx / calsPerExercise;
    }

    public int calToNumber(int calories, int calsPerExercise) {
        return calories * calsPerExercise / 100;
    }
    //Convert calories of original exercise to NEW exercise
    public int convertCaloriesToExercises(int calories, String exerciseToConvertTo) {
        if (exerciseToConvertTo.equals("Minutes of Cycling")) {
            return calToNumber(calories, 12);
        }
        if (exerciseToConvertTo.equals("Minutes of Jogging")) {
            return calToNumber(calories, 12);
        }
        if (exerciseToConvertTo.equals("Minutes of Jumping Jacks")) {
            return calToNumber(calories, 10);
        }
        if (exerciseToConvertTo.equals("Minutes of Leg-Lifts")) {
            return calToNumber(calories, 350);
        }
        if (exerciseToConvertTo.equals("Minutes of Planks")) {
            return calToNumber(calories, 25);
        }
        if (exerciseToConvertTo.equals("Reps of Pullups")) {
            return calToNumber(calories, 100);
        }
        if (exerciseToConvertTo.equals("Reps of Pushups")) {
            return calToNumber(calories, 350);
        }
        if (exerciseToConvertTo.equals("Reps of Situps")) {
            return calToNumber(calories, 200);
        }
        if (exerciseToConvertTo.equals("Minutes of Stair-Climbing")) {
            return calToNumber(calories, 15);
        }
        if (exerciseToConvertTo.equals("Reps of Squats")) {
            return calToNumber(calories, 225);
        }
        if (exerciseToConvertTo.equals("Minutes of Swimming")) {
            return calToNumber(calories, 13);
        }
        if (exerciseToConvertTo.equals("Minutes of Walking")) {
            return calToNumber(calories, 20);
        }
        else {
            return -1;
        }
    }




}