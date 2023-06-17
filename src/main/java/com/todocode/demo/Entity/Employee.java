package com.todocode.demo.Entity;

import com.todocode.demo.Enum.Rol;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Employee implements Serializable{

    @Id
    private String dni;

    private String name;
    private String lastName;
    private String password;
    
    @OneToOne
    private Schedule schedule; //horario
    
    @OneToOne
    private Users user;

    @Enumerated(EnumType.STRING)//tipo de dato q maneja mi enum
    private Rol rol;



}
