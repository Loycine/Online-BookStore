package me.loycine.bookstore.mapper;

import me.loycine.bookstore.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUser(String username,String password);

}
