package com.sxl.dao;
import java.util.List;
import com.sxl.model.Address;
public interface AddressDao {
    List<Address> queryForList(Address address);
    Integer countAll(Address address);
    int delete(Long id);
    Address getById(Long id);
    int update(Address address);
    int insert(Address address);
}
