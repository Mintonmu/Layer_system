package com.sxl.dao;
import java.util.List;
import com.sxl.model.Pinglun;
public interface PinglunDao {
    List<Pinglun> queryForList(Pinglun pinglun);
    Integer countAll(Pinglun pinglun);
    int delete(Long id);
    Pinglun getById(Long id);
    int update(Pinglun pinglun);
    int insert(Pinglun pinglun);
}
