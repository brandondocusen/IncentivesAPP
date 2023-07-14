package com.spring.crud.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private int shiftID;

    private int employeeNumber;
    private int date;
    private String startTime;
    private String endTime;
    private Float location;

    public Employee(int shiftID, int employeeNumber, int date, String startTime, String endTime, Float location) {
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }
}