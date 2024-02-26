package com.Tree_dev.workout_done.board.mapper;

import com.Tree_dev.workout_done.board.entity.Board;
import com.Tree_dev.workout_done.board.entity.BoardPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board boardPostDtoToBoard(BoardPostDto boardPostDto);

}