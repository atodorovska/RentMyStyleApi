package com.sorsix.rentMyStyle.domain;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Integer price;

    @Column(name = "size")
    private String size;


    /*
        *********************************************************************
        CHANGE IN DB WAS MADE SO THAT THIS CAN WORK, NOW NULL USER IS ALLOWED
        *********************************************************************

     */

    //private User owner;

    public Item(){
    }

    public Item(String name, String brand, String color, Integer price, String size/*, User owner*/) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size = size;
        //this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", brand='" + brand + '\'' +
//                ", color='" + color + '\'' +
//                ", price=" + price +
//                ", size='" + size + '\'' +
//                ", owner=" + owner +
//                '}';
//    }
}

