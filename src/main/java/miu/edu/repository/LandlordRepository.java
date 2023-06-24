package miu.edu.repository;

import miu.edu.model.Landlord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
    @Query("select l from Landlord l, Property p, PropertyOwner le where l.PropertyOwner = le and l.name =:text or p.name =:text or le.PropertyOwnerName =:text")
    Page<Landlord> searchLandlord(String text, PageRequest pageRequest);
}
