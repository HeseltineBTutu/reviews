package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="review")


public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")

    private Product product;
    @Column(name = "AUTHOR")
    private String authorName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CreatedAt")
    private LocalDate createDate;
    @Column(name ="REVIEW")
    private String review;
    @Column(name = "Score")
    private Integer reviewScore;
    @OneToMany(mappedBy = "review")

    @JsonManagedReference
    private List<Comment> comments;

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;


    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", product=" + product +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", review='" + review + '\'' +
                ", comments=" + comments +
                '}';
    }
}
