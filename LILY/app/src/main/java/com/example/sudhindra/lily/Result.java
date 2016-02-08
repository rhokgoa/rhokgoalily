package com.example.sudhindra.lily;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Result extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String value = getIntent().getStringExtra("keyName");

        String url = "http://192.168.150.1/xampp/getindex.php?sec=" + value;
        Log.e("",url);
        final RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    double a = response.getDouble("rindex");
                    double b = response.getDouble("hindex");
                    double c = response.getDouble("eindex");
                    double d=(a+b+c)/3;
                    int m=(int)(d);
                    TextView x=(TextView)findViewById(R.id.textView2);
                    TextView y=(TextView)findViewById(R.id.textView3);
                    x.setText(String.valueOf(m));
                    if(m<=3 )
                        y.setText("There is no danger out there");
                    else if(m<5 )
                        y.setText("Be Cautious");
                    else if(m>=5 && m<8)
                        y.setText("It's okay to go out. " +
                                "Beware of eveteasing");
                    else y.setText("It's too dangerous out there." +
                                "Travel at your own risk");

                }catch(JSONException e)
                {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);

    }
}
