package com.sxl.dao;
import java.util.List;
import com.sxl.model.Bq;
public interface BqDao {
    List<Bq> queryForList(Bq bq);
    Integer countAll(Bq bq);
    int delete(Long id);
    Bq getById(Long id);
    int update(Bq bq);
    int insert(Bq bq);
}
