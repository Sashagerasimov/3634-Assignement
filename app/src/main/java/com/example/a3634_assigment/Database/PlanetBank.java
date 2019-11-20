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

    public static ArrayList<Planet> getLevel1(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel2(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel3(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel4(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel5(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        returnedPlanets.add(planets.get(5));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel6(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        returnedPlanets.add(planets.get(5));
        returnedPlanets.add(planets.get(6));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel7(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        returnedPlanets.add(planets.get(5));
        returnedPlanets.add(planets.get(6));
        returnedPlanets.add(planets.get(7));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel8(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        returnedPlanets.add(planets.get(5));
        returnedPlanets.add(planets.get(6));
        returnedPlanets.add(planets.get(7));
        returnedPlanets.add(planets.get(8));
        return returnedPlanets;
    }
    public static ArrayList<Planet> getLevel9(){
        ArrayList<Planet> returnedPlanets = new ArrayList<Planet>();
        returnedPlanets.add(planets.get(1));
        returnedPlanets.add(planets.get(2));
        returnedPlanets.add(planets.get(3));
        returnedPlanets.add(planets.get(4));
        returnedPlanets.add(planets.get(5));
        returnedPlanets.add(planets.get(6));
        returnedPlanets.add(planets.get(7));
        returnedPlanets.add(planets.get(8));
        returnedPlanets.add(planets.get(9));
        return returnedPlanets;
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
