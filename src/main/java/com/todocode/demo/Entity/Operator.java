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
public class Operator extends Employee {

    @OneToOne(mappedBy = "operator", cascade = CascadeType.ALL)
    private Image image;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Admin admin;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Game game;
}
