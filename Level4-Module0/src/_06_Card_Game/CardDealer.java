package _06_Card_Game;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class CardDealer extends Player {

    private ArrayList<Card> deck;
    private Rank[] ranks;
    private Suit[] suits;
    private Random shuffler;
    private int cut;

    CardDealer(String name) {
        super(name);
        ranks = Rank.values();
        suits = Suit.values();
        shuffler = new Random();
        openNewDeck();
    }

    public void openNewDeck() {
        
        JOptionPane.showMessageDialog(null, "Opening a new deck...");

        deck = new ArrayList<>();

        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck.add(new Card(ranks[i], suits[j]));
            }
        }

        shuffle();
        
        cut = shuffler.nextInt(deck.size()/4) + deck.size()/4; 
    }

    public void shuffle() {

        int shuffleCounter = 0;

        while (shuffleCounter < 52) {

            int firstCard = shuffler.nextInt(deck.size());
            int secondCard = shuffler.nextInt(deck.size());

            if (firstCard != secondCard) {

                Card tempCard = deck.get(firstCard);
                deck.set(firstCard, deck.get(secondCard));
                deck.set(secondCard, tempCard);
                shuffleCounter++;
            }

        }

    }

    public void dealCardToOnePlayer(Player currentPlayer) {
        currentPlayer.addCardToHand(deck.remove(0));
    }

    public void dealCardsToAll(ArrayList<Player> players) {

        for (int i = 0; i < players.size(); i++) {

            players.get(i).addCardToHand(deck.remove(0));

        }

        addCardToHand(deck.remove(0));

        for (int i = 0; i < players.size(); i++) {

            players.get(i).addCardToHand(deck.remove(0));

        }

        addCardToHand(deck.remove(0));

    }
    
    public void clearCards(ArrayList<Player> players) {
        
        for (Player player : players) {
            player.clearHand();
        }
        
        clearHand();
        
    }
    
    public boolean needsNewDeck() {
        return deck.size() <= cut;
    }
    
    @Override
    public Card getUpCard() {
        return getHand().get(1);
    }

}
