package com.da.demo.controller;


import com.da.demo.entity.User;
import com.da.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    UserMapper mapper;

    @GetMapping("list")//返回表中所有用户
    public List<User> getUsers(){
        return mapper.selectList(null);

    }

    @PostMapping("insert")//通过传来的用户信息插入用户
    public Boolean saveUser(@RequestBody User user){
        int i = mapper.insert(user);
        return i == 1;
    }
    @PutMapping("update")
    public Boolean updateUser(@RequestBody User user){
        int update = mapper.update(user, null);
        return update == 1;
    }

    @DeleteMapping("delete")
    public Boolean deleteUser(Integer id){
        int delete = mapper.deleteById(id);
        return delete == 1;

    }

}
