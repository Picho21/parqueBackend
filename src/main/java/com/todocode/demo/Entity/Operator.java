package com.todocode.demo.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Operator extends Employee {
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Admi admi;

    @ManyToOne(fetch= FetchType.EAGER)
    private Game game;
    
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Ticket> ticket = new HashSet<>();

}
