package com.qf.mapper;

import com.qf.pojo.Course;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void testSelectSeach(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
           // user.setUname("1111");
            user.setUpwd("2222");
            List<User> userList = userMapper.getListBySearch(user);
            for (User u:userList){
                System.out.println(u);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectSeach2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUname("1111");
            user.setUpwd("2222");
            List<User> userList = userMapper.getListBySearch2(user);
            for (User u:userList){
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUid(5);
            //user.setUname("2222");
            user.setUpwd("3333");
            userMapper.updateUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectForeach(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(12);
            ids.add(3);
            ids.add(4);
            List<User> userList = userMapper.getListByIn(ids);
            for (User u:userList){
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectForeach2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int[] ids = new int[]{12,13,15,16};
            List<User> userList = userMapper.getListByIn2(ids);
            for (User u:userList){
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectForeach3(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<>();
            int[] ids = new int[]{12,13,15,16,27};
            String uname = "www";
            map.put("ids",ids);
            map.put("uname",uname);
            List<User> userList = userMapper.getListByIn3(map);
            for (User u:userList){
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectionMap(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> listByUserAndCourse = userMapper.getListByUserAndCourse();
            for(User u:listByUserAndCourse){
                System.out.println(u);
                for (Course c:u.getCourseList()){
                    System.out.println(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}