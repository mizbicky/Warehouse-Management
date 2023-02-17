package pl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.devices.DeviceConverter;
import pl.malfunctions.MalfunctionConverter;
import pl.parts.CategoryConverter;
import pl.parts.PartConverter;
import pl.warehouse.ShelfConverter;
import pl.workers.WorkerConverter;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "pl")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //Hibernate

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("bookstorePersistenceUnit");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }

    //views .jsp

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // validator

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        FixedLocaleResolver localeResolver = new FixedLocaleResolver(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Bean
    public DeviceConverter deviceConverter() {
        return new DeviceConverter();
    }

    @Bean
    public MalfunctionConverter malfunctionConverter() {
        return new MalfunctionConverter();
    }

    @Bean
    public CategoryConverter categoryConverter() {
        return new CategoryConverter();
    }

    @Bean
    public PartConverter partConverter() {
        return new PartConverter();
    }


    @Bean
    public ShelfConverter shelfConverter() {
        return new ShelfConverter();
    }

    @Bean
    public WorkerConverter workerConverter() {
        return new WorkerConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(deviceConverter());
        registry.addConverter(malfunctionConverter());
        registry.addConverter(categoryConverter());
        registry.addConverter(partConverter());
        registry.addConverter(shelfConverter());
        registry.addConverter(workerConverter());


    }
}
