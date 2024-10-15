package com.example.retrofit;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.retrofit.databinding.ActivityMovieDetailsBinding;

public class MovieDetailActivity extends AppCompatActivity {
    ActivityMovieDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve the intent and the extras
        if (getIntent() != null) {
            String movieTitle = getIntent().getStringExtra("movie_title");
            String moviePoster = getIntent().getStringExtra("movie_poster");
            String movieOverview = getIntent().getStringExtra("movie_overview");

            // Set the movie details in the UI
            binding.movieTitle.setText(movieTitle);  // Assuming you have this TextView in your layout
            binding.movieOverview.setText(movieOverview); // Assuming you have this TextView in your layout

            // Load the movie poster image using Glide
            if (moviePoster != null) {
                Glide.with(this)
                        .load(moviePoster)
                        .placeholder(R.drawable.ic_launcher_background) // Placeholder image
                        .error(R.drawable.ic_launcher_foreground) // Error image
                        .into(binding.moviePoster); // Assuming you have this ImageView in your layout
            }
        }
    }
}
