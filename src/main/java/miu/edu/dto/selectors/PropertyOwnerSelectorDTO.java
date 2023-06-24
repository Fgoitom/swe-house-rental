package miu.edu.dto.selectors;

import miu.edu.model.Company;
import miu.edu.model.PropertyOwner;
import miu.edu.model.Person;

public class PropertyOwnerSelectorDTO extends SelectorDTO<Integer, PropertyOwner> {

    public PropertyOwnerSelectorDTO(PropertyOwner entityObject) {
        super(entityObject);
    }
    @Override    
    public void setParentId(){
        this.id = entityObject.getId();
    }
    @Override
    public String getDisplayText() {
        return entityObject.getPropertyOwnerName();
    }

    @Override
    public Integer getId() {
        return entityObject.getId();
    }
    
    @Override
    public SelectorDTO<Integer, PropertyOwner> createDTOObject(PropertyOwner address){
        return new PropertyOwnerSelectorDTO(address);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj.getClass() == PropertyOwner.class || obj.getClass() == Person.class || obj.getClass() == Company.class))
        {
            return (obj.getClass() == this.getClass() && obj.equals(this));
        }
        PropertyOwner other = (PropertyOwner)obj;
        return this.id.equals(other.getId());
    }
}
