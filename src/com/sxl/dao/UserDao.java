package com.sxl.dao;
import java.util.List;
import com.sxl.model.User;
public interface UserDao {
    List<User> queryForList(User user);
    Integer countAll(User user);
    int delete(Long id);
    User getById(Long id);
    int update(User user);
    int insert(User user);
}
