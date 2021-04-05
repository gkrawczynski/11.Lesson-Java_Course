package com.course.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FlightAttendantStats {
    private String name;
    private String surname;
    private String position;
    private Set<Language> languagesSpoken;
    private double yearsOfExperience;
    private double salary;
    private int tripsCount;
    private int age;
}
