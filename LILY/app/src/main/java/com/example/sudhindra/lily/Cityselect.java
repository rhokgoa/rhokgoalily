package com.example.sudhindra.lily;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cityselect extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityselect);
    }

    public void onClick(View v)
    {
        EditText x = (EditText)findViewById(R.id.editText);
        if(x.getText().toString().equals("Bangalore"))
        {
            startActivity(new Intent(Cityselect.this, Dropper.class));
            //Toast.makeText(getApplicationContext(), "Enter Bangalore", Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(), x.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }

}
