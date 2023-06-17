package com.todocode.demo.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Admi extends Employee{
    
    @ManyToOne
    private Owner head;
    
    @OneToMany(mappedBy = "admi", cascade = CascadeType.ALL)
    private Set<Operator> operators = new HashSet<>();
    
    @OneToMany(mappedBy = "admi", cascade = CascadeType.ALL)
    private Set<Visitor> visitor = new HashSet<>();
    
}
