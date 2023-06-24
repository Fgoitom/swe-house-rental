package miu.edu.controller;

import miu.edu.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.model.Property;
import miu.edu.dto.paging.Page;
import miu.edu.dto.paging.PageArray;
import miu.edu.dto.paging.PagingRequest;

@RestController
@RequestMapping("properties")
public class PropertyRestController extends AbsBaseController {

    @Autowired
    private PropertyService propertyService;

    public PropertyRestController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public Page<Property> list(@RequestBody PagingRequest pagingRequest) {
        return propertyService.getProperties(pagingRequest);
    }

    @PostMapping("/array")
    public PageArray array(@RequestBody PagingRequest pagingRequest) {
        return propertyService.getPropertyArray(pagingRequest);
    }
}