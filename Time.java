/*
* Author: Allen Mutiso, MTSALL002
* 06 October 2026
* Represents time, objects of this class will include the hour and the minute.
* Pre-condition: during instanciation, the hour argument has to be 0 <= hour < 24
* the minute argument has to be 0 <= minute < 60
*/

public class Time implements Comparable<Time>{
    private String hour;
    private String minute;
    private String second;

    public Time(String time) {
        String[] timeParts = time.split(":");
        this.hour = timeParts[0];
        this.minute = timeParts[1];
        this.second = timeParts[2];
    }

    public Time () {
        this.hour = "0";
        this.minute = "0";
        this.second = "0";
    }

    public Time (Time other) {
        this.hour = other.hour;
        this.minute = other.minute;
        this.second = other.second;
    }

    public String getMinute () {return minute;}
    public String getHour () {return hour;}
    public String getSecond () {return second;}

    public void setMinute (String newMinute) {
        int intMinute = Integer.parseInt(newMinute);
        if (0 > intMinute || 59 < intMinute) {
            throw new IllegalArgumentException("Argument should be between 0 and 59.");
        }
        this.minute = newMinute;
    }

    public void setHour (String newHour) {
        int intHour = Integer.parseInt(newHour);
        if (0 > intHour || 23 < intHour) {
            throw new IllegalArgumentException("Argument should be between 0 and 23.");
        }
        this.hour = newHour;
    }

    public int compareTo(Time other) {
        if (this.getHour().compareTo(other.getHour()) != 0) {
            return this.getHour().compareTo(other.getHour());
        } else if (this.getMinute().compareTo(other.getMinute()) != 0) {
            return this.getMinute().compareTo(other.getMinute());
        } else {
            return this.getSecond().compareTo(this.getSecond());
        }
    }

    @Override 
    public String toString() {
        return String.format("%s:%s:%s", getHour(), getMinute(), getSecond());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Time)) {
            return false;
        }
        Time otherTime = (Time) other;
        return this.getHour().equals(otherTime.getHour()) && this.getMinute().equals(otherTime.getMinute()) && this.getSecond().equals(otherTime.getSecond());
    }
}
