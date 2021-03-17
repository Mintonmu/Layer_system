package com.sxl.dao;
import java.util.List;
import com.sxl.model.Orderlist;
public interface OrderlistDao {
    List<Orderlist> queryForList(Orderlist orderlist);
    Integer countAll(Orderlist orderlist);
    int delete(Long id);
    Orderlist getById(Long id);
    int update(Orderlist orderlist);
    int insert(Orderlist orderlist);
}
