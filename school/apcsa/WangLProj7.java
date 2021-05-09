import cardgames.*;
import javax.swing.JOptionPane;

public class WangLProj7 
{
    public static void main(String[] args) 
    {
        //declaring and instantiating a GUI object that shows 2 Cards
        GUI gui = new GUI(2, true);

        //declaring and instantiating a Deck object
        Deck deck = new Deck();
        
        //storing the original bank value
        double bank = 100;
        boolean end = false;
        while(!end)
        {
            //shuffling the Deck
            deck.shuffleDeck();

            //displaying the bank amount in the GUI
            gui.showAmount(bank);

            //dealing 2 Cards from deck and storing the references
            Card card1 = deck.dealCard();
            Card card2 = deck.dealCard();

            //getting the values of the Cards
            int val1 = card1.getValue();
            int val2 = card2.getValue();

            //determining the order in which the Cards should be displayed
            Card first;
            Card second;
            if(val1 <= val2)
            {
                first = card1;
                second = card2;
            }
            else
            {
                first = card2;
                second = card1;
            }
            gui.showCard(first);
            gui.showCard(second);

            //prompting the player for their bet
            String msg = "Will the next card be..."
                    + "\n" + "1. before Card 1?"
                    + "\n" + "2. between the two cards?"
                    + "\n" + "3. after Card 2?"
                    + "\n" + "Enter the preceding number to make your choice.";
            String betRaw = JOptionPane.showInputDialog(msg);
            int bet = Integer.parseInt(betRaw);

            //prompting the player for the value of their bet
            String msg2 = "How much do you want to bet?";
            String betValRaw = JOptionPane.showInputDialog(msg2);
            double betVal = Double.parseDouble(betValRaw);

            //displaying the bet
            gui.showBet(betVal);

            //dealing a Card from deck and displaying it
            Card deckCard = deck.dealCard();
            gui.showDeckCard(deckCard);

            //comparing deckCard to card1 and card2 to see if the player has won
            int result = -1;
            int val3 = deckCard.getValue();
            if(val3 < first.getValue())
                result = 1;
            else if(val3 > second.getValue())
                result = 3;
            else
                result = 2; 

            boolean hasWon = result == bet;
            if(hasWon)
            {
                bank += betVal*2;
                gui.showMessage("You won!");
            }
            else
            {
                bank -= betVal;
                gui.showMessage("You lost >:)");
            }
            gui.showAmount(bank);
            
            //ending of the game
            if(bank > 0)
            {
                //prompting the player
                String msg3 = "Do you want to play again?"
                        + "\n" + "Enter Y or N";
                String input = JOptionPane.showInputDialog(msg3);
                
                //acting accordingly
                if(input.equals("Y"))
                {
                    gui.clearDeckCard();
                    gui.clearPlayerCards();
                }
                else
                {
                    end = true;
                }
            }
            else
                end = true;
        }
            
    }
}
