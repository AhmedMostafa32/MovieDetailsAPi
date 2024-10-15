package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.databinding.ActivitySendDataToApiBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SendDataToAPi extends AppCompatActivity {
    ActivitySendDataToApiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendDataToApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.inputName.getText().toString();
                String password = binding.inputJob.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SendDataToAPi.this, "Please enter both username and password", Toast.LENGTH_LONG).show();
                } else {
                    postToApi(username, password);
                }
            }
        });
    }

    private void postToApi(String name, String job) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")  // Replace with the correct base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiPost apiPost = retrofit.create(ApiPost.class);
        PostData postData = new PostData(name, job);

        Call<PostResponse> call = apiPost.createPost(postData);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SendDataToAPi.this, "Post Successful: " + response.code()+response.message(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SendDataToAPi.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Log the response code and message for debugging
                    Log.e("API_ERROR", "Response Code: " + response.code() + ", Message: " + response.message());
                    Toast.makeText(SendDataToAPi.this, "Failed to post data. Response code: " + response.code(), Toast.LENGTH_SHORT).show();
                    Log.e("API_ERROR", "Response Code: " + response.code() + ", Message: " + response.message());

                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                // Log the error message
                Log.e("API_ERROR", "Failed to post data: " + t.getMessage());
                Toast.makeText(SendDataToAPi.this, "Failed to post data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}