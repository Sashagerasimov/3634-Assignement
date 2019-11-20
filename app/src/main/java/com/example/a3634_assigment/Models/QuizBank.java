package com.example.a3634_assigment.Models;

import java.util.Arrays;
import java.util.ArrayList;

public class QuizBank {

    //instantiate array of levels - this is not needed
    public static String[] levels = {
            "Mars",
            "Mercury",
            "Saturn",
            "Jupiter",
            "Earth",
            "Venus",
            "Neptune",
            "Pluto",
            "Uranus"
    };

    // Returns the score value of the questions
    public static int getScore(String levels) {
        switch (levels) {
            case "Mars":
                return 100;
            case "Mercury":
                return 100;
            case "Saturn":
                return 100;
            case "Jupiter":
                return 100;
            case "Earth":
                return 100;
            case "Venus":
                return 100;
            case "Neptune":
                return 100;
            case "Pluto":
                return 100;
            case "Uranus":
                return 100;

        }
        return 0;
    }

    //question bank
    public static ArrayList<String> getQuestions(String category) {
        ArrayList<String> questionList = new ArrayList<>();
        switch (category) {
            case "Neptune":
                questionList.add("Which planet from the Sun is Neptune?"); //8th
                questionList.add("How many times in mass is Neptune larger than Earth?"); //17 times
                questionList.add("How long does it take Neptune to orbit the Sun once?");//164.8 years
                questionList.add("What is Neptune's atmosphere composed of?");//hydrogen and helium
                questionList.add("Neptune's outer atmosphere is one of the coldest places in the Solar System. What is its temperature?"); //55K
                questionList.add("Compared to other planets, how big is Neptune?"); //2nd smallest
                questionList.add("The planet has traces of methane which accounts for it to show what colour?"); //blue
                questionList.add("How many moons does Neptune have?"); //14 moons
                break;
            case "Mars":
                questionList.add("Which planet from the Sun is Neptune?"); //8th
                questionList.add("What is the name of the largest volcano in the solar system that exists on Mars?"); //Olympus Mons
                questionList.add("Why is there no liquid water on Mars?");//low atmospheric pressure
                questionList.add("Which planet are Mars' seasons and days most comparable to?");//Earth
                questionList.add("Is Mars visible to the naked eye from Earth?"); //yis
                questionList.add("Compared to other planets, how big is Mars?"); //2nd smallest
                questionList.add("The planet has traces of iron oxide which accounts for it to show what colour?"); //red
                questionList.add("How many moons does Mars have?"); //2
                break;

            case "Mercury":
                questionList.add("Which planet from the Sun is Mercury?"); //1st
                questionList.add("What Roman deity is Mercury named after?"); //Messenger of the gods
                questionList.add("How many spacecraft have visited Mercury?");//2
                questionList.add("How long does it take Mercury to orbit the Sun?");//87.97 days
                questionList.add("Is Mercury visible to the naked eye from Earth?"); //yis
                questionList.add("Compared to other planets, how big is Mercury?"); //smallest
                questionList.add("Does Mercury have an atmosphere?"); //no
                questionList.add("How many moons does Mercury have?"); //0
                break;
            case "Saturn":
                questionList.add("Which planet from the Sun is Saturn?"); //6th
                questionList.add("How long is a day on Saturn?"); //10hrs 33 mins
                questionList.add("What type of planet is Saturn?");//gaseous
                questionList.add("How long does it take Saturn to orbit the Sun?");//
                questionList.add("What speeds can winds reach on Saturn?"); //1800km/hr
                questionList.add("Compared to other planets, how big is Saturn?"); //2nd largest
                questionList.add("The planet has traces of ammonia crystals which accounts for it to show what colour?"); //yello
                questionList.add("How many moons does Saturn have?"); //82
                break;
            case "Earth":
                questionList.add("Which planet from the Sun is Earth?"); //3rd
                questionList.add("What percentage of Earth's surface is covered with water?"); //71%
                questionList.add("What percentage of species that ever lived on Earth are now extinct?");//99%
                questionList.add("How long does it take Earth to orbit the Sun?");//365days
                questionList.add("What is the Earth's inner core made up of?"); //solid iron
                questionList.add("Compared to other planets, how big is Earth?"); //
                questionList.add("When did life first arise on Earth?"); //4.1billion years ago
                questionList.add("What special property is Earth?"); //most dense
                break;

            case "Jupiter":
                questionList.add("Which planet from the Sun is Jupiter?"); //3rd
                questionList.add("What percentage of Earth's surface is covered with water?"); //71%
                questionList.add("What percentage of species that ever lived on Earth are now extinct?");//99%
                questionList.add("How long does it take Earth to orbit the Sun?");//365days
                questionList.add("What is the Earth's inner core made up of?"); //solid iron
                questionList.add("Compared to other planets, how big is Jupiter?"); //
                questionList.add("When did life first arise on Earth?"); //4.1billion years ago
                questionList.add("What special property is Earth?"); //most dense
                break;

            case "Venus":
                questionList.add("Which planet from the Sun is Earth?"); //3rd
                questionList.add("What percentage of Earth's surface is covered with water?"); //71%
                questionList.add("What percentage of species that ever lived on Earth are now extinct?");//99%
                questionList.add("How long does it take Earth to orbit the Sun?");//365days
                questionList.add("What is the Earth's inner core made up of?"); //solid iron
                questionList.add("Compared to other planets, how big is Earth?"); //
                questionList.add("When did life first arise on Earth?"); //4.1billion years ago
                questionList.add("What special property is Earth?"); //most dense
                break;
            //chance
        }
        return questionList;
    }


