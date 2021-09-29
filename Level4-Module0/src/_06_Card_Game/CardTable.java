package _06_Card_Game;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class CardTable {

    static ArrayList<Player> players = new ArrayList<>();

    static CardDealer dealer = new CardDealer("Dealer");

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Blackjack!");

        addPlayers();

        while (players.size() > 0) {

            if (dealer.needNewDeck()) {
                JOptionPane.showMessageDialog(null, "Opening a new deck...");
                dealer.openNewDeck();
            }

            dealer.dealCardsToAll(players);

            if (dealerHas21()) {

                continue;
            }

            playerTurn();

            dealerTurn();

            showFinalResults();

            for (Iterator<Player> iterator = players.iterator(); iterator
                    .hasNext();) {

                Player player = (Player) iterator.next();

                String response = JOptionPane.showInputDialog(
                        player.getName() + ", do you want to continue?(Y/N)");

                if (response.equalsIgnoreCase("N")) {
                    iterator.remove();
                }

            }

            dealer.clearCards(players);
        }

    }

    public static void addPlayers() {

        boolean addingPlayers = true;

        while (addingPlayers) {

            String playerName = JOptionPane.showInputDialog(
                    "Enter the name of the player you would like to add to the "
                            + "game. Otherwise, type done if finished.");

            if (playerName.equalsIgnoreCase("done")) {

                addingPlayers = false;
                break;

            } else {

                players.add(new Player(playerName));

            }

        }
    }

    static boolean dealerHas21() {
        if (dealer.getTotal() == 21) {
            String result = "";

            result += "Dealer has a 21\n";

            for (Player player : players) {

                if (player.getTotal() == 21) {
                    result += "\n\n" + player.getName() + " gets even money!";
                } else {
                    result += player.getName() + " loses!";
                }
            }

            JOptionPane.showMessageDialog(null, result);

            for (Iterator<Player> iterator = players.iterator(); iterator
                    .hasNext();) {

                Player player = (Player) iterator.next();

                String response = JOptionPane.showInputDialog(
                        player.getName() + ", do you want to continue?");

                if (response.equalsIgnoreCase("no")) {
                    iterator.remove();
                }

            }

            dealer.clearCards(players);

            return true;
        }

        return false;

    }

    static void playerTurn() {
        for (int i = 0; i < players.size(); i++) {

            Player currentPlayer = players.get(i);

            boolean hitting = true;

            while (hitting) {

                String query = "It is your turn " + currentPlayer.getName()
                        + "!";

                query += "\n\nThe dealer's upcard is a(n) "
                        + dealer.getUpCard();

                for (int j = 0; j < players.size(); j++) {

                    if (j == 0 && players.size() > 1) {
                        query += "\n\nYour fellow players' upcards are: \n";
                    }

                    if (!players.get(j).equals(currentPlayer)) {

                        Player opponent = players.get(j);

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
                    dealer.dealCardToOnePlayer(currentPlayer);
                } else {
                    hitting = false;
                    break;
                }
            }

        }
    }

    public static void dealerTurn() {
        boolean dealerTurn = true;

        while (dealerTurn) {

            String dealerStatus = "Dealer's hand " + dealer.getHand();
            dealerStatus += "\nDealer's total is " + dealer.getTotal();

            JOptionPane.showMessageDialog(null, dealerStatus);

            if (dealer.isBusted()) {
                JOptionPane.showMessageDialog(null, "Dealer busted!");
                dealerTurn = false;
                break;
            } else if (dealer.getTotal() >= 17) {
                JOptionPane.showMessageDialog(null, "Dealer stays!");
                dealerTurn = false;
                break;
            }

            dealer.dealCardToOnePlayer(dealer);
        }
    }
    
    public static void showFinalResults() {
        String result = "Final totals:";

        result += "\n" + dealer.getTotal() + " - " + dealer.getName();

        for (int j = 0; j < players.size(); j++) {

            Player currentPlayer = players.get(j);

            result += "\n" + currentPlayer.getTotal() + " - "
                    + currentPlayer.getName();

            if (currentPlayer.isBusted()
                    || (currentPlayer.getTotal() < dealer.getTotal()
                            && !dealer.isBusted())) {

                result += " loses!";

            } else {

                if ((dealer.isBusted()
                        || currentPlayer.getTotal() > dealer.getTotal())) {

                    result += " wins!";

                } else {

                    result += " pushes!";

                }
            }

        }
        
        JOptionPane.showMessageDialog(null, result);
    }
}