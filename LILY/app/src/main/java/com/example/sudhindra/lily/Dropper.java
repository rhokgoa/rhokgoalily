package com.example.sudhindra.lily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Dropper extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Click to Select Area","Malleshwaram", "Hebbal","Nagarabavi","MGRoad","Banashankari", "BTMLayout"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                break;
            case 1:
                Intent intent = new Intent(this,Result.class);
                intent.putExtra("keyName","Malleshwaram");
                startActivity(intent);
                break;
            case 2:
                Intent intent1 = new Intent(this,Result.class);
                intent1.putExtra("keyName","Hebbal");
                startActivity(intent1);
                break;
            case 3:
                Intent intent2 = new Intent(this,Result.class);
                intent2.putExtra("keyName","Nagarabavi");
                startActivity(intent2);
                break;

            case 4:
                Intent intent3 = new Intent(this,Result.class);
                intent3.putExtra("keyName", "MGRoad");
                startActivity(intent3);
                break;

            case 5:
                Intent intent4 = new Intent(this,Result.class);
                intent4.putExtra("keyName","Banashankari");
                startActivity(intent4);
                break;

            case 6:
                Intent intent5 = new Intent(this,Result.class);
                intent5.putExtra("keyName","Nagarabavi");
                startActivity(intent5);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}

