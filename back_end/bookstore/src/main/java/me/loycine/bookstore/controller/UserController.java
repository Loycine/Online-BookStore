package me.loycine.bookstore.controller;

import me.loycine.bookstore.common.api.JsonResult;
import me.loycine.bookstore.common.model.User;
import me.loycine.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    private UserServiceImpl userService;

    @Autowired
    public CommonController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    public String index() {
        return "test";
    }


    @PostMapping("/authentication")
    public ResponseEntity<JsonResult<?>> login(User user){
        String jwt = userService.login(user);
        JsonResult<?> result = new JsonResult<>(user, "登陆成功");
        System.out.println("return user : " + user);
        return ResponseEntity.ok().header("Authorization", jwt).body(result);
    }
}
