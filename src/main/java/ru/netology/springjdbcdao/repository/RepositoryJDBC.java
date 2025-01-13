package ru.netology.springjdbcdao.repository;

import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RepositoryJDBC {
    private final EntityManager entityManager;

    public List<String> getProductName(String name) {
        List<String> resultList = entityManager.createQuery(read(), String.class)
                .setParameter("name", name)
                .getResultList();
        resultList.forEach(System.out::println);
        return resultList;
//        // или так...
//        return entityManager.createQuery(read(), String.class)
//                .setParameter("name", name)
//                .getResultList();
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