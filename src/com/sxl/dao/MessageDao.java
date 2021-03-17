package com.sxl.dao;
import java.util.List;
import com.sxl.model.Message;
public interface MessageDao {
    List<Message> queryForList(Message message);
    Integer countAll(Message message);
    int delete(Long id);
    Message getById(Long id);
    int update(Message message);
    int insert(Message message);
}
