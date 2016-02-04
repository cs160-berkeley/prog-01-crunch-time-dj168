package com.example.derrickhu.crunchtime;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by derrickhu on 1/31/16.
 */
public class CustomOnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
