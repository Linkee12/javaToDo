package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

public class TaskManager {
    private final String URL = "jdbc:sqlite:tasks.db";
    private int tasknumber;

   

    public List<Task> getAllTasks() {
        tasknumber=0;
        try {
            ArrayList<Task> tasks = new ArrayList<Task>();
            Statement st = getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                int id = rs.getInt("id");
                String message = rs.getString("messages");
                Task task = new Task(id, message);
                tasks.add(task);
                tasknumber++;
            }
            tasknumber+=1;
            return tasks;

        } catch (Exception e) {
            System.out.println("ERR: " + e.getMessage());
            return null;
        }
    }

    public void addTask(String message) {
        try {

            Statement st = getStatement();

            String sql = "INSERT INTO tasks(messages) VALUES('" + message + "')";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteTask(int id) {
        try {
            Statement st = getStatement();
            String sql = "DELETE FROM tasks WHERE id=" + id;
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Err: " + e.getMessage());
        }
    }

    public int getTasknumber() {
        return tasknumber;
    }
    public void editTask(int id,String newMessages) {
        try {
            Statement st=getStatement();
            String sql="UPDATE tasks SET messages= '"+newMessages+"'WHERE id="+id;
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Err: "+e.getMessage());
        }


    }

    private Statement getStatement() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        Statement st = connection.createStatement();
        return st;
    }
}
