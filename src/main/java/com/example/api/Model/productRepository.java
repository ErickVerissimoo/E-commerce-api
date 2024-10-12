package com.example.api.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface productRepository extends CrudRepository<product, Integer>{

}
