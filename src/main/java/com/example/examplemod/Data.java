package com.example.examplemod;

public class Data {
    public static String LookingDirection = ""; // Direction that player is looking at


    // Set looking direction
    public static void setLookingDirection(int direction) {
        if (direction == 0) LookingDirection = "SOUTH";
        else if (direction == 1) LookingDirection = "SOUTH_WEST";
        else if (direction == 2) LookingDirection = "WEST";
        else if (direction == 3) LookingDirection = "WEST_NORTH";
        else if (direction == 4) LookingDirection = "NORTH";
        else if (direction == 5) LookingDirection = "NORTH_EAST";
        else if (direction == 6) LookingDirection = "EAST";
        else if (direction == 7) LookingDirection = "EAST_SOUTH";
    }
    // Get looking direction
    public static String getLookingDirection() {
        return LookingDirection;
    }

}
