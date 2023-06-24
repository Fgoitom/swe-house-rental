package miu.edu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import miu.edu.model.Company;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c, PropertyOwner l , User u where c.PropertyOwnerName = l.PropertyOwnerName and l.systemUser.username = :searchString  or c.phoneNumber =:searchString or c.PropertyOwnerName = :searchString or " +
            "c.companyName = :searchString")
    Page<Company> searchCompany(String searchString, PageRequest pageRequest);
}
