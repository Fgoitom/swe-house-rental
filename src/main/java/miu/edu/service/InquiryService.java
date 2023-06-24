package miu.edu.service;

import java.util.List;

import miu.edu.model.Inquiry;
import org.springframework.data.domain.Page;

public interface InquiryService {
    public Inquiry save(Inquiry inquiry);
    public Inquiry getById(Integer id);
    public void deleteById(Integer id);
    public List<Inquiry> findAll();
    public Page<Inquiry> getAll(String searchString, Integer page, Integer pageSize);
}
