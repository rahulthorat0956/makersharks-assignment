package com.makershark.demo.repository;

import com.makershark.demo.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            String location,
            String natureOfBusiness,
            String manufacturingProcesses,
            Pageable pageable);
}
