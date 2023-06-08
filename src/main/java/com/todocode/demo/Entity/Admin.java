package com.todocode.demo.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Admin extends Employee{
    
    @OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
    private Image image;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Operator> operators = new HashSet<>();
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Head head;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Visitor> visitors = new HashSet<>();
    
    
}
