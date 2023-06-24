package miu.edu.controller.converters;

import miu.edu.service.LegalEntityService;
import miu.edu.model.LegalEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToLegalEntityConverterFactory
        implements ConverterFactory<String, LegalEntity> {

    LegalEntityService legalEntityService;
    public StringToLegalEntityConverterFactory(LegalEntityService legalEntityService){
        this.legalEntityService = legalEntityService;
    }
    @Override
    public <T extends LegalEntity> Converter<String, T> getConverter(Class<T> targetClass) {
        return new StringToLegalEntityConverter<>(legalEntityService);
    }

    private static class StringToLegalEntityConverter<T extends LegalEntity>
            implements Converter<String, T> {
        private LegalEntityService legalEntityService;
        public StringToLegalEntityConverter(LegalEntityService legalEntityService) {
            this.legalEntityService = legalEntityService;
        }

        @Override
        public T convert(String source) {
            Integer id = Integer.parseInt(source);
            return (T) legalEntityService.get(id);
        }
    }
}