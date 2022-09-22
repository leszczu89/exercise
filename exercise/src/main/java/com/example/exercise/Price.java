package com.example.exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price {
    private Integer id;
    @Column(unique = true)
    @Id
    private String name;
    private double bid;
    private double ask;
    private Date timestamp;

    @Override
    public String toString() {
        return id + "," + name + "," + bid + "," + ask + "," + timestamp;
    }
}
