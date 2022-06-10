package com.example.examplemod;

import com.example.examplemod.chat.Chat;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static String LookingDirection = ""; // Direction that player is looking at


    // Set looking direction
    public static void setLookingDirection(int direction) {
        if (direction == 0) LookingDirection = "SOUTH";
        else if (direction == 1) LookingDirection = "WEST";
        else if (direction == 2) LookingDirection = "NORTH";
        else if (direction == 3) LookingDirection = "EAST";
    }
    // Get looking direction
    public static String getLookingDirection() {
        return LookingDirection;
    }

}
