package com.sxl.dao;
import java.util.List;
import com.sxl.model.Shopcar;
public interface ShopcarDao {
    List<Shopcar> queryForList(Shopcar shopcar);
    Integer countAll(Shopcar shopcar);
    int delete(Long id);
    Shopcar getById(Long id);
    int update(Shopcar shopcar);
    int insert(Shopcar shopcar);
}
