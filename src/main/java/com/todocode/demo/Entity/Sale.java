package com.todocode.demo.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "sale")
@Entity
public class Sale {
    @Id
    @GeneratedValue(generator ="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToOne
    private Visitor buyer; 
    
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    
    @ManyToOne
    private Operator operator;
    
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();
}
