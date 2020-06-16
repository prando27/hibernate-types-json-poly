package com.example.hibernatetypesjsonpoly.infrastructure.http.jackson;

import com.example.hibernatetypesjsonpoly.domain.Cpf;
import com.example.hibernatetypesjsonpoly.domain.Email;
import com.example.hibernatetypesjsonpoly.domain.Name;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.CpfSerializer;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.EmailSerializer;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.NameSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RestObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(buildValueObjectModel());

        return mapper;
    }

    private SimpleModule buildValueObjectModel() {
        SimpleModule valueObjectsModule = new SimpleModule();
        valueObjectsModule.addSerializer(Name.class, new NameSerializer());
        valueObjectsModule.addSerializer(Cpf.class, new CpfSerializer());
        valueObjectsModule.addSerializer(Email.class, new EmailSerializer());

        return valueObjectsModule;
    }
}
