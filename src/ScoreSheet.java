
public class ScoreSheet {
	
	final int MAXTHROWS = 21;
	int[] ballRolled = new int[MAXTHROWS];
	int ballThrowTurn = 1;

	
	public ScoreSheet()
	{
		for(int i = 0; i < MAXTHROWS; i++)
		{
			ballRolled[i] = -1;
		}
	}
	
	public void makeAThrow(int pinAmount)
	{
		ballRolled[ballThrowTurn-1] = pinAmount;
		
		//Made a Strike
		if(pinAmount == 10 && ballThrowTurn % 2 == 1 && ballThrowTurn < 19)
		{
			ballRolled[ballThrowTurn] = 0;
			//End this Frame
			ballThrowTurn += 1;
			
		}
		
		ballThrowTurn += 1;
	}
	
	public int getStrikeScore(int certainRoll)
	{
		int tempRoll = 0;
		
		if(certainRoll == 18)
		{
			return ballRolled[19] + ballRolled[20];
		}

		int nextRoll = ballRolled[certainRoll+2];
		int secRoll = ballRolled[certainRoll+3]; 
		int thirdRoll = ballRolled[certainRoll+4]; 

		if ((nextRoll == 10 && thirdRoll == -1) || (nextRoll < 10 && secRoll == -1))
		{
			return 10 + nextRoll;
		}
		
		tempRoll += nextRoll;
		
		if (nextRoll == 10)
		{
		tempRoll += thirdRoll;
		}
		else
		{
		tempRoll += secRoll;
		} 
		
		return tempRoll + 10;
		
	}
	
	public int getSpareScore(int roll)
	{
		int nextRoll = ballRolled[roll+2];
		
		if(nextRoll == -1)
		{
			return 0;
		}
		
		return nextRoll + 10;
	}
	
	public int getTheCurrentScore()
	{
		int score = 0;
		int tempScore = 0;
		
		for(int i = 0; i < 20; i+=2)
		{
			int nextRoll = ballRolled[i];
			int secRoll = ballRolled[i+1]; 
			int thirdRoll = ballRolled[i+2]; 
			
			if(nextRoll + secRoll == 10)
			{
				tempScore = getSpareScore(i);
			}
			else if (nextRoll == 10)
			{
				tempScore = getStrikeScore(i);
			}
			else
			{
				if(nextRoll != -1)
				{
					tempScore += nextRoll;
				}
				
				if(secRoll != -1)
				{
					tempScore += secRoll;
				}
				
			}
			
			score += tempScore;
			tempScore = 0;
		}
		
		return score;
	}
	
}
