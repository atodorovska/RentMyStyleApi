package com.sorsix.rentMyStyle.domain;
import javax.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "fk_users_author")
    private String author;

    @Column(name = "fk_users_about")
    private String userAbout;

    public Review(){
    }

    public Review(String description, String author, String userAbout) {
        this.description = description;
        this.author = author;
        this.userAbout = userAbout;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", userAbout='" + userAbout + '\'' +
                '}';
    }
}
