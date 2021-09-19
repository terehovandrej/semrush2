package ru.semrush.model;


import java.util.Objects;

public class PostData {
    private String category;
    private String timeToRead;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostData postData = (PostData) o;
        return Objects.equals(category, postData.category) && Objects.equals(timeToRead, postData.timeToRead) && Objects.equals(tittle, postData.tittle) && Objects.equals(description, postData.description) && Objects.equals(author, postData.author) && Objects.equals(date, postData.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, timeToRead, tittle, description, author, date);
    }

    private String tittle;
    private String description;
    private String author;
    private String date;


    public PostData withCategory(String category) {
        this.category = category;
        return this;
    }

    public PostData withTimeToRead(String timeToRead) {
        this.timeToRead = timeToRead;
        return this;
    }

    public PostData withTittle(String tittle) {
        this.tittle = tittle;
        return this;
    }

    public PostData withDescription(String description) {
        this.description = description;
        return this;
    }

    public PostData withAuthor(String author) {
        this.author = author;
        return this;
    }

    public PostData withDate(String date) {
        this.date = date;
        return this;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "PostData{" +
                "category='" + category + '\'' +
                ", timeToRead='" + timeToRead + '\'' +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getTimeToRead() {
        return timeToRead;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}
