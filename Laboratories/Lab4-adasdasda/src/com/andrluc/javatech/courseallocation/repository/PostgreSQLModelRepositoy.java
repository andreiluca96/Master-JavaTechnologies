package com.andrluc.javatech.courseallocation.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class PostgreSQLModelRepositoy<T> implements ModelRepository<T> {

    public static final String CONNECTION_URL =
            "jdbc:postgresql://java-technologies.c4adtnibo1yb.eu-central-1.rds.amazonaws.com:5432/optional_course_allocation";

    protected Connection getDBConnection() {
        Connection c;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    CONNECTION_URL,
                    "andrluc",
                    "andreiluca96");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);

            // not reachable
            return null;
        }
    }
}
