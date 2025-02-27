package com.example.test_code_id.Service;

import com.example.test_code_id.Model.Pendidikan;
import com.example.test_code_id.Repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendidikanService {

    @Autowired
    PendidikanRepository pendidikanRepository;


    public List<Pendidikan> get(){
        return pendidikanRepository.findAll();
    }

    public Pendidikan save(Pendidikan pendidikan){
        return pendidikanRepository.save(pendidikan);
    }

    public Pendidikan update(Pendidikan pendidikan){
        if(pendidikanRepository.findById(pendidikan.getId()).isPresent()){
           return pendidikanRepository.save(pendidikan);
        }

        return  null;
    }

    public void delete(Integer id){
        if(pendidikanRepository.existsById(id))
            pendidikanRepository.deleteById(id);
    }

}
