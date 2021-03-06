package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

}
