package trelloiii;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
@ComponentScan(basePackages = {"trelloiii","sql","Utils"},basePackageClasses =ConfigClass.class)
public class ConfigClass {
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofBytes(104857600));
        factory.setMaxRequestSize(DataSize.ofBytes(104857600));
        return factory.createMultipartConfig();
    }
}
