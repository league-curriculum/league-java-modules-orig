package _03_Intro_to_Enums;

import java.util.Random;

public class EnumDemo {
    /*
     * enum (short for enumerated type) is a way to categorize a set of states
     * or values into their own type.
     */

    enum Elements {

        // Every entry must be unique.
        WATER, EARTH, FIRE, AIR
    }

    /*
     * enums can be defined within a class as shown in this demo or within their
     * own files as shown in StatesOfMatter.java.
     */

    enum Planets {

        /*
         * enums can have member variables and methods just like classes.
         * 
         * Each entry in an enum can be given default values that can be used to
         * initialize member variables in a constructor like daysToOrbitSun.
         */

        MERCURY(88), VENUS(225), EARTH(365), MARS(687), JUPITER(4333),
        SATURN(10759), URANUS(30687), NEPTUNE(60190);

        private final int daysToOrbitSun;

        /*
         * In the case of an enum we can make our constructor private because
         * the default value is passed internally and enums do not require the
         * "new" keyword to be initialized.
         */

        private Planets(int daysToOrbitSun) {
            this.daysToOrbitSun = daysToOrbitSun;
        }

        public int getDaysToOrbitSun() {
            return this.daysToOrbitSun;
        }

    }

    public static void main(String[] args) {

        // A single enum value can be can be used to initialize a variable.

        Planets planet = Planets.MERCURY;

        // enums be used for if statement comparisons.

        if (planet == Planets.MERCURY) {

            System.out.println(planet + " takes " + planet.getDaysToOrbitSun()
                    + " days to orbit the sun!");

        }

        /*
         * The .values() method returns every unique entry of an enum as an
         * array.
         */

        Planets[] planets = Planets.values();

        
        /*
         * The planet variable can then be set to any random value in planets
         * through the following method.
         */
        
        Random random = new Random();

        planet = planets[random.nextInt(planets.length)];

        // Then used in a switch statement.

        switch (planet) {

        /*
         * Notice that the name of the enum's type is not required for the cases
         * in the switch statement.
         */

        case MERCURY: {
            System.out.println("Mercury has no moons!");
            break;
        }
        case VENUS: {
            System.out.println("Venus has no moons!");
            break;
        }
        case EARTH: {
            System.out.println("Earth has 1 moon!");
            break;
        }
        case MARS: {
            System.out.println("Mars has 2 moons!");
            break;
        }
        case JUPITER: {
            System.out.println("Jupiter has 79 moons!");
            break;
        }
        case SATURN: {
            System.out.println("Saturn has 62 moons!");
            break;
        }
        case URANUS: {
            System.out.println("Uranus has 27 moons!");
            break;
        }
        case NEPTUNE: {
            System.out.println("Neptune has 14 moons!");
            break;
        }

        }

        StatesOfMatter[] states = StatesOfMatter.values();
        
        enumDemoMethod(states[random.nextInt(states.length)]);

    }

    // enums can also be passed into methods as Parameters.

    static void enumDemoMethod(StatesOfMatter matter) {

        System.out.println(matter);

    }
}
