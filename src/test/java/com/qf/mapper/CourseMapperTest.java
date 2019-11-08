package com.qf.mapper;

import com.qf.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CourseMapperTest {

    @Test
    public void testSelectCourse(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courseList = courseMapper.getCourseList();
            for(Course c :courseList){
                System.out.println(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}