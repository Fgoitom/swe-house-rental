package miu.edu.service.impl;

import miu.edu.repository.CompanyRepository;
import miu.edu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import miu.edu.model.Company;

@Service
public class CompanyServiceImpl extends AbsBaseService implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company get(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    public Page<Company> getAll(String searchString, Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        if (searchString == null || searchString.isBlank())
            return companyRepository.findAll(pageRequest);
        else
            return companyRepository.searchCompany(searchString.toLowerCase(),  pageRequest);
    }
}
