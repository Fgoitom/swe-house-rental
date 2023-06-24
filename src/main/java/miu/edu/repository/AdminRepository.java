package miu.edu.repository;

import miu.edu.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "select a from Admin a , PropertyOwner l where a.PropertyOwner = l and a.name =:searchString or l.PropertyOwnerName =:searchString")
    Page<Admin> searchAdmin(String searchString, PageRequest pageRequest);
}
