package com.tracker.app;


import com.tracker.Checklist;
import com.tracker.PeriodTracker;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PhasesApp {
    Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        String nameKey = promptForUserName();
        getFirstDay(nameKey);
    }

    private void welcome() {
        System.out.println("Welcome to Phases");
    }

    private String promptForUserName() {
        boolean validInput = false;
        String name = null;
        while (!validInput) {
            System.out.println("Please enter your name: ");
             name = scanner.nextLine().trim().toUpperCase();
             validInput = true;

//            if (name.matches("[A-Z]{12}")) {
//                validInput = true;
//                System.out.println(name);
//            }
        }
        return name;
    }

    private void getFirstDay(String name) {
        PeriodTracker tracker = new PeriodTracker(name);
        LocalDate firstDay = tracker.promptForDay();
        tracker.menstruate(firstDay);
        tracker.ovulate(firstDay);
    }

//    inputSecondDay();

//    showInfo();
}