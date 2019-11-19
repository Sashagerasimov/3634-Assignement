package com.example.a3634_assigment.Models;

import java.util.Arrays;
import java.util.ArrayList;

public class QuizBank {
    String planet;
    ArrayList<String> words;
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

    public static int getScore(String levels) {
        // Returns the score value of the questions
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

    public static ArrayList<String> getQuestions(String category) {
        // Sentence bank for the app
        ArrayList<String> questionList = new ArrayList<>();
        switch (category) {
            case "Neptune":
                questionList.add("Which planet from the Sun is Neptune?"); //8th
                questionList.add("How many times in mass is Neptune larger than Earth?"); //17 times
                questionList.add("How long does it take Mars to orbit the Sun once?");//164.8 years
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
                questionList.add("How many moons does Mars have?"); //0
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
            //chance
        }
        return questionList;
    }

    public static ArrayList<String> getAnswers(String category) {
        // Sentence bank for the app
        ArrayList<String> answerList = new ArrayList<>();
        switch (category) {
            case "Neptune":
                answerList.add("8th"); //3rd
                answerList.add("17 times"); //71%
                answerList.add("164.8 years");//99%
                answerList.add("Hydrogen & Helium");//365days
                answerList.add("55K"); //solid iron
                answerList.add("2nd smallest"); //
                answerList.add("blue"); //4.1billion years ago
                answerList.add("14 moons"); //most dense
                break;
            case "Mars":
                answerList.add("4th"); //3rd
                answerList.add("Olympus Mons"); //71%
                answerList.add("Low atmospheric pressure");//99%
                answerList.add("Earth");//365days
                answerList.add("yes"); //solid iron
                answerList.add("2nd smallest"); //
                answerList.add("red"); //4.1billion years ago
                answerList.add("2 moons"); //most dense
                break;
            case "Mercury":
                answerList.add("1st"); //3rd
                answerList.add("Messenger of the gods"); //71%
                answerList.add("2");//99%
                answerList.add("87.97 days");//365days
                answerList.add("yes"); //solid iron
                answerList.add("Smallest"); //
                answerList.add("no"); //4.1billion years ago
                answerList.add("0"); //most dense
                break;

                case "Saturn":
                answerList.add("6th"); //3rd
                answerList.add("10 hours 33 mins"); //71%
                answerList.add("gaseous");//99%
                answerList.add("29 years");//365days
                answerList.add("1800km/hr"); //solid iron
                answerList.add("2nd largest"); //
                answerList.add("yellow"); //4.1billion years ago
                answerList.add("82"); //most dense
                break;
            case "Earth":
                answerList.add("3rd"); //3rd
                answerList.add("71%"); //71%
                answerList.add("99%");//99%
                answerList.add("365 days");//365days
                answerList.add("solid iron"); //solid iron
                answerList.add("4th smallest"); //
                answerList.add("4.1 billion years ago"); //4.1billion years ago
                answerList.add("most dense"); //most dense
                break;

    }
    return answerList;
    }
        public static ArrayList<Options> getOptions(String category){
            // Sentence bank for the app
            //makeQuestions();
            ArrayList<Options> options = new ArrayList<>();
            switch (category) {
                case "Neptune":
                    Options neptuneQ1;
                    Options neptuneQ2;
                    Options neptuneQ3;
                    Options neptuneQ4;
                    Options neptuneQ5;
                    Options neptuneQ6;
                    Options neptuneQ7;
                    Options neptuneQ8;

                    options.add(neptuneQ1 = new Options("8th", "3rd", "4th", "5th", 1));  //3rd
                    options.add(neptuneQ2 = new Options("17 times", "18 times", "2 times", "4 times", 1)); //71%
                    options.add(neptuneQ3 = new Options("164.8 years", "10 years", "5 years", "208.4 years", 1));//99%
                    options.add(neptuneQ4 = new Options("Hydrogen", "Helium", "Hydrogen & Helium", "Carbon", 3));//365days
                    options.add(neptuneQ5 = new Options("60K", "100K", "55K", "20K", 3)); //solid iron
                    options.add(neptuneQ6 = new Options("smallest", "2nd smallest", "3rd smallest", "4th smallest", 2)); //
                    options.add(neptuneQ7 = new Options("green", "red", "purple", "blue", 4)); //4.1billion years ago
                    options.add(neptuneQ8 = new Options("14", "15", "3", "72", 1)); //most dense
                    break;
            }
            return options;
        }

    }





