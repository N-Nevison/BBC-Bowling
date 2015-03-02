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
        System.out.println("\nIt's " + Player.getName() + "'s Go To Bowl\n"); //Prints out who's up next to bowl.
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
            if (TotalScore == 10) { // Checks for spare.
                System.out.println("You Have Bowled A Spare!!"); //Tells they player they have scored a spare.
            }
        }
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
        if ((Player.checkFirstBall(Frame)) == 10) { //If its the players first ball of the frame.
            ExtraBallCount += 2; //Extra ball count plus 2..
        }
        else if (TotalScore == 10) //Else if total score is 10.
		{ 
            ExtraBallCount += 1; //Extra ball count plus 1.
        }
        Player.setExtraBallCount(ExtraBallCount);  //Updates the players extra ball count.
    } 
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public void LastFrame(Player Player, int Frame) throws IOException //Separate for the last frame.
	{
        int TotalScore = 0; //Sets the total score.
        int ExtraBallCount = Player.checkExtraBallCount(); //Sets the extra ball count to equal the players extra ball count.
        System.out.println("\n" + Player.getName() + " Is Up!\n"); //Tells the player who is bowling next.
        
        System.out.println("Enter Your Score For Ball 1:"); //Asks for the score for the first ball.
        int Score = getScore(TotalScore); //Sets score to equal the total score.
        TotalScore = TotalScore + Score; //Updates the total score.
        Player.setFirstBall(Frame, Score); //Sets the players frame and score.
        
        if (ExtraBallCount == 1 | ExtraBallCount == 2)  //If the extra ball count is 1 or 2.
		{
            Player.setPlayerScore(Score + Score); //Sets the players score to equal score + score.
            ExtraBallCount -= 1; //Extra ball count - 1.
        }
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (ExtraBallCount == 3)  //If the extra ball count is 3.
		{
            Player.setPlayerScore(Score + Score + Score); //Sets the players score to equal score + score + score.
            ExtraBallCount -= 2; //Extra ball count - 2.
        }
        else 
		{
            Player.setPlayerScore(Score); //Sets the players score to equal score.
        }

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//System for final frame, second ball (if strike on first)
        if (TotalScore == 10) //If total score is equal to 10.
		{ 
            System.out.println("You Have Bowled A Strike!!"); //Tell the player they bowled a strike.
            ExtraBallCount += 2; //Updates the extra ball count to equal 2.
            System.out.println("\nEnter Your Score For Ball 2:"); //Asks user for the second ball score.
            Score = getScore(); //Gets the score.
            Player.setSecondball(Frame, Score); //Sets the plays frame and score.
            
			if (ExtraBallCount == 1 | ExtraBallCount == 2) //If the extra ball count is 1 or 2.
			{
                Player.setPlayerScore(Score); //Sets the players score to equal score.
                ExtraBallCount -= 1;  //Extra ball count - 1.
            }
           
		   if (ExtraBallCount == 3) { //If the extra ball count is 3.
                Player.setPlayerScore(Score + Score); //Sets the players score to equal score + score.
                ExtraBallCount -= 2;  //Extra ball count - 2.
            }
        }
        // Bowl second ball - system for when Player did not bowl a strike on the first ball
        else {
            System.out.println("Enter Your Score For Ball 2:"); //Asks user for the second ball score.
            Score = getScore(TotalScore); //Gets the score.
            Player.setSecondball(Frame, Score); //Sets the plays frame and score.
            TotalScore = TotalScore + Score; //Updates the total score.
            if (ExtraBallCount == 1 | ExtraBallCount == 2) //If the extra ball count is 1 or 2.
			{
                Player.setPlayerScore(Score + Score); //Sets the players score to equal score + score.
                ExtraBallCount -= 1;  //Extra ball count - 1.
            }
            else 
			{
                Player.setPlayerScore(Score); //Sets the players score to equal score.
            }
        }
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//System for final frame, third ball (if strike on second)
        if (TotalScore == 10) //If total score is equal to 10.
		{
            System.out.println("Strike"); //Tells the player they scored a strike.
            System.out.println("You Have Earned A Extra Ball!\n"); //Tells the player they have earned a extra ball
			System.out.println("Enter Your Score For The Extra Ball:");//Asks for there extra ball score.
            Score = getScore(); //Gets the score.
            Player.setExtraBallCount(Score); //Sets the players Extra ball count score.
            if (Score == 10) //If score = 10
			{
                System.out.println("Strike"); //Tells the player they scored a strike.
            }
            Player.setPlayerScore(Score); //Sets the players score to equal score.
        }
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public int getScore(int TotalScore) throws IOException
	{
        boolean validScore = false;  //Creates valid score boolean
        int tempScore = 0; //Creates Int for temp score and sets it to 0
        while (validScore == false) //While valid score is false.
		{
            String temp = new BufferedReader(new InputStreamReader(System.in)).readLine(); //Creates a a string called temp and sets it to equal.
            while (temp.equals("")) //While temp is equal to "" blank.
			{
                System.out.println("Please Enter A Number."); //Asks user for a number.
                temp = new BufferedReader(new InputStreamReader(System.in)).readLine(); 
            }
            tempScore = Integer.parseInt(temp); 
            if ((tempScore < 0) | (tempScore + TotalScore > 10) ) //If temp score is less than 0 or temp score + total score is greater than 10.
			{
                System.out.println("You Have Entered An Invalid Number. Please Try Again."); //Tells the user they have entered something invalid.
            }
            else 
			{
                validScore = true; //Sets valid score to be true.
            }            
        } 
       return tempScore; //Returns temp score.
    } //Exits
    
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
            if (temp == null) //If temp is equal to NULL.
			{
                System.out.println("Please Enter A Number.");  //Asks user for a number.
            }
            tempScore = Integer.parseInt(temp); //Sets tempscore to equal paseInt of temp.
            if (tempScore < 0 | tempScore > 10) //If temp score is less than 0 or temp score + total score is greater than 10.
			{
                System.out.println("You Have Entered An Invalid Number. Please Try Again."); //Tells the user they have entered something invalid.
            }
            else 
			{
                validScore = true; //Sets valid score to be true.
            }            
        } 
       return tempScore;
    } // end GetScore method for bonus round
}//END