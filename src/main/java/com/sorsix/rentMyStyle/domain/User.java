package com.sorsix.rentMyStyle.domain;
import java.util.List;

public class User {
    private String id;
    private String name;
    private Integer rating;
    private List<Item> ownRentedItems;
    private List<Item> givenItems;

    public User(){
    }

    public User(String id, String name, Integer rating, List<Item> ownRentedItems, List<Item> givenItems) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.ownRentedItems = ownRentedItems;
        this.givenItems = givenItems;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Item> getOwnRentedItems() {
        return ownRentedItems;
    }

    public void setOwnRentedItems(List<Item> ownRentedItems) {
        this.ownRentedItems = ownRentedItems;
    }

    public List<Item> getGivenItems() {
        return givenItems;
    }

    public void setGivenItems(List<Item> givenItems) {
        this.givenItems = givenItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", ownRentedItems=" + ownRentedItems +
                ", givenItems=" + givenItems +
                '}';
    }
}
