package com.example.demo;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	void testInsert(){
		User user = User.builder().name("yongChuTaFei").age(26).email("info@cherrynova.net").build();
		userMapper.insert(user);
	}
}
