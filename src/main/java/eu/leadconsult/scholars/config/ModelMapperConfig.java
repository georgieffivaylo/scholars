package eu.leadconsult.scholars.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
        configuration.setFieldMatchingEnabled(true);
        configuration.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PACKAGE_PRIVATE);
        return modelMapper;
    }
}
