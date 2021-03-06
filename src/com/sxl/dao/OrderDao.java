package com.sxl.dao;
import java.util.List;
import com.sxl.model.Order;
public interface OrderDao {
    List<Order> queryForList(Order order);
    Integer countAll(Order order);
    int delete(Long id);
    Order getById(Long id);
    int update(Order order);
    int insert(Order order);
}