    //make arraylist of questions, options and answers
    public static ArrayList<Options> getOptions(String category) {
        ArrayList<Options> options = new ArrayList<>();
        //switch by category
        switch (category) {
            case "Neptune":
                //instantiate objects
                Options neptuneQ1;
                Options neptuneQ2;
                Options neptuneQ3;
                Options neptuneQ4;
                Options neptuneQ5;
                Options neptuneQ6;
                Options neptuneQ7;
                Options neptuneQ8;
                //add instantiated objects to arraylist
                options.add(neptuneQ1 = new Options("Which planet from the Sun is Neptune?", "8th", "3rd", "4th", "5th", 1));
                options.add(neptuneQ2 = new Options("How many times in mass is Neptune larger than Earth?", "17 times", "18 times", "2 times", "4 times", 1));
                options.add(neptuneQ3 = new Options("How long does it take Neptune to orbit the Sun once?", "164.8 years", "10 years", "5 years", "208.4 years", 1));
                options.add(neptuneQ4 = new Options("What is Neptune's atmosphere composed of?", "Hydrogen", "Helium", "Hydrogen & Helium", "Carbon", 3));//365days
                options.add(neptuneQ5 = new Options("Neptune's outer atmosphere is one of the coldest places in the Solar System. What is its temperature?", "60K", "100K", "55K", "20K", 3));
                options.add(neptuneQ6 = new Options("Compared to other planets, how big is Neptune?", "smallest", "2nd smallest", "3rd smallest", "4th smallest", 2));
                options.add(neptuneQ7 = new Options("The planet has traces of methane which accounts for it to show what colour?", "green", "red", "purple", "blue", 4));
                options.add(neptuneQ8 = new Options("How many moons does Neptune have?", "14", "15", "3", "72", 1));
                break;

            case "Mars":
                Options marsQ1;
                Options marsQ2;
                Options marsQ3;
                Options marsQ4;
                Options marsQ5;
                Options marsQ6;
                Options marsQ7;
                Options marsQ8;

                options.add(marsQ1 = new Options("Which planet from the Sun is Mars?", "8th", "3rd", "4th", "5th", 2));
                options.add(marsQ2 = new Options("What is the name of the largest volcano in the solar system that exists on Mars?", "Olympus Mons", "Mount Everest", "Olympus Gasis", "Mount Voldon", 1));
                options.add(marsQ3 = new Options("Why is there no liquid water on Mars?", "Low atmospheric pressure", "High atmospheric pressure", "No oxygen in atmosphere", "Too much helium in atmosphere", 1));
                options.add(marsQ4 = new Options("Which planet are Mars' seasons and days most comparable to?", "Neptune", "Pluto", "Earth", "Venus", 3));
                options.add(marsQ5 = new Options("Is Mars visible to the naked eye from Earth?", "No", "Yes", "Unlikely", "Likely", 2));
                options.add(marsQ6 = new Options("Compared to other planets, how big is Mars?", "Smallest", "2nd smallest", "3rd smallest", "4th smallest", 2));
                options.add(marsQ7 = new Options("The planet has traces of iron oxide which accounts for it to show what colour?", "green", "red", "purple", "blue", 2));
                options.add(marsQ8 = new Options("How many moons does Mars have?", "14", "3", "3", "72", 3));
                break;


            case "Mercury":
                Options mercuryQ1;
                Options mercuryQ2;
                Options mercuryQ3;
                Options mercuryQ4;
                Options mercuryQ5;
                Options mercuryQ6;
                Options mercuryQ7;
                Options mercuryQ8;

                options.add(mercuryQ1 = new Options("Which planet from the Sun is Mercury?", "8th", "3rd", "4th", "1st", 4));
                options.add(mercuryQ2 = new Options("What Roman deity is Mercury named after?", "Messenger of the Gods", "Roman Priest", "Ruler of the Gods", "Roman Emperor", 1));
                options.add(mercuryQ3 = new Options("How many spacecraft have visited Mercury?", "3", "2", "1", "4", 2));
                options.add(mercuryQ4 = new Options("How long does it take Mercury to orbit the Sun?", "97.99 days", "87.97 days", "101 days", "300.46 days", 2));
                options.add(mercuryQ5 = new Options("Is Mercury visible to the naked eye from Earth?", "No", "Yes", "Unlikely", "Likely", 2));
                options.add(mercuryQ6 = new Options("Compared to other planets, how big is Mercury?", "Smallest", "2nd smallest", "3rd smallest", "4th smallest", 1));
                options.add(mercuryQ7 = new Options("Does Mercury have an atmosphere?", "No", "Yes", "Possibly", "Unlikely", 1));
                options.add(mercuryQ8 = new Options("How many moons does Mercury have?", "14", "3", "3", "0", 4));
                break;

            case "Saturn":
                Options saturnQ1;
                Options saturnQ2;
                Options saturnQ3;
                Options saturnQ4;
                Options saturnQ5;
                Options saturnQ6;
                Options saturnQ7;
                Options saturnQ8;

                options.add(saturnQ1 = new Options("Which planet from the Sun is Saturn?", "6th", "3rd", "4th", "1st", 1));
                options.add(saturnQ2 = new Options("How long is a day on Saturn?", "7 hrs", "2 hrs 45 mins", "10 hours 33 mins", "4 hours 24 mins", 3));
                options.add(saturnQ3 = new Options("What type of planet is Saturn?", "Solid", "Liquid", "Gaseous", "Liquid & Solid", 3));
                options.add(saturnQ4 = new Options("How long does it take Saturn to orbit the Sun?", "29 years", "24 years", "2 years", "1 year", 1));
                options.add(saturnQ5 = new Options("What speeds can winds reach on Saturn?", "1800km/hr", "100km/hr", "3000km/hr", "40km/hr", 1));
                options.add(saturnQ6 = new Options("Compared to other planets, how big is Saturn?", "Smallest", "2nd largest", "3rd smallest", "4th smallest", 2));
                options.add(saturnQ7 = new Options("The planet has traces of ammonia crystals which accounts for it to show what colour?", "Purple", "Red", "Blue", "Yellow", 4));
                options.add(saturnQ8 = new Options("How many moons does Saturn have?", "14", "3", "3", "82", 4));
                break;

            case "Earth":
                Options earthQ1;
                Options earthQ2;
                Options earthQ3;
                Options earthQ4;
                Options earthQ5;
                Options earthQ6;
                Options earthQ7;
                Options earthQ8;

                options.add(earthQ1 = new Options("Which planet from the Sun is Earth?", "6th", "3rd", "4th", "1st", 2));
                options.add(earthQ2 = new Options("What percentage of Earth's surface is covered with water?", "71%", "59%", "85%", "63%", 1));
                options.add(earthQ3 = new Options("What percentage of species that ever lived on Earth are now extinct?", "99%", "52%", "65%", "42%", 1));
                options.add(earthQ4 = new Options("How long does it take Earth to orbit the Sun?", "367 days", "398 days", "47 days", "365 days", 4));
                options.add(earthQ5 = new Options("What is the Earth's inner core made up of?", "Solid Iron", "Solid Magnesium", "Solid Carbon", "Liquid Nitrogen", 1));
                options.add(earthQ6 = new Options("Compared to other planets, how big is Earth?", "Smallest", "2nd largest", "3rd smallest", "4th smallest", 4));
                options.add(earthQ7 = new Options("When did life first arise on Earth?", "4.1 billion  years ago", "2.5 billion  years ago", "3 million years ago", "2.3 billion years ago", 1));
                options.add(earthQ8 = new Options("What special property is Earth?", "Most dense", "Least dense", "Most gaseous", "Least liquid", 1));
                break;

                case "Jupiter":
                    Options jupiterQ1;
                    Options jupiterQ2;
                    Options jupiterQ3;
                    Options jupiterQ4;
                    Options jupiterQ5;
                    Options jupiterQ6;
                    Options jupiterQ7;
                    Options jupiterQ8;

                    options.add(jupiterQ1 = new Options("Which planet from the Sun is Jupiter?", "6th", "5th", "4th", "1st", 2));
                    options.add(jupiterQ2 = new Options("How bright is Jupiter on average compared to other natural objects from Earth?","3rd brightest", "Brightest", "2nd brightest", "5th brightst", 1));
                    options.add(jupiterQ3 = new Options("What is Jupiter primarily composed of?","Hydrogen & Helium", "Carbon", "Oxygen", "Helium & Iron", 1));
                    options.add(jupiterQ4 = new Options("What shape does Jupiter have?","Oblate spheroid", "Obscure spheroid", "Acute spheroid", "Inflated spheroid", 1));
                    options.add(jupiterQ5 = new Options("What is the giant storm on Jupiter that can be viewed by telescope called?","Giant Red Spot", "Giant Blue Spot", "Giant Red Region", "Giant Orange Region", 1));
                    options.add(jupiterQ6 = new Options("How many moons does Jupiter have?", "79 moons", "57 moons", "24 moons", "17 moons", 1));
                    options.add(jupiterQ7 = new Options("Which moon of Jupiter do scientists believe could potentially habour life?", "Europa", "Oblivion", "Oportus-3", "Graviton", 1));
                    options.add(jupiterQ8 = new Options("What type of giant is Jupiter?", "Gas giant", "Solid giant", "Liquid giant", "Solid & Liquid giant", 1));
                    break;

                case "Venus":
                    Options venusQ1;
                    Options venusQ2;
                    Options venusQ3;
                    Options venusQ4;
                    Options venusQ5;
                    Options venusQ6;
                    Options venusQ7;
                    Options venusQ8;

                    options.add(venusQ1 = new Options("Which planet from the Sun is Venus?","6th", "3rd", "2nd", "1st", 3));
                    options.add(venusQ2 = new Options("What is Venus' atmosphere consisted of?","96% carbon dioxide", "59% oxygen", "85% helium", "63% hydrogen", 1));
                    options.add(venusQ3 = new Options("Venus is shrouded by an opaque layer of what?", "Clouds of carbon dioxide", "Clouds of sulphuric acid", "Clouds of hydrogen", "Clouds of helium", 2));
                    options.add(venusQ4 = new Options("How long does it take Venus to orbit the Sun?","243 days", "398 days", "47 days", "365 days", 1));
                    options.add(venusQ5 = new Options("Venus is:" , "the coldest planet in our Solar System at 23K", "the coldest planet in our Solar System at 0K", "the hottest planet in our Solar System at 735K", "the hottest planet in our Solar System at 1000K", 3));
                    options.add(venusQ6 = new Options("Which Roman deity is the planet Pluto named after?","Goddess of Love", "Goddess of Good Harvest", "Goddess of Good Fortune", "4th smallest", 4));
                    options.add(venusQ7 = new Options("How many moons does Venus have?","0", "4", "6", "2", 1));
                    options.add(venusQ8 = new Options("Is Venus visible from Earth to the visible eye?", "Yes, you can even sometimes see it in daylight", "No, it is too far away to be visible", "Yes, but only at night", "No, it's too small to be seen", 1));
                    break;


                case "Pluto":
                    Options plutoQ1;
                    Options plutoQ2;
                    Options plutoQ3;
                    Options plutoQ4;
                    Options plutoQ5;
                    Options plutoQ6;
                    Options plutoQ7;
                    Options plutoQ8;

                    options.add(plutoQ1 = new Options("Which planet from the Sun is Pluto?","6th", "3rd", "9th", "1st", 3));
                    options.add(plutoQ2 = new Options("Where is Pluto situated?","Kuiper belt", "Orion belt", "Maximus belt", "Jupital belt", 1));
                    options.add(plutoQ3 = new Options("What is Pluto primarily made up of?", "Ice & rock", "Rock & water", "Gas & rock", "Gas & water", 1));
                    options.add(plutoQ4 = new Options("How long does light from the Sun take to reach Pluto?","5 hours", "4.5 hours", "6.5 hours", "5.5 hours", 4));
                    options.add(plutoQ5 = new Options("How many moons does Pluto have?", "5", "8", "2", "0", 1));
                    options.add(plutoQ6 = new Options("What size is Pluto in comparison to other bodies in our Solar System?", "Smallest", "2nd largest", "3rd smallest", "9th smallest", 4));
                    options.add(plutoQ7 = new Options("What spacecraft performed a fly-by of Pluto in 2015?","New Horizons", "New Orbits", "Pro Horizons", "Martian Explorer", 1));
                    options.add(plutoQ8 = new Options("What is the name of Pluto's largest moon?","Hammer", "Charon", "Kapers", "Orion", 2));
                    break;


        }
        return options;
    }

}





