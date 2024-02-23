package com.Tree_dev.workout_done.post.entity;

import com.Tree_dev.workout_done.audit.BaseEntity;
import com.Tree_dev.workout_done.registration.RegistrationPost;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String content;


    @OneToMany(mappedBy = "post")
    private List<RegistrationPost> registrationPosts = new ArrayList<>();


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
