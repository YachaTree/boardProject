package com.Tree_dev.workout_done.review;

import com.Tree_dev.workout_done.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postReviewId;

    @Column(nullable = false)
    private int numberOfReviews;

    @Column(nullable = false)
    private int rating;

    @OneToOne
    @JoinColumn(name = "postId")
    private Post post;

    public PostReview(int numberOfReviews, int rating, Post post) {
        this.numberOfReviews = numberOfReviews;
        this.rating = rating;
        this.post = post;
    }
}