package com.example.retrofit;

import java.util.List;

public class Movie {
    private String id;
    private double rating;
    private String title;
    private String poster;
    private String overview;
    private long release_date;
    private List<String> genres;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    public long getReleaseDate() { return release_date; }
    public void setReleaseDate(long release_date) { this.release_date = release_date; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }
}
