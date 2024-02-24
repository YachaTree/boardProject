package com.Tree_dev.workout_done.board.entity;

import com.Tree_dev.workout_done.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(length = 200)
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "board")
    final private List<Post> posts = new ArrayList<>();

    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
