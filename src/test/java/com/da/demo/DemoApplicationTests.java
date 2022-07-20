package com.da.demo;

import com.da.demo.entity.User;
import com.da.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @DisplayName("测试mybatis-plus操作")
    @Test
    void contextLoads() {
//      查
        List<User> users =userMapper.selectList(null);
        users.forEach(System.out::println);
//      更新
        User root = new User(1,"root","password");
        int update = userMapper.update(root,null);
        System.out.println(update);
//      插
        User user = new User();
        user.setUsername("wangc");
        user.setPassword("1234");

        int insert = userMapper.insert(user);

        log.warn("insert--{}",insert);
        //删除
        int delete = userMapper.deleteById(2);

        log.warn("delete--{}",delete);


    }

}
