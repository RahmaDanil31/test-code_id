package com.example.test_code_id.Controller;

import com.example.test_code_id.Model.Murid;
import com.example.test_code_id.Service.MuridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/murid")
public class MuridController {

    @Autowired
    MuridService muridService;


    @GetMapping()
    public ResponseEntity<List<Murid>> get(){
        return new ResponseEntity<>(muridService.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Murid> save(@RequestBody Murid murid){
        return new ResponseEntity<>(muridService.save(murid),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Murid> update(@RequestBody Murid murid){
        return new ResponseEntity<>(muridService.update(murid),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(Integer id){
        muridService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
