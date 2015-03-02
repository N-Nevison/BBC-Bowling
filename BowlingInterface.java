import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class BowlingInterface
{
    public static void main(String[] args) throws IOException
    {
		//Loads the list of players and then displays a message.
        final Background Background = new Background();
        List<Player> PlayerList = new ArrayList<Player>(); // A list of players
        
        String selection = "";
        String Name;
        
        System.out.println("Please Enter Your Name:"); //Asks for the players name.
        Name = new BufferedReader(new InputStreamReader(System.in)).readLine(); //Reads the user input.
        PlayerList.add(new Player(Name)); //Adds that name to the player list.
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Goes Through The Menu Options.
        while (!selection.equals("2"))	//If user doe not go for option 2.
		{    
            Background.Message(PlayerList.get(0).getName()); //Prints message.
            Background.Menu(); //Loads the menu.

            selection = new BufferedReader(new InputStreamReader(System.in)).readLine(); //Gets menu selection number.
            
            switch(Integer.parseInt(selection)) //Gives the user the selection of the options.
			{
            case 1:
                System.out.println("\nPlease Enter The Other Persons Name"); //Asks for the next persons name. 
                Name = new BufferedReader(new InputStreamReader(System.in)).readLine(); //Takes in the input the user has given.
                PlayerList.add(new Player(Name)); //Adds that name to the player list.
                break;
            
			case 2:
               Background.printPlayerInfo(PlayerList);  //Prints the player list and then starts game.
               break;
           
			case 3:
               System.out.println("Bye."); //Prints bye.
               System.exit(0); //Exits the game.
            
			default:
               System.out.println("You Have Entered An Invalid Selection. Please Enter A New Input."); //Prints Error message for invalid selections
               System.out.println("");
            } //Exits from the user selection.
        } //Exits from loop.

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        for (int i=0; i<9; i++) //Frames from 1-9.
		{
            System.out.println("\n----------Frame " + (i + 1) + " Has Started----------"); //Prints the frame that has begun.
            for (Player Player:PlayerList) //Gets players in the the player list.
			{
                Background.BowlFrame(Player, i); //Does the frame through all the players on the player list.
				System.out.println("\n-------------------------");
            }
        }
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        System.out.println("\n-----------Final Frame Has Started----------"); //Final frame.
        for (Player Player:PlayerList) //Gets players in the the player list.
		{
            Background.LastFrame(Player, 9); //Does the final frame through all the players on the player list.
			System.out.println("\n-------------------------");
        }
        
        final ScoreBoard Scoreboard = new ScoreBoard(); //Gets the scoreboard.
        Scoreboard.printScores(PlayerList); //Displays the scores on the scoreboard.
    }
}