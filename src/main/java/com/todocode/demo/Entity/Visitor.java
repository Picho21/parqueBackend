package com.todocode.demo.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="visitor")
public class Visitor {

    @Id
    private Long dni;
    private String name;
    private String email;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Admin admin;

}
