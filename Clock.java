/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment2;

/**
 *
 * @author lenovo
 */
/**
 * Represents a single clock in the Rubik's Clock puzzle game with an hour value.
 */
public class Clock {
    
    /**
     * The current hour displayed by the clock.
     */
    private int hour = 12; 

    /**
     * Retrieves the current hour of this clock.
     * 
     * @return the hour value (1-12 inclusive).
     */
    public int getHour() {
        return hour;
    }

    /**
     * Increments the hour by one, rolling over to 1 if it goes past 12.
     */
    public void incrementHour() {
        hour = (hour % 12) + 1;
    }
}

    

