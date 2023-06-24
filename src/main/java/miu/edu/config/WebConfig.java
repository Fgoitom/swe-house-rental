package miu.edu.config;

import miu.edu.controller.converters.StringToPropertyOwnerConverterFactory;
import miu.edu.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    PropertyOwnerService PropertyOwnerService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new StringToPropertyOwnerConverterFactory(PropertyOwnerService));
    }
}
