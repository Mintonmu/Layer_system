package com.sxl.dao;
import java.util.List;
import com.sxl.model.Pinglun_product;
public interface Pinglun_productDao {
    List<Pinglun_product> queryForList(Pinglun_product pinglun_product);
    Integer countAll(Pinglun_product pinglun_product);
    int delete(Long id);
    Pinglun_product getById(Long id);
    int update(Pinglun_product pinglun_product);
    int insert(Pinglun_product pinglun_product);
}
