package com.sorsix.rentMyStyle.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany()
    @JoinColumn(name = "fk_users")
    private List<Item> itemsToGive = new ArrayList<>();

    @OneToMany()
    @JoinColumn(name = "fk_users_about")
    private List<Review> reviewsForUser = new ArrayList<>();

    public User(){
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemsToGive() {
        return itemsToGive;
    }

    public void setItemsToGive(List<Item> itemsToGive) {
        this.itemsToGive = itemsToGive;
    }

    public List<Review> getReviewsForUser() {
        return reviewsForUser;
    }

    public void setReviewsForUser(List<Review> reviewsForUser) {
        this.reviewsForUser = reviewsForUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemsToGive=" + itemsToGive +
                ", reviewsForUser=" + reviewsForUser +
                '}';
    }
}
