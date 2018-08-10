package com.sorsix.rentMyStyle.domain;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {


    /*
        ALSO HERE CHANGES IN THE DB MADE SO THIS CAN WORK, BUT NEEDS TO BE DONE WITH THE CORRECT DEPENDENCY IN THE OTHER DB
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    //private User author;
    //private User userAbout
    //private LocalDate date;

    public Review(){
    }

    public Review(String description /*User author, Item itemAbout, LocalDate date*/) {
        this.description = description;
        //this.author = author;
        //this.itemAbout = itemAbout;
        //this.date = date;
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

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
//    public Item getItemAbout() {
//        return itemAbout;
//    }
//
//    public void setItemAbout(Item itemAbout) {
//        this.itemAbout = itemAbout;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    @Override
//    public String toString() {
//        return "Review{" +
//                "id=" + id +
//                ", description='" + description + '\'' +
//                ", author=" + author +
//                ", itemAbout=" + itemAbout +
//                ", date=" + date +
//                '}';
//    }
}
