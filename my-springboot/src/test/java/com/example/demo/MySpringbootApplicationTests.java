package com.example.demo;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MySpringbootApplicationTests {

	@Resource
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void mySqlTest() {
		String sql = "select id, name, password from user_model";
		List<UserModel> userList =(List<UserModel>) jdbcTemplate.query(sql, new RowMapper<UserModel>() {
			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel userModel = new UserModel();
				userModel.setId(rs.getString("id"));
				userModel.setName(rs.getString("name"));
				userModel.setPassword(rs.getString("password"));
				return userModel;
			}
		});
		System.out.println("MySQL查询测试成功");
		for(UserModel user :userList) {
			System.out.println("<id>:" + user.getId() + "; <name>:" + user.getName());
		}
	}

	@Resource
	private UserService userService;

	@Test
	public void jpaTest() {
		//查询所有数据
		List<UserModel> userList = userService.findAll();
		System.out.println("findAll() :" + userList.size());
		//通过name查询数据
		List<UserModel> userList2 = userService.findByName("tyler");
		System.out.println("findByName() :" + userList2.size());
		Assert.isTrue(userList2.get(0).getName().equals("tyler"), "data error!");
		//通过name模糊查询数据
		List<UserModel> userList3 = userService.findByNameLike("%ty%");
		System.out.println("findByNameLike() :" + userList3.size());
		Assert.isTrue(userList3.get(0).getName().equals("tyler"), "data error!");
		//通过id列表查询数据
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		List<UserModel> userList4 = userService.findByIdIn(ids);
		System.out.println("findByIdIn() :" + userList4.size());
		//分页查询数据
		PageRequest pageRequest = PageRequest.of(0, 10);
		Page<UserModel> userList5 = userService.findAll(pageRequest);
		System.out.println("page findAll():" + userList5.getTotalPages() + "/" + userList5.getSize());
		//新增数据
		UserModel ayUser = new UserModel();
		ayUser.setId("3");
		ayUser.setName("test");
		ayUser.setPassword("123");
		userService.save(ayUser);
		//删除数据
		userService.delete("3");

	}

	@Test
	public void transactionTest() {
		/*
		在给save方法添加事务之后，主动给方法引入一个空指针异常，
		由于发生了异常，因此数据会回滚，数据库内不会添加这条记录
		 */
		UserModel ayUser = new UserModel();
		ayUser.setId("3");
		ayUser.setName("小明");
		ayUser.setPassword("123");
		userService.save(ayUser);
	}

	@Resource
	private RedisTemplate redisTemplate;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void redisTest(){
		
		//添加数据
		redisTemplate.opsForValue().set("name", "tyler");
		String name = (String)redisTemplate.opsForValue().get("name");
		System.out.println(name);

		redisTemplate.opsForValue().set("name", "al");

		name = stringRedisTemplate.opsForValue().get("name");
		System.out.println(name);

		redisTemplate.delete("name");
		name = stringRedisTemplate.opsForValue().get("name");
		System.out.println(name);
	}

}