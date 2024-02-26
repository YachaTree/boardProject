package com.Tree_dev.workout_done.post.mapper;

import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.entity.PostPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postPostDTOToPost(PostPostDto postPostDto);

};