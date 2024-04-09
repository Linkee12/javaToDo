package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Your tasks: ");
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int menu = 5;
        do {
            List<Task> tasks = tm.getAllTasks();
            for (Object e : tasks) {
                System.out.println(e);
            }
            System.out.println("-----------------------------------------------------");
            System.out.println("Menu: 0: Add, 1: Remove, 2: Edit, 3: Exit");
            String string = sc.nextLine();
            try {
                menu = Integer.parseInt(string);
                switch (menu) {
                    case 0:
                        System.out.println("Add task: ");
                        String newTask = sc.nextLine();
                        tm.addTask(newTask);
                        break ;
                    case 1:

                        break;
                    case 2:

                        break;
                }
            } catch (Exception e) {
                System.out.println("Please set number!!");
            }
        } while (menu!=3);

    }

}