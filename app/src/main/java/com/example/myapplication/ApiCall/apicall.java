package com.example.myapplication.ApiCall;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class apicall {




    public static void getData(Context context, String api, final ApiCallback callback){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://jsonplaceholder.typicode.com/"+ api;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);

                        
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                callback.onError(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
    public interface ApiCallback{
        void onSuccess(String response);
        void onError(String error);

    }
}
