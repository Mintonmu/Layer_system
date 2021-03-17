package com.sxl.dao;
import java.util.List;
import com.sxl.model.Xiaoxi;
public interface XiaoxiDao {
    List<Xiaoxi> queryForList(Xiaoxi xiaoxi);
    Integer countAll(Xiaoxi xiaoxi);
    int delete(Long id);
    Xiaoxi getById(Long id);
    int update(Xiaoxi xiaoxi);
    int insert(Xiaoxi xiaoxi);
}
