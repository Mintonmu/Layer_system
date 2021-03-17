package com.sxl.dao;
import java.util.List;
import com.sxl.model.Contact;
public interface ContactDao {
    List<Contact> queryForList(Contact contact);
    Integer countAll(Contact contact);
    int delete(Long id);
    Contact getById(Long id);
    int update(Contact contact);
    int insert(Contact contact);
}
