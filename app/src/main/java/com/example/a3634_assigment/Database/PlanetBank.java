package com.example.a3634_assigment.Database;

import com.example.a3634_assigment.Models.Planet;
import com.example.a3634_assigment.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlanetBank {



    public static Planet getPlanetById(int id) {
        return planets.get(id);
    }


    public static ArrayList<Planet> getAllPlanets() {
        return new ArrayList<Planet>((List) Arrays.asList(planets.values().toArray()));
    }

    private static final HashMap<Integer, Planet> planets = new HashMap<>();

    static {
        planets.put(1, new Planet(
                1,
                "Mercury",
                R.drawable.appicon
        ));
        planets.put(2, new Planet(
                2,
                "Venus",
                R.drawable.appicon
        ));
        planets.put(3, new Planet(
                3,
                "Earth",
                R.drawable.appicon
        ));
        planets.put(4, new Planet(
                4,
                "Mars",
                R.drawable.appicon
        ));
        planets.put(5, new Planet(
                5,
                "Jupiter",
                R.drawable.appicon
        ));
        planets.put(6, new Planet(
                6,
                "Saturn",
                R.drawable.appicon
        ));
        planets.put(7, new Planet(
                7,
                "Uranus",
                R.drawable.appicon
        ));
        planets.put(8, new Planet(
                8,
                "Neptune",
                R.drawable.appicon
        ));
        planets.put(9, new Planet(
                9,
                "Pluto",
                R.drawable.appicon
        ));
    }
}
