package com.mate_matcher.storage;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class DftMovie {
    private ObjectId id;
    private String name;
    private String email;
    private ObjectId movieId;
    private String text;
    private Date date;

    // No-argument constructor
    public DftMovie() {
    }

    // All-arguments constructor
    public DftMovie(ObjectId id, String name, String email, ObjectId movieId, String text, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.movieId = movieId;
        this.text = text;
        this.date = date;
    }

    // Getter and Setter for id
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for movieId
    public ObjectId getMovieId() {
        return movieId;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
    }

    // Getter and Setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Optional: Override toString, equals, and hashCode if needed
    @Override
    public String toString() {
        return "DftMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", movieId=" + movieId +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DftMovie dftMovie = (DftMovie) o;

        if (!Objects.equals(id, dftMovie.id)) return false;
        if (!Objects.equals(name, dftMovie.name)) return false;
        if (!Objects.equals(email, dftMovie.email)) return false;
        if (!Objects.equals(movieId, dftMovie.movieId)) return false;
        if (!Objects.equals(text, dftMovie.text)) return false;
        return Objects.equals(date, dftMovie.date);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
