package com.todocode.demo.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Schedule {//horario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Temporal(TemporalType.TIME)
    private Date start_schedule;
    @Temporal(TemporalType.TIME)
    private Date end_schedule;
}
