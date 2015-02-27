import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Background
{
    public void Message(String Player) 
	{
        System.out.println(String.format("\nWelcome, %s!\n \nPlease Pick An Option \n", Player));	//Takes the name that was given and uses it for a welcome message.
    }
    
    public void Menu() 
	{
        System.out.println("1) Enter Another Players Name\n2) Begin The Game\n3) Quit The Menu"); //Presents the user with 3 options that they can pick from.
        System.out.println("\nPick From 1, 2 Or 3:");	//Tells the user to pick one of the 3 options.
    }
    
    public void printPlayerInfo(List<Player> PlayerList) //Gets the list of players.
	{
        System.out.println("There Are " + PlayerList.size() + " Playing."); //Prints the number of players there are.
        System.out.println("The Players Are:"); //Prints who the players are.
        for (Player Player:PlayerList) 	//Runs through the players.
		{
           System.out.println(Player.getName());//Prints the players.
		}
    } 

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void BowlFrame(Player Player, int Frame) throws IOException 
	{
        int TotalScore = 0; //Creates the total score int.
        int ExtraBallCount = Player.checkExtraBallCount(); //Creates an extra ball equal to the players extra ball count.
        System.out.println("\n It's" + Player.getName() + "'s Go To Bowl\n"); //Prints out who's up next to bowl.
        System.out.println("Enter Your Score For Your First Bowl:"); //Asks the user what they scored.
        int Score = getScore(TotalScore); //Creates the score int and set it to equal total score.
        TotalScore = TotalScore + Score; //Sets total score to equal score plus previous total score.
        Player.setFirstBall(Frame, Score); //Sets the first ball for the player setting the frame and score.
        
        if (ExtraBallCount == 1 | ExtraBallCount == 2) //If extra ball count is equal to 1 or 2.
		{
            Player.setPlayerScore(Score + Score); //Updates the players current score.
            ExtraBallCount -= 1; //Takes extra ball count and takes away 1.
        }
        else if (ExtraBallCount == 3) //If extra ball count is equal to 3.
		{
            Player.setPlayerScore(Score + Score + Score); //Updates the players current score.
            ExtraBallCount -= 2; //Takes extra ball count and takes away 2.
        }
        else 
		{
            Player.setPlayerScore(Score); //Updates the players current score.
        }
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        if (TotalScore == 10) //Sees if the second ball was a strike.
		{ 
            Player.setSecondball(Frame, 0); //Sets second ball to 0.
            System.out.println("You Scored A Strike"); //Tells the player they scored a strike.
        }
        else 
		{
            System.out.println("Enter Your Score For Your Second Bowl:"); // Gets Score for second ball, if there was no strike.
            Score = getScore(TotalScore); //Sets score to equal total score.
            Player.setSecondball(Frame, Score); //Sets players frame and score.
            if (ExtraBallCount == 1) { //If extra ball = 1
                Player.setPlayerScore(Score + Score); //Sets the players score to equal score plus score, adjusted for the extra ball.
            }
            else {
                Player.setPlayerScore(Score); //Sets the players score to equal the score.
            }
            TotalScore = TotalScore + Score; //Updates the total score.
            if (TotalScore == 10) { // Checks for spare
                System.out.println("You have bowled a spare!!");
            }
        }
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        if ((Player.checkFirstBall(Frame)) == 10) { // Updates counter if the player got a strike.
            ExtraBallCount += 2; //Extra ball count plus 2
        }
        else if (TotalScore == 10) // Updates extra ball counter if the player got a spare.
		{ 
            ExtraBallCount += 1; //Extra ball count plus 1
        }
        Player.setExtraBallCount(ExtraBallCount);  //Updates the players current score.
        System.out.println(Player.getName() + "'s total Score is " + Player.checkPlayerScore()); //Tells the player there score.
    } 
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    /*
    * Special system for scoring the last Frame.
    * Includes bonus ball if the Player got a strike or spare.
    */
    public void LastFrame(Player Player, int Frame) throws IOException 
	{
        int TotalScore = 0;
        int ExtraBallCount = Player.checkExtraBallCount();
        System.out.println("\n" + Player.getName() + " is up!\n");
        
        // Bowl first ball
        System.out.println("Enter your Score for ball 1:");
        int Score = getScore(TotalScore);
        TotalScore = TotalScore + Score;
        Player.setFirstBall(Frame, Score);
        
        // Update Player Score
        if (ExtraBallCount == 1 | ExtraBallCount == 2) 
		{
            Player.setPlayerScore(Score + Score);
            ExtraBallCount -= 1;
        }
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (ExtraBallCount == 3) 
		{
            Player.setPlayerScore(Score + Score + Score);
            ExtraBallCount -= 2;
        }
        else 
		{
            Player.setPlayerScore(Score);
        }

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        // Bowl second ball - system for when Player bowled a strike on the first ball
        if (TotalScore == 10)
		{ 
            System.out.println("You have bowled a strike!!");
            ExtraBallCount += 2;
            System.out.println("Enter your Score for ball 2:");
            Score = getScore();
            Player.setSecondball(Frame, Score);
            
			if (ExtraBallCount == 1 | ExtraBallCount == 2) 
			{
                Player.setPlayerScore(Score);
                ExtraBallCount -= 1;
            }
           
		   if (ExtraBallCount == 3) {
                Player.setPlayerScore(Score + Score);
                ExtraBallCount -= 2;
            }
        }
        // Bowl second ball - system for when Player did not bowl a strike on the first ball
        else {
            System.out.println("Enter your Score for ball 2:");
            Score = getScore(TotalScore);
            Player.setSecondball(Frame, Score);
            TotalScore = TotalScore + Score;
            if (ExtraBallCount == 1 | ExtraBallCount == 2) 
			{
                Player.setPlayerScore(Score + Score);
                ExtraBallCount -= 1;
            }
            else 
			{
                Player.setPlayerScore(Score);
            }
        }
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        // Bowl bonus bowl if Player bowled any strikes or a spare this Frame  
        if (TotalScore == 10) 
		{
            System.out.println("Strike");
            System.out.println("You have earned a bonus ball! Enter your Score for the bonus ball:");
            Score = getScore();
            Player.setExtraBallCount(Score);
            if (Score == 10) 
			{
                System.out.println("Strike!!!");
            }
            Player.setPlayerScore(Score);
        }
        
        System.out.println(Player.getName() + "'s total Score is " + Player.checkPlayerScore());

    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    /*
    * Gets the bowling Score from the Player
    */
    public int getScore(int TotalScore) throws IOException
	{
        boolean validScore = false;
        int tempScore = 0;
        while (validScore == false) 
		{
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            while (temp.equals("")) 
			{
                System.out.println("Please enter a number.");
                temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }
            tempScore = Integer.parseInt(temp);
            if ((tempScore < 0) | (tempScore + TotalScore > 10) )
			{
                System.out.println("You have entered an invalid number. Please try again.");
            }
            else 
			{
                validScore = true;
            }            
        } 
       return tempScore;
    } // end GetScore method
    
    /*
    * Gets the bowling Scores for the bonus round
    */
    public int getScore() throws IOException
	{
        boolean validScore = false;
        int tempScore = 0;
        while (validScore == false) 
		{
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (temp == null)
			{
                System.out.println("Please enter a number.");
            }
            tempScore = Integer.parseInt(temp);
            if (tempScore < 0 | tempScore > 10)
			{
                System.out.println("You have entered an invalid number. Please try again.");
            }
            else 
			{
                validScore = true;
            }            
        } 
       return tempScore;
    } // end GetScore method for bonus round
}