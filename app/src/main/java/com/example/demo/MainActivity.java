package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    dataadapter dataadapter;
    RecyclerView.LayoutManager layoutManager;


    List<Object> data;

    RequestQueue rq;

    String request_url = "https://jsonplaceholder.typicode.com/users";
    //    List<demodata> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);
        data = new ArrayList<>();
        rq = Volley.newRequestQueue(this);
        rv1.setLayoutManager(new GridLayoutManager(this,1));
        rv1.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        rv1.setLayoutManager(layoutManager);

        sendRequest();

//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://jsonplaceholder.typicode.com/users", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
////                    dpmainprogress.setVisibility(View.GONE);
//                    JSONArray jsonArray = new JSONArray(response);
////                    Log.d("abc",response);
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        demodata model = new demodata();
//                        model.setUser(jsonObject.getString("username"));
////                        model.setName(jsonObject.getString("name"));
////                        model.setAddress(jsonObject.getString("address"));
////                        model.setMobile(jsonObject.getString("phone"));
////                        model.add(jsonObject.getString("image"));
//                        data.add(model);
//                        Log.d("abc",model.getUser());
//                    }
//                    dataadapter = new dataadapter(MainActivity.this, data);
//                    rv1.setAdapter(dataadapter);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//
//                HashMap map = new HashMap();
//                return map;
//            }
//        };
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        queue.add(stringRequest);
    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    demodata model = new demodata();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        model.setUser(jsonObject.getString("username"));
                        model.setName(jsonObject.getString("name"));
                        model.setAmodel(jsonObject.getJSONObject("address"));
                        model.setEmail(jsonObject.getString("email"));
                        model.setMobile(jsonObject.getString("phone"));
//                        model.setMobile(jsonObject.getString("phone"));
//                        model.setMobile(jsonObject.getString("phone"));
                        data.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//
//                    data.add(model);

                }

                dataadapter = new dataadapter(MainActivity.this, data);
                    rv1.setAdapter(dataadapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Log.i("Volley Error: ", error);
            }
        });

        rq.add(jsonArrayRequest);

    }



}



