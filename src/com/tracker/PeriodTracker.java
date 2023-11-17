package com.tracker;
import java.time.LocalDate;

public class PeriodTracker {

    //instance variables
    private LocalDate firstDayOfPeriod1;
    private LocalDate mostRecentPeriod;
    private LocalDate dateOfNextPeriod;
    private final int defaultCycleLength = 28;
    private int daysUntil = 14;
    private int daysLater;

    //constructors
    PeriodTracker() {
    }

    PeriodTracker(LocalDate firstDayOfPeriod1) {
        this();
      setFirstDayOfPeriod1(firstDayOfPeriod1);
    }

    PeriodTracker(LocalDate firstDayOfPeriod1, LocalDate mostRecentPeriod) {
        this(firstDayOfPeriod1);
        setMostRecentPeriod(mostRecentPeriod);

    }

    //calculates estimated beginning of next menstrual cycle
    public LocalDate menstruate(LocalDate firstDay) {

        if(firstDayOfPeriod1 == null) {
            dateOfNextPeriod = LocalDate.now().plusDays(defaultCycleLength);
        }
        else {
            // cycleLength = length of time between firstDayOfPeriod1 and mostRecentPeriod
            int cycleLength = firstDayOfPeriod1.until(mostRecentPeriod).getDays();
            dateOfNextPeriod = mostRecentPeriod.plusDays(cycleLength);
        }
        return dateOfNextPeriod;
    }

    // calculates estimated day of ovulation - 14 days after cycle
    public LocalDate ovulate(LocalDate firstDay) {
        LocalDate ovulationDate;
        if(firstDayOfPeriod1 == null) {
            dateOfNextPeriod = LocalDate.now().plusDays(defaultCycleLength);
            ovulationDate = dateOfNextPeriod.plusDays(daysUntil);
            return ovulationDate;
        }
        else {
            ovulationDate = dateOfNextPeriod.plusDays(daysUntil);
        }
        return ovulationDate;
    }

    //accessor methods to get the firstDayOfPeriod1 and mostRecentPeriod
    public LocalDate getFirstDayOfPeriod1() {
        return firstDayOfPeriod1;
    }

    public LocalDate getMostRecentPeriod() {
        return mostRecentPeriod;
    }

    public void setFirstDayOfPeriod1(LocalDate firstDayOfPeriod1) {
        this.firstDayOfPeriod1 = firstDayOfPeriod1;
    }

    public void setMostRecentPeriod(LocalDate mostRecentPeriod) {
        this.mostRecentPeriod = mostRecentPeriod;
    }
}