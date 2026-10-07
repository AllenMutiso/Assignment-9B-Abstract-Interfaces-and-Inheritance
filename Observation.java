/*
* Author: Allen Mutiso, MTSALL002
* 07 October 2026
* Objects of this class record an observation of a vehicle, by 
* recording the vehicle's registration and the time when the car was observed.
*/

public class Observation implements Comparable<Observation>{
    private final Registration registration;
    private final Time time;

    public Observation(final Registration registration, final Time time) {
        this.registration = registration;
        this.time = time;
    }

    public Time getTime () {return time;}
    public Registration getIdentifier () {return registration;}

    public boolean isFor (final Registration identifier) {return identifier.equals(this.getIdentifier());}

    //Returns true if this observation was made between times s and e inclusive
    //Method works, when s preceeds/equals e
    public boolean inPeriod (final Time s, final Time e) {
        if (s.compareTo(e) > 0) {
            throw new IllegalArgumentException("First argument has to preceed or equal the second argument");
        }
        return (this.getTime().compareTo(s) >= 0 && this.getTime().compareTo(e) <= 0);
    }

    @Override 
    public boolean equals (Object o) {
        if (this == o) {return true;}
        if (o == null || !(o instanceof Observation)) {return false;}

        Observation otherObservation = (Observation) o;
        return (otherObservation.getTime().equals(this.getTime()) && otherObservation.getIdentifier().equals(this.getIdentifier()));
    }

    //Comparison is based on occurrence, no mention of the identifier in the assignment pdf.
    public int compareTo (Observation other) { return this.getTime().compareTo(other.getTime());}

    @Override
    public String toString() {
        return String.format("[%s, %s]", time.toString(), registration.toString());
    }
}