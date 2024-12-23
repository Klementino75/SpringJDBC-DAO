package ru.netology.springjdbcdao.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.springjdbcdao.service.ServiceJDBC;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ControllerJDBC {
    private final ServiceJDBC serviceJDBC;

    @GetMapping("/fetch-product")
    public List<String> getProductName(@RequestParam(value = "name", required = false) String name) {
        return serviceJDBC.getProductName(name);
    }
}