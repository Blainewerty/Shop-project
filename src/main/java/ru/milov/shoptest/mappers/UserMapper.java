package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

}
