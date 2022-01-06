package _01_Spies_On_A_Train;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import _00_Intro_to_Linked_Lists.LinkedList;

public class SpiesOnATrainTest {

    final String[] names = { "Ali", "Francis", "Kelly", "Cate", "Jason",
            "Phillip", "Norman", "Sam", "Desmond", "Vesper", "Froy", "Lemmy",
            "Quiller", "Xander" };

    final String[] clues = { "eating a cherry pie", "eating an apple pie",
            "eating a pumpkin pie", "eating key lime pie",
            "speaking on a model XD phone", "speaking on a model ZL phone",
            "speaking on a model GX phone", "speaking on a model AV phone",
            "carrying a black briefcase", "carrying a red briefcase",
            "carrying a brown briefcase", "carrying a blue briefcase" };
    
    private String spy;

    @Test
    public void findIntelTest() {

        ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList(names));
        ArrayList<String> listOfClues = new ArrayList<>(Arrays.asList(clues));

        Random rand = new Random();

        spy = listOfNames.remove(rand.nextInt(listOfNames.size()));

        String[] spyClues = new String[3];
        int clueCategoryIndex = 0;
        int amountInCategory = 4;

        for (int i = 0; i < spyClues.length; i++) {
            spyClues[i] = listOfClues
                    .remove(rand.nextInt(amountInCategory) + clueCategoryIndex);
            clueCategoryIndex += 3;
        }

        ArrayList<Integer> listOfIndices = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            listOfIndices.add(i);
        }

        int[] spyClueIndices = new int[spyClues.length];

        for (int i = 0; i < spyClueIndices.length; i++) {
            spyClueIndices[i] = listOfIndices
                    .remove(rand.nextInt(listOfIndices.size()));
        }

        Arrays.sort(spyClueIndices);

        int spyLocation = listOfIndices
                .remove(rand.nextInt(listOfIndices.size()));

        int[] redHerringIndices = new int[spyClues.length - 1];

        for (int i = 0; i < redHerringIndices.length; i++) {
            redHerringIndices[i] = listOfIndices
                    .remove(rand.nextInt(listOfIndices.size()));
        }

        Arrays.sort(redHerringIndices);

        LinkedList<TrainCar> train = new LinkedList<>();
        int spyIndex = 0;
        int redHerringIndex = 0;

        for (int i = 0; i < names.length; i++) {

            String observer = "";
            String evidence = "";

            if (i == spyLocation) {

                observer = spy;

            } else {

                observer = listOfNames.remove(rand.nextInt(listOfNames.size()));

            }

            if (spyIndex <= 2 && i == spyClueIndices[spyIndex]) {

                String spyClue = spyClues[spyIndex];

                evidence = spy + " " + spyClue;

                spyIndex++;

            } else if (redHerringIndex <= 1
                    && i == redHerringIndices[redHerringIndex]) {
                
                String fakeClue = spyClues[redHerringIndex];

                ArrayList<String> listOfSuspects = generateListOfSuspects(
                        observer);

                String observee = listOfSuspects
                        .get(rand.nextInt(listOfSuspects.size()));

                evidence = observee + " " + fakeClue;

                redHerringIndex++;
            } else {

                String randomClue = listOfClues
                        .remove(rand.nextInt(listOfClues.size()));

                ArrayList<String> listOfSuspects = generateListOfSuspects(
                        observer);

                String observee = listOfSuspects
                        .get(rand.nextInt(listOfSuspects.size()));

                evidence = observee + " " + randomClue;

            }

            train.add(new TrainCar(observer, evidence));
        }

        SpiesOnATrain agent = new SpiesOnATrain();
        
        boolean foundSpy = spy.equals(agent.findIntel(train, spyClues));
        
        if(foundSpy) {
            System.out.println("Your agency apprehended the spy! It was " + spy);
        }
        else {
            System.out.println("The spy escaped! It was " + spy);
        }

        assertTrue(foundSpy);
    }

    private ArrayList<String> generateListOfSuspects(String observer) {

        ArrayList<String> listOfSuspects = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {

            if (!names[i].equals(observer) && !names[i].equals(spy)) {

                listOfSuspects.add(names[i]);

            }

        }

        return listOfSuspects;

    } 

}
