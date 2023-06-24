package miu.edu.service;

import miu.edu.model.PropertyOwner;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PropertyOwnerService {
    public PropertyOwner get(Integer id);
    public List<? extends PropertyOwner> findAll();
    public Page<? extends PropertyOwner> getAll(String searchString, Integer page, Integer pageSize);
}
