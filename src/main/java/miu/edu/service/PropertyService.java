package miu.edu.service;

import miu.edu.model.Property;
import miu.edu.dto.paging.Page;
import miu.edu.dto.paging.PageArray;
import miu.edu.dto.paging.PagingRequest;
import java.util.List;

public interface PropertyService {
    public Property saveProperty(Property property);
    public Page<Property> getProperties(PagingRequest pagingRequest);
    public PageArray getPropertyArray(PagingRequest pagingRequest);
    public List<Property> getProperties();
    public Property getById(Integer id);
    public org.springframework.data.domain.Page<? extends Property> getAll(String searchString, Integer page, Integer pageSize);
}
