package com.Tree_dev.workout_done.comment.mapper;

import com.Tree_dev.workout_done.comment.entity.Comment;
import com.Tree_dev.workout_done.comment.entity.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentDtoToComment(CommentDto commentDto);
}