package trelloiii;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
@ComponentScan(basePackages = {"trelloiii"},basePackageClasses =ConfigClass.class)
public class ConfigClass {
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize(DataSize.parse("10240KB"));
//        factory.setMaxRequestSize(DataSize.parse("102400KB"));
//        return factory.createMultipartConfig();
//    }
}