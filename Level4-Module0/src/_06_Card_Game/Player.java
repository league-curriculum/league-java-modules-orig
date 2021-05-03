package _06_Card_Game;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private boolean isBusted = false;
    int total;

    public Player(String name) {

        this.name = name;
        hand = new ArrayList<>();
        isBusted = false;
        total = 0;

    }
    
    public void clearHand() {
        hand = new ArrayList<>();
        total = 0;
        isBusted = false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card newCard) {
        hand.add(newCard);
        getNewTotal();
    }

    public Card getUpCard() {
        return hand.get(0);
    }
    
    public boolean isBusted() {
        return isBusted;
    }
    
    public int getTotal() {
        return total;
    }

    private int getNewTotal() {
        
        total += hand.get(hand.size()-1).getRank().getValue(total);
        
        if(total > 21) {
            isBusted = true;
        }

        return total;

    }

}
