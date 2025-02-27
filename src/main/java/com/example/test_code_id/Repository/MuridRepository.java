package com.example.test_code_id.Repository;

import com.example.test_code_id.Model.Murid;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MuridRepository extends JpaRepository<Murid, Integer>, JpaSpecificationExecutor<Murid> {

}
