package org.votingbackend.database;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class Database {
    public static Connection conn;
    public static Statement stmt;

    public void setUp() {
        connectServer();
        adminTable();
        teamTable();
        pinTable();
        voteItemsTable();
        sessionsTable();
        votesTable();
    }

    public void connectServer() {
        try {
            String url = "jdbc:sqlite:ByteJam.db";

            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void adminTable() {
        String sql = "CREATE TABLE IF NOT EXISTS ADMIN " +
                "(AD_ID INT PRIMARY KEY NOT NULL," +
                "USERNAME VARCHAR(30)," +
                "PASSWORD VARCHAR(20))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error creating admin table");
            e.printStackTrace();
        }
    }

    public void teamTable() {
        String sql = "CREATE TABLE IF NOT EXISTS TEAMS " +
                "(TEAM_ID INT PRIMARY KEY NOT NULL," +
                "TEAM_NAME VARCHAR(100)," +
                "TEAM_TYPE VARCHAR(20))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error creating Teams Table");
            e.printStackTrace();
        }
    }

    public void pinTable() {
        String sql = "CREATE TABLE IF NOT EXISTS PINS" +
                "(PIN_ID INT PRIMARY KEY NOT NULL," +
                "PIN CHAR(5)," +
                "PIN_TYPE VARCHAR(20)," +
                "OWNER_NAME VARCHAR(40))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error creating Pins Table");
            e.printStackTrace();
        }
    }

    public void voteItemsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS VOTE_ITEMS" +
                "(VOTE_ITEM_ID INT PRIMARY KEY NOT NULL," +
                "APP_APPEAL INT," +
                "AMAZEMENT INT," +
                "THEME INT," +
                "PERFORMANCE INT," +
                "TEAM_ID INT," +
                "FOREIGN KEY(TEAM_ID) REFERENCES TEAMS(TEAM_ID))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error creating Vote Item Table");
            e.printStackTrace();
        }
    }

    public void sessionsTable(){
        String sql = "CREATE TABLE IF NOT EXISTS SESSIONS" +
                "(SESSION_ID INT PRIMARY KEY NOT NULL," +
                "IP VARCHAR(32)," +
                "DEVICE_ID VARCHAR(16)," +
                "EXPIRES_AT DATE," +
                "USERS_NAME VARCHAR(40))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e){
            System.out.println("Error creating Sessions Table");
            e.printStackTrace();
        }
    }

    public void votesTable(){
        String sql = "CREATE TABLE IF NOT EXISTS VOTES" +
                "(VOTE_ID PRIMARY KEY NOT NULL," +
                "SESSION_ID INT," +
                "VOTE_ITEM INT," +
                "FOREIGN KEY(SESSION_ID) REFERENCES SESSIONS(SESSION_ID)," +
                "FOREIGN KEY(VOTE_ITEM) REFERENCES VOTE_ITEMS(VOTE_ITEM_ID))";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e){
            System.out.println("Error Creating Votes Table");
            e.printStackTrace();
        }
    }
}
