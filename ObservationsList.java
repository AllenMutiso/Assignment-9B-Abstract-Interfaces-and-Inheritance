/*
* Author: Allen Mutiso, MTSALL002
* 07 October 2026
* Objects of this class will store a collection of all the observations made
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObservationsList implements Iterable<Observation> {
    private ArrayList <Observation> observationList;

    public ObservationsList() {
        observationList = new ArrayList<>();
    }

    public void record (Observation observation) {observationList.add(observation);}
    public void record (Registration reg, Time time) {observationList.add(new Observation(reg, time));}

    public int getTotal () {return observationList.size();}

    public List<Registration> getVehicles() {
        List<Registration> regList = new ArrayList<>();
        for (Observation o : observationList) {
            if (!(regList.contains(o.getIdentifier()))) {regList.add(o.getIdentifier());}
        }
        return regList;
    }

    public ObservationsList getObservations(final Registration identifier) {
        ObservationsList results = new ObservationsList();
        for (Observation o : observationList) {
            if (o.getIdentifier().equals(identifier)) {results.record(o);}
        }
        return results;
    }

    // For the method to work s has to preceed or equal e
    public ObservationsList getObservations(final Time s, final Time e) {
        ObservationsList resultsTwo = new ObservationsList();
        for (Observation o : observationList) {
            if (s.compareTo(e) < 1) {
                if (o.inPeriod(s, e)) {resultsTwo.record(o);}
            }
        }
        return resultsTwo;
    }

    public Iterator<Observation> iterator () {
        return new ArrayList<Observation>(observationList).iterator();
    }
}
