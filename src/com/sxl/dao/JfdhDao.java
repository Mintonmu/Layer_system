package com.sxl.dao;
import java.util.List;
import com.sxl.model.Jfdh;
public interface JfdhDao {
    List<Jfdh> queryForList(Jfdh jfdh);
    Integer countAll(Jfdh jfdh);
    int delete(Long id);
    Jfdh getById(Long id);
    int update(Jfdh jfdh);
    int insert(Jfdh jfdh);
}
