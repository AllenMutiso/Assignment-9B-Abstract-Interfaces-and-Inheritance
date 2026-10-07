/*
* Author: Allen Mutiso, MTSALL002
* 07 October 2026
* This file tests the ObservationsList, Observation and Time classes.
*/

import java.util.List;

public class TestSuite {
    public static void main(String[] args) {
        System.out.println("--- 1. Testing Time Class ---");
        Time t1 = new Time(8, 30);
        Time t2 = new Time(9, 15);
        Time t3 = new Time(8, 30);
        
        System.out.println("Time 1: " + t1); 
        System.out.println("Time 2: " + t2);
        System.out.println("t1 equals t3: " + t1.equals(t3)); 
        System.out.println("t1 compareTo t2 (should be negative): " + t1.compareTo(t2)); 
        System.out.println("t2 compareTo t1 (should be positive): " + t2.compareTo(t1)); 

        System.out.println("\n--- 2. Testing Registration Class ---");
        Registration reg1 = new Registration("CA 485-984");
        Registration reg2 = new Registration("ALK582 GP");
        System.out.println("Reg 1: " + reg1);
        System.out.println("Reg 2: " + reg2);

        System.out.println("\n--- 3. Testing Observation Class ---");
        Observation obs1 = new Observation(reg1, t1);
        Observation obs2 = new Observation(reg2, t2);
        Observation obs3 = new Observation(reg1, new Time(10, 45));
        
        System.out.println("Observation 1: " + obs1); 
        System.out.println("obs1 is for " + reg1.getIdentifier() + ": " + obs1.isFor(reg1));
        
        Time periodStart = new Time(8, 0);
        Time periodEnd = new Time(9, 0);
        System.out.println("obs1 occurred between 08:00 and 09:00: " + obs1.inPeriod(periodStart, periodEnd)); 
        System.out.println("obs2 occurred between 08:00 and 09:00: " + obs2.inPeriod(periodStart, periodEnd)); 

        System.out.println("\n--- 4. Testing ObservationsList Class ---");
        ObservationsList list = new ObservationsList();
        
        // Testing both record method signatures
        list.record(obs1);
        list.record(obs2);
        list.record(reg1, new Time(10, 45)); // Creates obs3 internally
        
        System.out.println("Total observations (should be 3): " + list.getTotal());

        System.out.println("\nUnique Vehicles Observed:");
        List <Registration> vehicles = list.getVehicles();
        for (Registration r : vehicles) {
            System.out.println(r);
        } 

        System.out.println("\nFiltering Observations by Registration (" + reg1 + "):");
        ObservationsList filteredByReg = list.getObservations(reg1);
        for (Observation o : filteredByReg) {
            System.out.println("- " + o);
        }

        System.out.println("\nFiltering Observations by Time Period (08:00 to 10:00):");
        ObservationsList filteredByTime = list.getObservations(new Time(8, 0), new Time(10, 0));
        for (Observation o : filteredByTime) {
            System.out.println("- " + o);
        }
    }
}