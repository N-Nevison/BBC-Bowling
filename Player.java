import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player
{
    private String PlayerName; 	//String to store players name.
    private List<Integer> FirstBall = new ArrayList<Integer>();	 //Keeps track of the first ball, as an int.
    private List<Integer> SecondBall = new ArrayList<Integer>(); //Keeps track of the second ball as an int.
    private int ExtraBalls;	//Int for extra ball if needed.
    private int PlayerScore; //Int for player score.
    private int ExtraBallCount; //Int for extra ball count.

   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public String getName() //Retrieves the players name from the one in-putted on the interface.
	{
        return PlayerName; //Returns the players name.
    }
	
    public Player(String Name) //Uses the name received and assigns/stores it.
	{
        PlayerName = Name; //Sets player name to equal name.
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public int checkFirstBall(int Frame) //Retrieves the first ball number input from the interface.
	{
        return FirstBall.get(Frame); //Returns the first ball for the current frame.
    }
   
    public void setFirstBall(int Frame, int Score) throws IOException // Uses the number and assigns/stores it in the relevant frame.
	{
        FirstBall.add(Score); //Adds the score for the first ball.
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public int checkSecondBall(int Frame) //Retrieves the second ball number input from the interface.
	{
        return SecondBall.get(Frame); //Returns the second ball for the current frame.
    }
    
    public void setSecondball(int Frame, int Score) throws IOException // Uses the number and assigns/stores it in the relevant frame.
	{
        SecondBall.add(Score); //Adds the score for the second ball.
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public int checkExtraBalls() //Retrieves the extra ball number input from the interface id needed.
	{
        return ExtraBalls; //Returns extra ball.
    }
	
    public void setExtraBalls(int Score) //Uses the number and assigns/stores it in the relevant frame.
	{
        ExtraBalls = Score; //Extra balls equal score.
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public int checkPlayerScore() //Retrieves the players current total score.
	{
        return PlayerScore; //Returns players score.
    }
	
    public void setPlayerScore(int Score) //Updates the players total score.
	{
        PlayerScore = PlayerScore + Score; //Players score equals there current score plus there fram score.
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    public int checkExtraBallCount()  //Retrieves the Extra Ball Count.
	{
        return ExtraBallCount; //Returns extra ball count.
    }

    public void setExtraBallCount(int ExtraBallCount) //Updates the players Extra Ball Count.
	{
        ExtraBallCount = ExtraBallCount; //Extra ball count equals extra ball count.
    }
}