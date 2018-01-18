package com.zsoft.zreporting.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Report implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int  month;
    private int  year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "report_day",
        joinColumns = {
            @JoinColumn(name = "report_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "day")
        }
    )
    private List<Day> workedDays;
}
