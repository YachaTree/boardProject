package com.Tree_dev.workout_done.user.entity;

import com.Tree_dev.workout_done.audit.BaseEntity;
import com.Tree_dev.workout_done.registration.Registration;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;


    @OneToMany(mappedBy = "user")
    private List<Registration> registrations = new ArrayList<>();

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

}
