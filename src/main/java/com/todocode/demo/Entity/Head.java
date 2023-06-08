/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todocode.demo.Entity;

import com.todocode.demo.Enum.Rol;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="head")
public class Head {
    @Id
    private Long dni;
    private String name;
    private String lastName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    @OneToMany(mappedBy = "head", cascade = CascadeType.ALL)
    private Set<Admin> admins = new HashSet<>();
}
