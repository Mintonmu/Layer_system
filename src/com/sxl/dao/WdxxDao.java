package com.sxl.dao;
import java.util.List;
import com.sxl.model.Wdxx;
public interface WdxxDao {
    List<Wdxx> queryForList(Wdxx wdxx);
    Integer countAll(Wdxx wdxx);
    int delete(Long id);
    Wdxx getById(Long id);
    int update(Wdxx wdxx);
    int insert(Wdxx wdxx);
}
