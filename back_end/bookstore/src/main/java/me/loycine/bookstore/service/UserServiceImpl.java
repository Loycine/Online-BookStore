package me.loycine.bookstore.service;
import me.loycine.bookstore.entity.User;
import me.loycine.bookstore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.selectUser(username,password);
        //System.out.println(user.toString());
            if(user != null ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean register(User user) {
        return false;
    }


}
