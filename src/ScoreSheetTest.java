import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreSheetTest {
	
	@Test 
	public void testOneThrow()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(7);
		assertEquals(7,s.getTheCurrentScore());
	}
	
	@Test
	public void testTwoThrows()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(7);
		s.makeAThrow(2);
		assertEquals(9,s.getTheCurrentScore());
	}
	
	@Test
	public void testThreeThrows()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(7);
		s.makeAThrow(2);
		s.makeAThrow(5);
		assertEquals(14,s.getTheCurrentScore());
	}
	
	@Test
	public void testSpareCountsNextFrame()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(7);
		s.makeAThrow(3);
		s.makeAThrow(5);
		s.makeAThrow(1);
		assertEquals(21,s.getTheCurrentScore());
	}
	
	@Test
	public void testStrikeMovesToNextFrame()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(10);
		assertEquals(0,s.getTheCurrentScore());
		s.makeAThrow(5);
		assertEquals(20,s.getTheCurrentScore());		
	}
	
	@Test
	public void testStrikeCountsNextFrameScores()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(10);
		s.makeAThrow(5);
		s.makeAThrow(3);
		assertEquals(23,s.getTheCurrentScore());
	}
	
	@Test
	public void testSpareOnLastFrame()
	{
		ScoreSheet s = new ScoreSheet();
	
		for(int i = 0; i < 9; i++)
		{
			s.makeAThrow(7);
			s.makeAThrow(2);
		}
		
		s.makeAThrow(6);
		s.makeAThrow(4);
		s.makeAThrow(4);
		assertEquals(95, s.getTheCurrentScore());
		
	}
	
	
}
