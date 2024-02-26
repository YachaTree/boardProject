package com.Tree_dev.workout_done.registration;

import com.Tree_dev.workout_done.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus = RegisterStatus.REGISTER_REQUEST;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "registration", cascade = CascadeType.PERSIST)
    private List<RegistrationPost> registrationPosts = new ArrayList<>();

    public enum RegisterStatus {
        REGISTER_REQUEST(1, "신청"),
        REGISTER_COMPLETE(2, "신청 완료"),
        REGISTER_CANCEL(3, "신청 취소"),
        ;

        @Getter
        private int step;

        @Getter
        private String description;

        RegisterStatus(int step, String description) {
            this.step = step;
            this.description = description;
        }
    }
}
