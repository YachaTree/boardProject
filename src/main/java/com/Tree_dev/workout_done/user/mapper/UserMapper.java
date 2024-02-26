package com.Tree_dev.workout_done.user.mapper;

import com.Tree_dev.workout_done.user.entity.User;
import com.Tree_dev.workout_done.user.entity.UserBoardDto;
import com.Tree_dev.workout_done.user.entity.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userBoardDtoToUser(UserBoardDto userBoardDto);

    UserResponseDto userToUserResponseDto(User user);

}

