/*
* Author: Allen Mutiso, MTSALL002
* 06 October 2026
* Represents time, objects of this class will include the hour and the minute.
* Pre-condition: during instanciation, the hour argument has to be 0 <= hour < 24
* the minute argument has to be 0 <= minute < 60
*/

public class Time implements Comparable<Time>{
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
            throw new IllegalArgumentException("Invalid minute and hour arguments");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public Time () {
        this.hour = 0;
        this.minute = 0;
    }

    public Time (Time other) {
        this.hour = other.hour;
        this.minute = other.minute;
    }

    public int getMinute () {return minute;}
    public int getHour () {return hour;}

    public void setMinute (int newMinute) {
        if (0 > newMinute || 59 < newMinute) {
            throw new IllegalArgumentException("Argument should be between 0 and 59.");
        }
        this.minute = newMinute;
    }

    public void setHour (int newHour) {
        if (0 > newHour || 23 < newHour) {
            throw new IllegalArgumentException("Argument should be between 0 and 23.");
        }
        this.hour = newHour;
    }

    public int compareTo(Time other) {
        // this precedes other 
        if (this.getHour() < other.getHour() ||(this.getHour() == other.getHour() && this.getMinute() < other.getMinute())) {
            return -1;
        } 
        // this follows other
        else if (this.getHour() > other.getHour() || (this.getHour() == other.getHour() && this.getMinute() > other.getMinute())) {
            return 1;
        } 
        // this equals other
        else {
            return 0;
        }
    }

    @Override 
    public String toString() {
        return String.format("%02d : %02d", getHour(), getMinute());
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
        return this.getHour() == otherTime.getHour() && this.getMinute() == otherTime.getMinute();
    }
}
