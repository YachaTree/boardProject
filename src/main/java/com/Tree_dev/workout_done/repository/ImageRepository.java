package com.Tree_dev.workout_done.repository;

import com.Tree_dev.workout_done.domain.Image;
import com.Tree_dev.workout_done.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByMember(Member member);
}
