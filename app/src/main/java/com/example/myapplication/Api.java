package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.ApiCall.apicall;
import com.example.myapplication.databaseAdapter.ApiAdapter;
import com.example.myapplication.model.apiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Api extends AppCompatActivity {
    private Context context;
    RecyclerView apiList;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        apiList = findViewById(R.id.apiList);

        apicall.getData(this, "users", new apicall.ApiCallback() {
            @Override
            public void onSuccess(String response) {
                decodeJson(response);


            }

            @Override
            public void onError(String error) {
                Log.e("response error", "onError: " + error);
            }
        });


    }

    private void decodeJson(String response) {
        try {
            ArrayList<apiModel> data = new ArrayList<>();
//            JSONObject result = new JSONObject(response);
//            JSONArray array = result.getJSONArray("data");
            JSONArray array = new JSONArray(response);
            for (int i = 0; i < array.length(); i++) {
                JSONObject user = array.getJSONObject(i);
                int id = user.getInt("id");
                String name = user.getString("name");
                String phone = user.getString("phone");
                apiModel apiModel = new apiModel(id, name, phone);
                data.add(apiModel);
            }
            layoutManager = new LinearLayoutManager(this);
            apiList.setLayoutManager(layoutManager);
            ApiAdapter adapter= new ApiAdapter(Api.this, data);
            apiList.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}