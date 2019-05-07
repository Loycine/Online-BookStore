package me.loycine.bookstore.mapper;

import me.loycine.bookstore.common.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countUserByNameAndPassword(@Param("user") User user);
}
