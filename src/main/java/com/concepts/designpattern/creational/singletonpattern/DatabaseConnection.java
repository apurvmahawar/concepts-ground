package com.concepts.designpattern.creational.singletonpattern;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionName;

    private DatabaseConnection(String connectionName) {
        this.connectionName = connectionName;
        System.out.println("Database Connection Created..." +  connectionName);
    }

    public static DatabaseConnection getInstance(String connectionName) {
        if (instance == null) {
            instance = new DatabaseConnection(connectionName);
        }
        return instance;
    }

    public String getConnectionName() {
        return this.connectionName;
    }

}
