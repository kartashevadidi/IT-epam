package by.epam.tr.tasks.three.models;

import java.sql.Time;
import java.util.Arrays;
import java.util.Set;

public class Airline {

    private String destination;
    private String flightNumber;
    private AirplaneType planeType;
    private Time time;
    private Set<Integer> days;

    public Airline() {
    }

    public Airline(String destination, String flightNumber, AirplaneType planeType, Time time, Set<Integer> days) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.time = time;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public AirplaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(AirplaneType planeType) {
        this.planeType = planeType;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<Integer> getDays() {
        return days;
    }

    public void setDays(Set<Integer> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", planeType=" + planeType +
                ", time=" + time +
                ", days=" + days +
                '}';
    }
}
