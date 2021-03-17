package com.sxl.dao;
import java.util.List;
import com.sxl.model.Sc;
public interface ScDao {
    List<Sc> queryForList(Sc sc);
    Integer countAll(Sc sc);
    int delete(Long id);
    Sc getById(Long id);
    int update(Sc sc);
    int insert(Sc sc);
}
