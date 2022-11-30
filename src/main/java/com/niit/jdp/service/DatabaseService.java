/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import java.sql.Connection;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/songs";
    private static final String userName = "root";
    private static final String password = "root";
    Connection connection;
}
