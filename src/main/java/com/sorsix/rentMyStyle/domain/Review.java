package com.sorsix.rentMyStyle.domain;
import java.time.LocalDate;

public class Review {
    private Integer id;
    private String description;
    private User author;
    private Item itemAbout;
    private LocalDate date;

    public Review(){
    }

    public Review(Integer id, String description, User author, Item itemAbout, LocalDate date) {
        this.id = id;
        this.description = description;
        this.author = author;
        this.itemAbout = itemAbout;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Item getItemAbout() {
        return itemAbout;
    }

    public void setItemAbout(Item itemAbout) {
        this.itemAbout = itemAbout;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", itemAbout=" + itemAbout +
                ", date=" + date +
                '}';
    }
}
