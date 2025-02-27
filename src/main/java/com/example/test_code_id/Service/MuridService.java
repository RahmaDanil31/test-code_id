package com.example.test_code_id.Service;

import com.example.test_code_id.Dto.MuridDto;
import com.example.test_code_id.Model.Murid;
import com.example.test_code_id.Repository.MuridRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MuridService {

    @Autowired
    MuridRepository muridRepository;

    public List<Murid> get(MuridDto murid){

        Pageable pageable = PageRequest.of(
                murid.getPage(),
                murid.getLimit(),
                Sort.by(
                        Sort.Direction.fromString(murid.getDirection()),
                        murid.getSort()
                )
        );

       Page<Murid> murids = muridRepository.findAll(build(murid),pageable);

        return murids.stream().toList();
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

    public <T> Specification<T> build(Object object) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (object == null) {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }

            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);

                    if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                        continue;
                    }

                    if (value instanceof String) {
                        predicates.add(criteriaBuilder.like(root.get(field.getName()), "%" + value + "%"));
                    }else if (value instanceof Date) {
                        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(field.getName()), (Date) value));
                    } else {
                        predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                    }
                } catch (IllegalAccessException e){}
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}
