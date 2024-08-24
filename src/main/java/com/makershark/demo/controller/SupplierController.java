package com.makershark.demo.controller;

import com.makershark.demo.model.Supplier;
import com.makershark.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam String natureOfBusiness,
            @RequestParam String manufacturingProcesses,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcesses, pageable);
        return ResponseEntity.ok(suppliers);
    }
}

