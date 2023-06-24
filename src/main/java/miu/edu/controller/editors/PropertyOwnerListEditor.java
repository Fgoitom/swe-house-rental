package miu.edu.controller.editors;

import java.beans.PropertyEditorSupport;

import miu.edu.service.PropertyOwnerService;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.ArrayList;
import jakarta.annotation.Nullable;
import miu.edu.model.PropertyOwner;

public class PropertyOwnerListEditor extends PropertyEditorSupport{
    PropertyOwnerService PropertyOwnerService;

	boolean allowEmpty;
    public PropertyOwnerListEditor(PropertyOwnerService PropertyOwnerService, boolean allowEmpty) {
        this.PropertyOwnerService = PropertyOwnerService;
        this.allowEmpty = allowEmpty;
	}

    @Override
	public void setAsText(@Nullable String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else {
			try {
                List<PropertyOwner> list = new ArrayList<>();
                for(String idString : StringUtils.tokenizeToStringArray(text, ",")){
                    list.add(PropertyOwnerService.get(Integer.parseInt(idString)));
                }
				setValue(list);
			}
			catch (Exception ex) {
				throw new IllegalArgumentException("Could not get Legal Entity %s: " + ex.getMessage(), ex);
			}
		}
	}	
}
