package com.sorsix.rentMyStyle.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    //private List<Item> ownRentedItems;
    //private List<Item> givenItems;

    public User(){
    }

    public User(String id, String name /*List<Item> ownRentedItems, List<Item> givenItems*/) {
        this.id = id;
        this.name = name;
        //this.ownRentedItems = ownRentedItems;
        //this.givenItems = givenItems;
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

//    public List<Item> getOwnRentedItems() {
//        return ownRentedItems;
//    }
//
//    public void setOwnRentedItems(List<Item> ownRentedItems) {
//        this.ownRentedItems = ownRentedItems;
//    }
//
//    public List<Item> getGivenItems() {
//        return givenItems;
//    }
//
//    public void setGivenItems(List<Item> givenItems) {
//        this.givenItems = givenItems;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", rating=" + rating +
//                ", ownRentedItems=" + ownRentedItems +
//                ", givenItems=" + givenItems +
//                '}';
//    }
}
