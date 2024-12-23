package ru.netology.springjdbcdao.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.netology.springjdbcdao.repository.RepositoryJDBC;

@Service
@RequiredArgsConstructor
public class ServiceJDBC {
    private final RepositoryJDBC repositoryJDBC;

    public List<String> getProductName(String name) {
        return repositoryJDBC.getProductName(name);
    }
}