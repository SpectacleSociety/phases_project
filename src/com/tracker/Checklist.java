package com.tracker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;

public class Checklist {
    private Path filename = Path.of("data/checklist.txt");
    private Scanner scanner = new Scanner(System.in);

    //business methods
    public void run() {
        System.out.println("Please choose an option\n");
        System.out.println("1. View list ");
        System.out.println("2. Add item ");
        System.out.println("3. Remove item ");


        String choice = scanner.nextLine();
        switch(choice) {
            case "1":
                viewList();
                break;
            case "2":
                addItem();
                break;
            case "3":
                removeItem();
                break;

    }
    }

    public void viewList() {
        try {
            List<String> list = Files.readAllLines(filename);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem() {
        try {
            System.out.println("Add an item: ");
            String line = scanner.nextLine();
            Files.writeString(filename, line);
            System.out.println("Item added to list.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeItem() {


    }

    public void completedItem() {

    }


}