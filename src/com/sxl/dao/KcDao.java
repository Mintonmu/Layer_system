package com.sxl.dao;
import java.util.List;
import com.sxl.model.Kc;
public interface KcDao {
    List<Kc> queryForList(Kc kc);
    Integer countAll(Kc kc);
    int delete(Long id);
    Kc getById(Long id);
    int update(Kc kc);
    int insert(Kc kc);
}
