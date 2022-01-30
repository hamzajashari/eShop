package com.onlineshop.onlineshop.service;

import com.onlineshop.onlineshop.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
        List<Manufacturer> findAll();
        Optional<Manufacturer> findById(Long id);
        Optional<Manufacturer> save(String name,String address);
        void deleteById(Long id);
}
