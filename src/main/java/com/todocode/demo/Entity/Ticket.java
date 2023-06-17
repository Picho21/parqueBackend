package com.todocode.demo.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Game game;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Operator seller;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Visitor visitor;
    
    @ManyToOne(fetch= FetchType.EAGER)
    private Sale sale;
    
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    
    
}
