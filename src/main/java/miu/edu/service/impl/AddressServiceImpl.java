package miu.edu.service.impl;

import miu.edu.repository.AddressRepository;
import miu.edu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import miu.edu.model.Address;

import java.util.List;

@Service
public class AddressServiceImpl extends AbsBaseService implements AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address get(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public Page<Address> getAll(String searchString, Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        if(searchString == null || searchString.isBlank())
            return addressRepository.findAll(pageRequest);
        else
            return addressRepository.findByCityOrStateOrStreetNameOrZipContainingIgnoreCase(searchString, searchString, searchString, searchString, pageRequest);
    }
}
