package com.course.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DestinationPair {
    private City city1;
    private City city2;
}
