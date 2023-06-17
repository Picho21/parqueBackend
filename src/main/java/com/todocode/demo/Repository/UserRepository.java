package com.todocode.demo.Repository;

import com.todocode.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{
    @Query ("SELECT u FROM Users u WHERE u.userName = :userName") //éste último es el q llega por parametro
    public Users buscarPorNombre(@Param("userName")String userName);
}
