package com.todocode.demo.Entity;

import com.todocode.demo.Enum.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    private Long dni;

    private String name;
    private String lastName;
    private String password;

    @Enumerated(EnumType.STRING)//tipo de dato q maneja mi enum
    private Rol rol;

    @OneToOne
    private Image image;

}
