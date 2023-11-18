package com.tracker;
import java.time.LocalDate;
import java.util.*;

public class PeriodTracker {

    //instance variables
    private LocalDate mostRecentPeriod;
    private LocalDate dateOfNextPeriod;
    private final int defaultCycleLength = 28;
    private int daysUntil = 14;
    private String name;
    Scanner scanner = new Scanner(System.in);
    private Map<String, List<LocalDate>> userDateList = new TreeMap<>();
    private List<LocalDate> dates = new ArrayList<>();

    //constructors
    public PeriodTracker() {
    }

    public PeriodTracker(String name) {
        this.name = name;

    }



    //calculates estimated beginning of next menstrual cycle

    public LocalDate promptForDay() {
        boolean validInput = false;
        LocalDate date = null;
        while (!validInput) {
            System.out.println("Please enter the date of the first day of your last period [YYYY-MM-DD]: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
                validInput = true;
            }
            date = LocalDate.parse(input);
            this.mostRecentPeriod = date;
        }
        return date;
    }
    public void menstruate(LocalDate firstDay) {

        dateOfNextPeriod = mostRecentPeriod.plusDays(defaultCycleLength);
        dates.add(mostRecentPeriod);
        dates.add(dateOfNextPeriod);
        userDateList.put(name, dates);
        System.out.println(userDateList.values());

    }

    // calculates estimated day of ovulation - 14 days after cycle
    public void ovulate(LocalDate firstDay) {
        LocalDate ovulationDate;
        ovulationDate = dateOfNextPeriod.plusDays(daysUntil);
    }

    //accessor methods to get the firstDayOfPeriod1 and mostRecentPeriod
    public LocalDate getMostRecentPeriod() {
        return mostRecentPeriod;
    }

    public void setMostRecentPeriod(LocalDate mostRecentPeriod) {
        this.mostRecentPeriod = mostRecentPeriod;
    }
}