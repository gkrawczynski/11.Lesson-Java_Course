package com.course.java.service;

import com.course.java.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RandomGeneratorServiceTest {
    RandomGeneratorService randomGeneratorService;
    private Map<DestinationPair, Long> destinationMap;
    List<Trip> trips;
    private List<CrewMember> crewMembers;
    private List<Passenger> passengers;
    private List<AirPlane> planes;
    private List<CrewMember> crewPilots;
    private List<CrewMember> crewFlightAttendants;

    @Before
    public void setUp() throws Exception {
        randomGeneratorService = new RandomGeneratorService(destinationMap, trips);
        destinationMap = initDestinationMap();
        trips = initTripList();
        crewMembers.addAll(crewPilots);
        crewMembers.addAll(crewFlightAttendants);
        passengers = initPassengerList();
        planes = initAirPlaneList();
    }

    private Map<DestinationPair, Long> initDestinationMap() {
        return new HashMap<>(Map.of(
                new DestinationPair(City.AMSTERDAM, City.ATHENS), 1L,
                new DestinationPair(City.BERN, City.BRUSSELS), 2L,
                new DestinationPair(City.BELGRADE, City.BUCHAREST), 3L,
                new DestinationPair(City.HELSINKI, City.DUBLIN), 4L,
                new DestinationPair(City.LUBLANA, City.BRATISLAVA), 5L,
                new DestinationPair(City.LONDON, City.NYC), 6L,
                new DestinationPair(City.MADRID, City.PARIS), 7L,
                new DestinationPair(City.OSLO, City.STOCKHOLM), 8L,
                new DestinationPair(City.VIENNA, City.COPENHAGEN), 9L,
                new DestinationPair(City.PRAGA, City.BUDAPEST), 10L
        ));
    }

    private List<Ticket> initTicketList() {
        return new ArrayList<>(List.of(
                new Ticket(1234567, 163.02, initTripList().get(0)),
                new Ticket(2222222, 263.02, initTripList().get(1)),
                new Ticket(3333333, 363.02, initTripList().get(2)),
                new Ticket(4444444, 463.02, initTripList().get(3)),
                new Ticket(5555555, 563.02, initTripList().get(4))
        ));
    }

    private List<Passenger> initPassengerList() {
        return new ArrayList<>(List.of(
                new Passenger("John", "Kowalski", 24, initTicketList().get(0)),
                new Passenger("Mike", "Nowak", 24, initTicketList().get(1)),
                new Passenger("Nick", "Anderson", 24, initTicketList().get(2)),
                new Passenger("Patrick", "Roberts", 24, initTicketList().get(3)),
                new Passenger("Rickey", "Russell", 24, initTicketList().get(4))
        ));
    }

    private List<AirPlane> initAirPlaneList() {
        return new ArrayList<>(List.of(
                new AirPlane("Boeing", "747", 8000, 309, 934, 2),
                new AirPlane("Boeing", "847", 7000, 259, 834, 4),
                new AirPlane("Boeing", "737", 6000, 219, 734, 2),
                new AirPlane("Boeing", "526", 5000, 209, 634, 2),
                new AirPlane("Boeing", "878", 4000, 189, 534, 4)
        ));
    }


    private List<Trip> initTripList() {
        return new ArrayList<>(List.of(
                new Trip(City.LONDON, City.NYC, 4355.12, 6.2,
                        initAirPlaneList().get(0), crewMembers, passengers),
                new Trip(City.BERN, City.BRUSSELS, 355.12, 0.6,
                        initAirPlaneList().get(1), crewMembers, passengers),
                new Trip(City.AMSTERDAM, City.ATHENS, 855.12, 1.5,
                        initAirPlaneList().get(2), crewMembers, passengers),
                new Trip(City.BELGRADE, City.BUCHAREST, 655.12, 1.1,
                        initAirPlaneList().get(3), crewMembers, passengers),
                new Trip(City.HELSINKI, City.DUBLIN, 455.12, 2.0,
                        initAirPlaneList().get(4), crewMembers, passengers),
                new Trip(City.MADRID, City.PARIS, 700.42, 1.42,
                        initAirPlaneList().get(4), crewMembers, passengers)
        ));
    }

    private List<CrewMember> initPilotList1() {
        return new ArrayList<>(List.of(
                new Pilot("Alex", "Conklin", 38, 65000.40, 6.5,
                        2000.2, "First Officer"),
                new Pilot("Bill", "Gateman", 45, 75000.40, 12.3,
                        4021.2, "Captain"),
                new Pilot("Cameron", "Davis", 41, 55000.40, 9.4,
                        3421.2, "Captain"),
                new Pilot("Dave", "Jones", 34, 25000.40, 4.6,
                        1823.2, "Second Officer"),
                new Pilot("George", "Coltman", 37, 35000.40, 6.1,
                        1521.2, "First Officer"),
                new Pilot("Harry", "Potman", 40, 45000.40, 8.9,
                        2721.2, "Captain"),
                new Pilot("Jack", "Norman", 32, 15000.40, 3.2,
                        1521.2, "Second Officer")
        ));
    }

    private List<Pilot> initPilotList2() {
        return new ArrayList<>(List.of(
                new Pilot("Alex", "Conklin", 38, 65000.40, 6.5,
                        2000.2, "First Officer"),
                new Pilot("Bill", "Gateman", 45, 75000.40, 12.3,
                        4021.2, "Captain"),
                new Pilot("Cameron", "Davis", 41, 55000.40, 9.4,
                        3421.2, "Captain"),
                new Pilot("Dave", "Jones", 34, 25000.40, 4.6,
                        1823.2, "Second Officer"),
                new Pilot("George", "Coltman", 37, 35000.40, 6.1,
                        1521.2, "First Officer"),
                new Pilot("Harry", "Potman", 40, 45000.40, 8.9,
                        2721.2, "Captain"),
                new Pilot("Jack", "Norman", 32, 15000.40, 3.2,
                        1521.2, "Second Officer")
        ));
    }

    private List<CrewMember> initCrewFlightAttendantList() {
        return new ArrayList<>(List.of(
                new FlightAttendant("Alice", "Macmann", 28, 33000.60,
                        13.1, 48,
                        "Cabin Attendant", initLanguagesSpoken1()),
                new FlightAttendant("Barbara", "Brown", 27, 34000.17,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken2()),
                new FlightAttendant("Celia", "Smith", 26, 35000.16,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken3()),
                new FlightAttendant("Daria", "Wright", 25, 36000.15,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken3()),
                new FlightAttendant("Eliza", "Napanee", 24, 37000.14,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken4()),
                new FlightAttendant("Francesca", "Totti", 23, 38000.13,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken1()),
                new FlightAttendant("Hermiona", "Greensgate", 22, 32000.12,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken2()),
                new FlightAttendant("Janine", "Jackson", 29, 31000.11,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken4())
        ));
    }

    private List<FlightAttendant> initFlightAttendantList() {
        return new ArrayList<>(List.of(
                new FlightAttendant("Alice", "Macmann", 28, 33000.60,
                        13.1, 48,
                        "Cabin Attendant", initLanguagesSpoken1()),
                new FlightAttendant("Barbara", "Brown", 27, 34000.17,
                        4.8, 56,
                        "Cabin Attendant", initLanguagesSpoken2()),
                new FlightAttendant("Celia", "Smith", 26, 35000.16,
                        2.8, 56,
                        "Cabin Attendant", initLanguagesSpoken3()),
                new FlightAttendant("Daria", "Wright", 25, 36000.15,
                        3.8, 56,
                        "Cabin Attendant", initLanguagesSpoken3()),
                new FlightAttendant("Eliza", "Napanee", 24, 37000.14,
                        5.8, 56,
                        "Cabin Attendant", initLanguagesSpoken4()),
                new FlightAttendant("Francesca", "Totti", 23, 38000.13,
                        6.8, 56,
                        "Cabin Attendant", initLanguagesSpoken1()),
                new FlightAttendant("Hermiona", "Greensgate", 22, 32000.12,
                        8.8, 56,
                        "Cabin Attendant", initLanguagesSpoken2()),
                new FlightAttendant("Janine", "Jackson", 29, 31000.11,
                        7.8, 56,
                        "Cabin Attendant", initLanguagesSpoken4())
        ));
    }

    private List<FlightAttendantStats> initFlightAttendantStatsList() {
        return new ArrayList<>(List.of(
                new FlightAttendantStats("Alice", "Macmann", "Cabin Attendant",
                        initLanguagesSpoken1(), 13.1, 33000.60,48, 28),
                new FlightAttendantStats("Barbara", "Brown", "Cabin Attendant",
                        initLanguagesSpoken2(), 4.8, 34000.17,56, 27),
                new FlightAttendantStats("Celia", "Smith", "Cabin Attendant",
                        initLanguagesSpoken3(), 2.8, 35000.16, 56, 26),
                new FlightAttendantStats("Daria", "Wright", "Cabin Attendant",
                        initLanguagesSpoken3(), 3.8, 36000.15,56, 25),
                new FlightAttendantStats("Eliza", "Napanee", "Cabin Attendant",
                        initLanguagesSpoken4(), 5.8, 37000.14, 56, 24),
                new FlightAttendantStats("Francesca", "Totti", "Cabin Attendant",
                        initLanguagesSpoken1(), 6.8, 38000.13, 56, 23),
                new FlightAttendantStats("Hermiona", "Greensgate", "Cabin Attendant",
                        initLanguagesSpoken2(), 8.8, 32000.12,56, 22),
                new FlightAttendantStats("Janine", "Jackson", "Cabin Attendant",
                        initLanguagesSpoken4(), 7.8, 31000.11, 56, 29)
        ));
    }

    private Set<Language> initLanguagesSpoken1() {
        return Set.of(Language.ENGLISH, Language.FRENCH, Language.SPANISH);
    }

    private Set<Language> initLanguagesSpoken2() {
        return Set.of(Language.ENGLISH, Language.GERMAN, Language.DUTCH);
    }

    private Set<Language> initLanguagesSpoken3() {
        return Set.of(Language.ENGLISH, Language.NORWEGIAN, Language.SWEDISH, Language.DANISH);
    }

    private Set<Language> initLanguagesSpoken4() {
        return Set.of(Language.ENGLISH, Language.PORTUGUESE, Language.SPANISH);
    }

    @Test
    public void returnRandomTrip() {
        //given
        List<Trip> tripList = initTripList();
        Map<DestinationPair, Long> destinationMap;

        //when

        //then


    }


}