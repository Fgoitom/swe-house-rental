package miu.edu.controller.converters;

import miu.edu.service.PropertyOwnerService;
import miu.edu.model.PropertyOwner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToPropertyOwnerConverterFactory
        implements ConverterFactory<String, PropertyOwner> {

    PropertyOwnerService PropertyOwnerService;
    public StringToPropertyOwnerConverterFactory(PropertyOwnerService PropertyOwnerService){
        this.PropertyOwnerService = PropertyOwnerService;
    }
    @Override
    public <T extends PropertyOwner> Converter<String, T> getConverter(Class<T> targetClass) {
        return new StringToPropertyOwnerConverter<>(PropertyOwnerService);
    }

    private static class StringToPropertyOwnerConverter<T extends PropertyOwner>
            implements Converter<String, T> {
        private PropertyOwnerService PropertyOwnerService;
        public StringToPropertyOwnerConverter(PropertyOwnerService PropertyOwnerService) {
            this.PropertyOwnerService = PropertyOwnerService;
        }

        @Override
        public T convert(String source) {
            Integer id = Integer.parseInt(source);
            return (T) PropertyOwnerService.get(id);
        }
    }
}