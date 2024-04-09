package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Your tasks: ");
        TaskManager tm = new TaskManager();
        List<Task> tasks = tm.getAllTasks();
        for (Object e : tasks) {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        int menu=5;
        do {String string=sc.nextLine();
            try {
                menu=Integer.parseInt(string);
            } catch (Exception e) {
               System.out.println("Please set number!!");
            }
         }
         while (menu<0 || menu>4);

        }

}