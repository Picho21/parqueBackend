package com.todocode.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", allocationSize = 1)
    private Long id;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Game game;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Operator seller;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Visitor visitor;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Sale sale;
    
    
}
