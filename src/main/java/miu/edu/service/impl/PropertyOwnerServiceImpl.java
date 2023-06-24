package miu.edu.service.impl;

import miu.edu.repository.CompanyRepository;
import miu.edu.repository.PersonRepository;
import miu.edu.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import miu.edu.model.PropertyOwner;
import miu.edu.model.Company;
import miu.edu.model.Person;

import java.util.List;
import java.util.ArrayList;

@Service
public class PropertyOwnerServiceImpl extends AbsBaseService implements PropertyOwnerService {
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<? extends PropertyOwner> findAll() {
        List<PropertyOwner> legalEntities = new ArrayList<>();
        personRepository.findAll().forEach(legalEntities::add);
        companyRepository.findAll().forEach(legalEntities::add);
        return legalEntities;
    }

    @Override
    public PropertyOwner get(Integer id) {
        PropertyOwner PropertyOwner = personRepository.findById(id).orElse(null);
        if(PropertyOwner == null){
            PropertyOwner = companyRepository.findById(id).orElse(null);
        }
        return PropertyOwner;
    }

    public Page<? extends PropertyOwner> getAll(String searchString, Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Company> resultCompany;
        Page<Person> resultPerson;
        //TODO: Query only the remainig page size for person
        if (searchString == null || searchString.isBlank()){
            resultCompany = companyRepository.findAll(pageRequest);
            resultPerson = personRepository.findAll(pageRequest);
        }
        else{
            resultCompany = companyRepository.searchCompany(searchString.toLowerCase(), pageRequest);
            resultPerson = personRepository.searchPerson(searchString.toLowerCase(), pageRequest);
        }
        List<PropertyOwner> resultList = new ArrayList<>();
        resultList.addAll(resultCompany.getContent());
        if(resultCompany.getNumberOfElements() < pageSize)
        {
            int remainigPageSize = pageSize - resultCompany.getNumberOfElements();
            List<Person> personContent = resultPerson.getContent();
            resultList.addAll(personContent.subList(0, remainigPageSize <= personContent.size() ? remainigPageSize : personContent.size()));
        }
        final Page<PropertyOwner> pageResult = new PageImpl<>(resultList, pageRequest, resultCompany.getTotalElements() + resultPerson.getTotalElements());
        
        return pageResult;
    }
}
