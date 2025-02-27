package com.example.test_code_id.Repository;

import com.example.test_code_id.Model.Pendidikan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepository extends JpaRepository<Pendidikan,Integer> {
}
