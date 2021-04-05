package com.course.java.service;

import com.course.java.model.DestinationPair;
import com.course.java.model.Trip;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneratorService {
    Map<DestinationPair, Long>  map;
    List<Trip> trips;

    public RandomGeneratorService(Map<DestinationPair, Long> map, List<Trip> trips) {
        this.map = map;
        this.trips = trips;
    }

    public void returnRandomTrip(Map<DestinationPair, Long> destinationMap, List<Trip> tripList) {
        int randomValue = ThreadLocalRandom.current().nextInt(0,5);
        Trip randomTrip = tripList.get(randomValue);

    }

}

/*
Losuje losowego tripa:

losuje sie np. Krakow Warszawa

sprawdzasz czy na mapie jest taka para i dla tej pary pobierasz odleglosc
pamietaj, ze para jest wymienna czyli Krakow Warszawa to to samo co Warszawa - Krakow

randomowo tickets,
randomowo airplane,
randomowo passangers,

+TESTY
 */
