package me.loycine.bookstore.service;

import me.loycine.bookstore.entity.User;

/**
 * @author: Xiangzi
 * @date: 2019/5/13 16:34
 * @description:
 */
public interface UserService {
    //用户登录
    public boolean login(String username, String password);
    public boolean register(User user);
}
