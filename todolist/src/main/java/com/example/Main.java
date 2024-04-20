package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Your tasks: ");
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int menu = 5;
        System.out.println("-----------------------------------------------------");
        do {
            List<Task> tasks = tm.getAllTasks();
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i+1+": "+tasks.get(i).getMessage());
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
                        break;
                    case 1:
                        System.out.println("Id: ");
                        int id = sc.nextInt()-1;
                        tm.deleteTask(tasks.get(id).getId());
                        break;
                    case 2:
                        System.out.println("Id: ");
                        id=sc.nextInt()-1;
                        System.out.println("New task");
                        sc.nextLine();
                        String newMessage=sc.nextLine();
                        
                        tm.editTask(tasks.get(id).getId(),newMessage);

                        break;
                }
            } catch (Exception e) {
                System.out.println("Please set number!!"+e.getMessage());
            }
        } while (menu != 3);
        sc.close();
    }

}