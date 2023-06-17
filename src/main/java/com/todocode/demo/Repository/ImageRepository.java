package com.todocode.demo.Repository;


import com.todocode.demo.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image , String>{
    
}
