import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player
{
    private String PlayerName; 	//String to store players name.
    private List<Integer> FirstBall = new ArrayList<Integer>();	 //Keeps track of the first ball, as an int.
    private List<Integer> SecondBall = new ArrayList<Integer>(); //Keeps track of the second ball as an int.
    private int ExtraBalls;	//Int for extra ball if needed.
    private int PlayerScore;
    private int ExtraBallCount;

   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   // Retrieves the players name from the one in-putted on the interface.
    public String getName()
	{
        return PlayerName;
    }
	
	// Uses the name received and assigns/stores it.
    public Player(String Name)
	{
        PlayerName = Name;
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieves the first ball number input from the interface.
    public int checkFirstBall(int Frame) 
	{
        return FirstBall.get(Frame);
    }
   
	// Uses the number and assigns/stores it in the relevant frame.
    public void setFirstBall(int Frame, int Score) throws IOException
	{
        FirstBall.add(Score);
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
   // Retrieves the second ball number input from the interface.
    public int checkSecondBall(int Frame) 
	{
        return SecondBall.get(Frame);
    }
    
    //  Uses the number and assigns/stores it in the relevant frame.
    public void setSecondball(int Frame, int Score) throws IOException
	{
        SecondBall.add(Score);
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieves the extra ball number input from the interface id needed.
    public int checkExtraBalls() 
	{
        return ExtraBalls;
    }
	
	//  Uses the number and assigns/stores it in the relevant frame.
    public void setExtraBalls(int Score) 
	{
        ExtraBalls = Score;
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // Retrieves the players current total score.
    public int checkPlayerScore() 
	{
        return PlayerScore;
    }
	
	// Updates the players total score.
    public void setPlayerScore(int Score) 
	{
        PlayerScore = PlayerScore + Score;
    }
    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    // Retrieves the Extra Ball Count.
    public int checkExtraBallCount() 
	{
        return ExtraBallCount;
    }

	// Updates the players Extra Ball Count.
    public void setExtraBallCount(int ExtraBallCount) 
	{
        ExtraBallCount = ExtraBallCount;
    }
}