package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * @Author Heseltine Tutu
 * @Date 10/07/2020
 *
 */

@Entity
@Table(name="comment_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="review_id")
    @JsonBackReference
    private Review review;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "likes")
    private long likes;
    @Column(name = "dislikes")
    private long dislikes;
    @Column(name ="comment")
    private String comment;
//getter and setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id)  {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", review=" + review +
                ", feedback" + feedback +
                ", comment='" + comment + '\'' +
                '}';
    }
}
