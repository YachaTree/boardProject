package com.Tree_dev.workout_done.post.mapper;

import com.Tree_dev.workout_done.post.entity.Post;
import com.Tree_dev.workout_done.post.entity.PostPatchDto;
import com.Tree_dev.workout_done.post.entity.PostResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post postPatchDtoToPost(PostPatchDto postPatchDto);

    PostResponseDto postToPostResponseDto(Post post);
}
