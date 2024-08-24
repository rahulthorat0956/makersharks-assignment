package com.makershark.demo.service;

import com.makershark.demo.model.Supplier;
import com.makershark.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, String manufacturingProcesses, Pageable pageable) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(location, natureOfBusiness, manufacturingProcesses, pageable);
    }
}
