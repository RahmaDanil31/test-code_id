package com.example.test_code_id.Service;

import com.example.test_code_id.Dto.MuridDto;
import com.example.test_code_id.Model.Murid;
import com.example.test_code_id.Repository.MuridRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuridService {

    @Autowired
    MuridRepository muridRepository;

    public List<Murid> get(MuridDto murid){

        return muridRepository.findAll();
    }

    public Murid save(Murid murid){
       return muridRepository.save(murid);
    }

    public Murid update(Murid murid){
        if(muridRepository.findById(murid.getId()).isPresent()){
            muridRepository.save(murid);
        }
        return  null;
    }

    public void delete(Integer id){
        if(muridRepository.findById(id).isPresent()){
            muridRepository.deleteById(id);
        }
    }


}
