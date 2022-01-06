package _02_Rainbow_Zombie_Conga_Line;

import java.util.Random;
import java.util.Scanner;

import _00_Intro_to_Linked_Lists.LinkedList;

public class RainbowZombieDanceParty {

    public static void main(String[] args) {

        RainbowZombieCongaLine danceParty = new RainbowZombieCongaLine();
        LinkedList<Zombie> congaLine = danceParty.getCongaLine();

        ZombieHatColor[] hatColors = ZombieHatColor.values();
        ZombieAction[] zombieActions = ZombieAction.values();

        Random rand = new Random();

        Scanner sc = new Scanner(System.in);

        System.out.println("How many rounds would you like?");

        int rounds = 0;
        int currentRound = 0;

        try {
            rounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ERROR - Please enter a whole number.");
        } catch (Exception e) {
            System.out.println("ERROR - Illegal input.");
        } finally {
            sc.close();
            System.out.println();
        }

        while (currentRound < rounds + 1) {

            int randomColor = rand.nextInt(hatColors.length);

            Zombie dancer = (new Zombie(hatColors[randomColor]));

            int randomAction = 0;

            if (currentRound == 0) {

                randomAction = zombieActions.length - 1;

            } else if (congaLine.size() > 0
                    || (randomAction < 2 && randomAction > 4)) {

                randomAction = rand.nextInt(zombieActions.length);

            } else {
                continue;
            }

            System.out.print("Action: " + zombieActions[randomAction]);
            System.out.print(" | " + "Hat Color: " + hatColors[randomColor]);

            switch (zombieActions[randomAction]) {

            case ENGINE:
                danceParty.engine(dancer);
                break;

            case CABOOSE:
                danceParty.caboose(dancer);
                break;

            case JUMP_IN_THE_LINE:
                int position = rand.nextInt(congaLine.size());
                System.out.print(" | " + "Position: " + position);
                danceParty.jumpInTheLine(dancer, position);
                break;

            case EVERYONE_OUT:
                danceParty.everyoneOut(dancer);
                break;

            case YOU_ARE_DONE:
                danceParty.youAreDone(dancer);
                break;

            case BRAINS:
                danceParty.brains(dancer);
                break;

            case RAINBOW_BRAINS:
                danceParty.rainbowBrains(dancer);
                break;
            }

            System.out.println();
            congaLine.print();
            System.out.println();

            if (currentRound > 0 && currentRound % 5 == 0) {
                System.out.println("Round: " + (currentRound));
                System.out.println("Removing head and tail");
                congaLine.remove(0);
                congaLine.remove(congaLine.size() - 1);
                congaLine.print();
                System.out.println();
            }

            currentRound++;
        }
    }
}
