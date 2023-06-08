package com.todocode.demo.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="game")
public class Game {
    
    @Id
    private Long id;
    private String name;
    private Long price;
    private Integer maxCapacity;
    
    @Temporal(TemporalType.TIME)
    private Date openingHour;
    @Temporal(TemporalType.TIME)
    private Date closeHour;
    
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();
    
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Operator> operators = new HashSet<>();
    
}
