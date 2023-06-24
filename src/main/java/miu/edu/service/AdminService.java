package miu.edu.service;

import miu.edu.model.Admin;
import org.springframework.data.domain.Page;

import java.util.List;
public interface AdminService {
    public Admin save(Admin admin);
    public Admin getById(Integer id);
    public void deleteById(Integer id);
    public List<Admin> findAll();
    public Page<Admin> getAll(String searchString, Integer page, Integer pageSize);}
