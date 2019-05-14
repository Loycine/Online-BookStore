package me.loycine.bookstore.controller;

import me.loycine.bookstore.common.api.JsonResult;
import me.loycine.bookstore.entity.User;
import me.loycine.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/test")
    public String index() {
        return "test";
    }


//    @PostMapping("/authentication")
//    public ResponseEntity<JsonResult<?>> login(User user){
//        String jwt = userService.login(user);
//        JsonResult<?> result = new JsonResult<>(user, "登陆成功");
//        System.out.println("return user : " + user);
//        return ResponseEntity.ok().header("Authorization", jwt).body(result);
//    }


    @PostMapping("/login")
    public Map<String,Object> login(User user){
        boolean state = userServiceImpl.login(user.getUsername(),user.getPassword());
        Map<String,Object> result = new HashMap<>();

        if(state == true){
            result.put("status",200);
            result.put("Message","success");
            result.put("data",user);

        }else{
            result.put("status",400);
            result.put("Message","failed");
            result.put("data",user);
        }
        return result;
    }


}
