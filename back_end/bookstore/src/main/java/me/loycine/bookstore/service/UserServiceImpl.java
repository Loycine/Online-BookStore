package me.loycine.bookstore.service;
import me.loycine.bookstore.common.model.User;
import me.loycine.bookstore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp {
    @Autowired
    private UserMapper userMapper;

    public String login(User user) {
        int count = userMapper.countUserByNameAndPassword(user);
//        int count =  0;
//        if(user.getUsername().equals("loycine") && user.getPassword().equals("123456"))
//        {
//            count = 1;
//        }
        if(count <= 0)
        {
            return "Failed";
        }
        return "Success";
    }
}
