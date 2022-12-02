package com.niit.jdp;

import com.niit.jdp.display.SongDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        SongDisplay songDisplay = new SongDisplay();
        do {
            songDisplay.jukeboxDisplay();
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
        } while (choice != 2);
    }
}