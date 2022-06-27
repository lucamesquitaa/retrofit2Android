package com.lucamesquitaa.testretrofit2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView listResult;
    private TextView txtUserId;
    private TextView txtId;
    private TextView txtTitle;
    private TextView txtBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listResult = (ListView) findViewById( R.id.list_result);
        txtUserId = findViewById(R.id.txt_userid);
        txtId = findViewById(R.id.txt_id);
        txtTitle = findViewById(R.id.txt_title);
        txtBody = findViewById(R.id.txt_body);

        getData();


    }

    private void getData() {
        Retrofit retrofitClient = NetworkUtils
                .getRetrofitInstance("https://jsonplaceholder.typicode.com");

         Endpoint endpoint = retrofitClient.create(Endpoint.class);

        Call<List<Posts>> callback = endpoint.getPosts();

        callback.enqueue(new Callback<List<Posts>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Posts> posts = (List<Posts>) response.body();

                ArrayAdapter<Posts> adapter = new ArrayAdapter<Posts> ( MainActivity.this , android.R.layout.simple_list_item_1, posts );

                listResult.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "t.message", Toast.LENGTH_SHORT).show();
            }
        });
    }


}