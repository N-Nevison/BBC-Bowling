import java.util.List;

public class ScoreBoard
{
    public void printScores(List<Player> ListOfPlayers) 
	{
        System.out.println("\nThe Final Scores Are: \n"); //Prints the final scores for the users to see.
        for (Player Player:ListOfPlayers) 
		{
            System.out.println(Player.getName() + " Your Total Score Is: " + Player.checkPlayerScore()); // Prints out each persons score.
            System.out.println("______________________________________________________________"); // Separates the players scores.
            System.out.print("|");
            for (int i = 0; i < 9; i ++) //For the first 9 frames
			{
                if (Player.checkFirstBall(i) == 10) //Sees if the first ball was a strike.
				{
                    System.out.print("X|"); //Prints as X the symbol for a strike.
                }
                else System.out.print(Player.checkFirstBall(i) + "|"); //Prints out there will be a second ball.
                
				if (Player.checkSecondBall(i) == 0) //Checks if the user hit no pins.
				{
                    System.out.print(" |");	//Prints out no pins.
                }
                else if ((Player.checkFirstBall(i) + Player.checkSecondBall(i)) == 10) //Sees if the user got 10 via a spare.
				{
                    System.out.print("/|");	//Prints out / the symbol for spare.
                }
                else 
				{
                    System.out.print(Player.checkSecondBall(i) + "|"); //Prints out no pins.
                }
            } 
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
            if (Player.checkFirstBall(9) == 10)  //Sees if the first ball was a strike.
			{
                System.out.print("X|"); //Prints as X the symbol for a strike.
            }
            else System.out.print(Player.checkFirstBall(9) + "|"); //Prints out there will be a second ball.
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
			if (Player.checkSecondBall(9) == 10) //Sees if the second ball was a strike.
			{
                System.out.print("X|");	//Prints as X the symbol for a strike.
            }
            else if ((Player.checkFirstBall(9) + Player.checkSecondBall(9)) == 10)  //Sees if the user got 10 via a spare.
			{
                System.out.print("/|"); //Prints out / the symbol for spare.
            }
            else 
			{
                System.out.print(Player.checkSecondBall(9) + "|");  //Prints out no pins.
            }
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            if ((Player.checkFirstBall(9) == 10) | (Player.checkFirstBall(9) + Player.checkSecondBall(9) == 10))  
			{
                if (Player.checkFirstBall(9) == 10) //Sees if the first ball was a strike.
				{
                    System.out.println("X|"); //Prints as X the symbol for a strike.
                }
                else 
				{
                    System.out.println(Player.checkExtraBalls() + "|"); //Prints out the extra ball count.
                }
            }
            else 
			{
                System.out.println(" |"); //Prints out no pins.
            }
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
			System.out.println("|___|___|___|___|___|___|___|___|___|_____|"); //Prints out the total score.
            System.out.println("\n");
        }
    }
}