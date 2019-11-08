package com.qf.mapper;

import com.qf.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> getListBySearch(User user);
    public List<User> getListBySearch2(User user);
    public int updateUser(User user);
    public List<User> getListByIn(List<Integer> ids);
    public List<User> getListByIn2(int[] ids);
    public List<User> getListByIn3(Map<String,Object> map);
}
