package _06_Card_Game;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class CardTable {

    private ArrayList<Player> players;

    private CardDealer dealer;
    
    public CardTable() {
        
        JOptionPane.showMessageDialog(null, "Welcome to Blackjack!");
        setPlayers(new ArrayList<>());
        setDealer(new CardDealer("Dealer"));
        
    }

    public static void main(String[] args) {
        
        CardTable table = new CardTable();
        ArrayList<Player> players = table.getPlayers();
        CardDealer dealer = table.getDealer();  

        table.addPlayers();

        while (players.size() > 0) {

            if (dealer.needsNewDeck()) {
                dealer.openNewDeck();
            }

            dealer.dealCardsToAll(players);

            if (table.dealerHas21()) {

                continue;
            }

            table.playerTurn();

            table.dealerTurn();

            table.showFinalResults();

            table.askIfPlayersAreContinuing();
        }

    }

    public void addPlayers() {

        boolean addingPlayers = true;

        while (addingPlayers) {

            String playerName = JOptionPane.showInputDialog(
                    "Enter the name of the player you would like to add to the "
                            + "game. Otherwise, type done if finished.");

            if (playerName.equalsIgnoreCase("done")) {

                addingPlayers = false;
                break;

            } else {

                getPlayers().add(new Player(playerName));

            }

        }
    }

    public boolean dealerHas21() {
        if (getDealer().getTotal() == 21) {
            String result = "";

            result += "Dealer has a 21\n";

            for (Player player : getPlayers()) {

                if (player.getTotal() == 21) {
                    result += "\n\n" + player.getName() + " gets even money!";
                } else {
                    result += player.getName() + " loses!";
                }
            }

            JOptionPane.showMessageDialog(null, result);

            for (Iterator<Player> iterator = getPlayers().iterator(); iterator
                    .hasNext();) {

                Player player = (Player) iterator.next();

                String response = JOptionPane.showInputDialog(
                        player.getName() + ", do you want to continue?");

                if (response.equalsIgnoreCase("no")) {
                    iterator.remove();
                }

            }

            getDealer().clearCards(getPlayers());

            return true;
        }

        return false;

    }

   public void playerTurn() {
        for (int i = 0; i < getPlayers().size(); i++) {

            Player currentPlayer = getPlayers().get(i);

            boolean hitting = true;

            while (hitting) {

                String query = "It is your turn " + currentPlayer.getName()
                        + "!";

                query += "\n\nThe dealer's upcard is a(n) "
                        + getDealer().getUpCard();

                for (int j = 0; j < getPlayers().size(); j++) {

                    if (j == 0 && getPlayers().size() > 1) {
                        query += "\n\nYour fellow players' upcards are: \n";
                    }

                    if (!getPlayers().get(j).equals(currentPlayer)) {

                        Player opponent = getPlayers().get(j);

                        query += "\n" + opponent.getName() + " - "
                                + opponent.getUpCard();
                    }

                }

                query += "\n\nYour hand: \n\n" + currentPlayer.getHand();
                query += "\n\nYour total is " + currentPlayer.getTotal() + "!";
                query += "\n\nDo you want to hit or stay?";

                if (currentPlayer.isBusted()) {
                    JOptionPane.showMessageDialog(null, "You busted!");
                    hitting = false;
                    break;
                }

                String response = JOptionPane.showInputDialog(query);

                if (response.equalsIgnoreCase("hit")) {
                    getDealer().dealCardToOnePlayer(currentPlayer);
                } else {
                    hitting = false;
                    break;
                }
            }

        }
    }

    public void dealerTurn() {
        boolean dealerTurn = true;

        while (dealerTurn) {

            String dealerStatus = "Dealer's hand " + getDealer().getHand();
            dealerStatus += "\nDealer's total is " + getDealer().getTotal();

            JOptionPane.showMessageDialog(null, dealerStatus);

            if (getDealer().isBusted()) {
                JOptionPane.showMessageDialog(null, "Dealer busted!");
                dealerTurn = false;
                break;
            } else if (getDealer().getTotal() >= 17) {
                JOptionPane.showMessageDialog(null, "Dealer stays!");
                dealerTurn = false;
                break;
            }

            getDealer().dealCardToOnePlayer(getDealer());
        }
    }

    public void showFinalResults() {
        String result = "Final totals:";

        result += "\n" + getDealer().getTotal() + " - " + getDealer().getName();

        for (int j = 0; j < getPlayers().size(); j++) {

            Player currentPlayer = getPlayers().get(j);

            result += "\n" + currentPlayer.getTotal() + " - "
                    + currentPlayer.getName();

            if (currentPlayer.isBusted()
                    || (currentPlayer.getTotal() < getDealer().getTotal()
                            && !getDealer().isBusted())) {

                result += " loses!";

            } else {

                if ((getDealer().isBusted()
                        || currentPlayer.getTotal() > getDealer().getTotal())) {

                    result += " wins!";

                } else {

                    result += " pushes!";

                }
            }

        }

        JOptionPane.showMessageDialog(null, result);
    }

    public void askIfPlayersAreContinuing() {

        for (Iterator<Player> iterator = getPlayers().iterator(); iterator
                .hasNext();) {

            Player player = (Player) iterator.next();

            String response = JOptionPane.showInputDialog(
                    player.getName() + ", do you want to continue?(Y/N)");

            if (response.equalsIgnoreCase("N")) {
                iterator.remove();
            }

        }

        getDealer().clearCards(getPlayers());
        
        if(players.size() == 0) {
            JOptionPane.showMessageDialog(null, "Thanks for playing!");
        }

    }

    public CardDealer getDealer() {
        return dealer;
    }

    public void setDealer(CardDealer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}