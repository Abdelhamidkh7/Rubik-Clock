/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment2;
import java.util.Random;
/**
 *
 * @author lenovo
 */
import java.util.Random;

/**
 * Manages the state and logic for the Rubik's Clock puzzle game.
 */
public class RubikClock {
    /**
     * Array holding the individual Clock instances.
     */
    private Clock[] clocks = new Clock[9];

    /**
     * Counter for the number of steps taken in the current game.
     */
    private int steps;

    /**
     * Initializes a new Rubik's Clock puzzle and sets up a solvable state.
     */
    public RubikClock() {
        for (int i = 0; i < clocks.length; i++) {
            clocks[i] = new Clock();
        }
        setupSolvableState();
    }

    /**
     * Randomizes the clock hours to create a solvable puzzle state and resets the step counter.
     */
    public void setupSolvableState() {
        Random rand = new Random();
        int b = rand.nextInt(20) + 1; // Ensure at least one button press
        for (int i = 0; i < b; i++) {
            incrementClockHours(rand.nextInt(4));
        }
        steps = 0;
    }

    /**
     * Increments the hours on the clocks affected by the specified button.
     * 
     * @param buttonIndex The index of the button pressed.
     */
    public void incrementClockHours(int buttonIndex) {
        int[] affectedClocks = getButtonIndices(buttonIndex);
        for (int index : affectedClocks) {
            clocks[index].incrementHour();
        }
        steps++;
    }

    /**
     * Checks if all clocks show the winning hour (12 o'clock).
     * 
     * @return true if all clocks show 12, false otherwise.
     */
    public boolean checkWinCondition() {
        for (Clock clock : clocks) {
            if (clock.getHour() != 12) {
                return false;
            }
        }
        return true;
    }

    /**
     * Resets the step counter to zero.
     */
    public void resetSteps() {
        steps = 0;
    }

    /**
     * Gets the current step count.
     * 
     * @return The number of steps taken in the current game.
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Retrieves the current hour for each clock in the game.
     * 
     * @return An array of hours for the clocks.
     */
    public int[] getClockHours() {
        int[] hours = new int[clocks.length];
        for (int i = 0; i < clocks.length; i++) {
            hours[i] = clocks[i].getHour();
        }
        return hours;
    }

    /**
     * Determines the indices of clocks affected by a given button.
     * 
     * @param buttonNumber The button number (0-3).
     * @return An array of indices for the affected clocks.
     * @throws IllegalArgumentException If the button number is invalid.
     */
    private int[] getButtonIndices(int buttonNumber) {
        switch (buttonNumber) {
            case 0:
                return new int[] {0, 1, 3, 4};
            case 1:
                return new int[] {1, 2, 4, 5};
            case 2:
                return new int[] {3, 4, 6, 7};
            case 3:
                return new int[] {4, 5, 7, 8};
            default:
                throw new IllegalArgumentException("Invalid button number");
        }
    }
}
