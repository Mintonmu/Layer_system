package com.sxl.dao;
import java.util.List;
import com.sxl.model.Bk;
public interface BkDao {
    List<Bk> queryForList(Bk bk);
    Integer countAll(Bk bk);
    int delete(Long id);
    Bk getById(Long id);
    int update(Bk bk);
    int insert(Bk bk);
}
