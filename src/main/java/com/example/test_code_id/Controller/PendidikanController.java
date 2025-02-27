package com.example.test_code_id.Controller;

import com.example.test_code_id.Model.Murid;
import com.example.test_code_id.Model.Pendidikan;
import com.example.test_code_id.Repository.PendidikanRepository;
import com.example.test_code_id.Service.PendidikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {

    @Autowired
    PendidikanService pendidikanService;

    @GetMapping()
    public ResponseEntity<List<Pendidikan>> get(){
        return new ResponseEntity<>(pendidikanService.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pendidikan> save(Pendidikan pendidikan){
        return new ResponseEntity<>(pendidikanService.save(pendidikan),HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<Pendidikan> update(Pendidikan pendidikan){
        return new ResponseEntity<>(pendidikanService.update(pendidikan),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(Integer id){
        pendidikanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
