package _06_Card_Game;

public enum Rank {
    


    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
    TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    private int value;
    
    private final int HIGH_ACE = 11;
    private final int LOW_ACE = 1;

    private Rank(int value) {

        this.value = value;

    }

    public int getValue(int currentTotal) {

        
        if(value == HIGH_ACE && currentTotal + value > 21) {
            
            return LOW_ACE;
            
        }
        else {
            
            return value;
            
        }
    }

}
