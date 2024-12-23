package ru.netology.springjdbcdao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RepositoryJDBC {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RepositoryJDBC(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> getProductName(String name) {
        System.out.println(namedParameterJdbcTemplate.queryForList(read(), Map.of("name", name), String.class));
        return namedParameterJdbcTemplate.queryForList(read(), Map.of("name", name), String.class);
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("script.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}