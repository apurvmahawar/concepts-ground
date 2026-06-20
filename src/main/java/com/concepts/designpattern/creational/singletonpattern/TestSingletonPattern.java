package com.concepts.designpattern.creational.singletonpattern;

public class TestSingletonPattern {
    static void main() {
        DatabaseConnection connection1 = DatabaseConnection.getInstance("Attempt 1");
        System.out.println(connection1.getConnectionName());
        DatabaseConnection connection2 = DatabaseConnection.getInstance("Attempt 2");
        System.out.println(connection2.getConnectionName());

        System.out.println(connection1 == connection2); // Objects refer to the same address : true

    }
}
