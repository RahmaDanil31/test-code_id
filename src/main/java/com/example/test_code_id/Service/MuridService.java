package com.example.test_code_id.Service;

import com.example.test_code_id.Model.Murid;
import com.example.test_code_id.Repository.MuridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuridService {

    @Autowired
    MuridRepository muridRepository;

    public List<Murid> get(){
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
