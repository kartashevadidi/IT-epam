package by.epam.tr.tasks.three;

import by.epam.tr.tasks.three.models.Airline;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AirlinesDataAccess {

    private List<Airline> airlines;

    public AirlinesDataAccess() {
        airlines = new ArrayList<>();
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public List<Airline> getAirlinesByDestination(String destination) {
        List<Airline> airlinesByDestination = new ArrayList<>();
        airlines.forEach(airline -> {
            if (airline.getDestination().equals(destination.trim())) {
                airlinesByDestination.add(airline);
            }
        });
        return airlinesByDestination;
    }

    public List<Airline> getAirlinesByDay(int day) {
        List<Airline> airlinesByDay = new ArrayList<>();
        airlines.forEach(airline -> {
            for (int d : airline.getDays()) {
                if (d == day) {
                    airlinesByDay.add(airline);
                }
            }
        });
        return airlinesByDay;
    }

    public List<Airline> getAirlinesByDayTime(int day, Time time) {
        List<Airline> airlinesByDayTime = new ArrayList<>();
        airlines.forEach(airline -> {
            for (int d : airline.getDays()) {
                if (d == day) {
                    if (airline.getTime().getTime() >= time.getTime()) {
                        airlinesByDayTime.add(airline);
                    }
                }
            }
        });
        return airlinesByDayTime;
    }
}
