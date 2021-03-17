package com.sxl.dao;
import java.util.List;
import com.sxl.model.Lbt;
public interface LbtDao {
    List<Lbt> queryForList(Lbt lbt);
    Integer countAll(Lbt lbt);
    int delete(Long id);
    Lbt getById(Long id);
    int update(Lbt lbt);
    int insert(Lbt lbt);
}
