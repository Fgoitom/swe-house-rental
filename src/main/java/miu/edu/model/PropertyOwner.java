package miu.edu.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import miu.edu.model.constraints.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PropertyOwner_type", discriminatorType=DiscriminatorType.STRING)
public abstract class PropertyOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @PhoneNumberConstraint
    private String phoneNumber;
//    @Transient
    private String PropertyOwnerName;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @Nullable
    private User systemUser;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;    
    
    @Override
    public String toString() {
        return "PropertyOwner [id=" + id + ", phoneNumber=" + phoneNumber + ", PropertyOwnerName=" + PropertyOwnerName + ", systemUser=" + systemUser + "]";
    }

}
