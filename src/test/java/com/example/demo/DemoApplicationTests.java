package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.entity.User;
@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;
	Long now = Instant.now().toEpochMilli();
	@Test
	void testInsert(){
		User user = User.builder()
				.name("yongChuTaFei")
				.age(26)
				.email("info@cherrynova.net")
				.createTime(now)
				.updateTime(now)
				.build();
		userMapper.insert(user);
	}

	@Test
	void testSelect(){
	User user = userMapper.selectById(24L);
	System.out.println(user.getName());
	}
	@Test
	void testUpdate(){
	User user = User.builder()
			.id(21L)
			.age(30)
			.build();
	userMapper.updateById(user);
	User user1 = userMapper.selectById(21L);
	System.out.println(user1.getName());
	}
	@Test
	void testDelete(){
	userMapper.deleteById(23L);
	}

	@Test
	void testQueryWrapper(){
//		常规查询
//		String email = "";
//		QueryWrapper queryWrapper = new QueryWrapper<>();
//		queryWrapper.between("age",10,40);
//		queryWrapper.eq(StringUtils.isNotBlank(email),"email",email);
//		queryWrapper.select("name","email");
//		List<User> users= userMapper.selectList(queryWrapper);
//		System.out.println(users.size());

//		通过传入一个实体对象进行查询
//		User user = User.builder()
//				.name("a")
//				.email("abc@a.com")
//				.build();
//		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
//		List<User> userList = userMapper.selectList(queryWrapper);
//		System.out.println(userList);

	}

	@Test
	void testQueryWrapper1(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		Map<String,Object> map = new HashMap<>();
		map.put("name","a");
		map.put("email","");
		queryWrapper.allEq(map,false);
		List<User> userList = userMapper.selectList(queryWrapper);
	}
	//使用Lambda查询条件
	@Test
	void testLambdaQueryWrapper(){
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.likeRight(User::getName,"a%");
		lambdaQueryWrapper.between(User::getAge,10,35);
		List<User> userList = userMapper.selectList(lambdaQueryWrapper);
		System.out.println(userList.size());
	}


	@Test
	void testUpdateWrapper(){
		UpdateWrapper updateWrapper = new UpdateWrapper<>();
		updateWrapper.ge("age","20");
		updateWrapper.likeRight("name","yo");
		updateWrapper.set("age","30");
		userMapper.update(updateWrapper);
	}

	@Test
	void testSelectRaw(){
		List<User> userList = userMapper.selectRaw();
		System.out.println(userList.size());
	}

}
