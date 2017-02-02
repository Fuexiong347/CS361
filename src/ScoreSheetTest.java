public class ScoreSheetTest {
	
	public void testOneThrow()
	{
		ScoreSheet s = new ScoreSheet();
		s.makeAThrow(6);
		assertEquals(6,s.getTheCurrentScore());
	}
	
	public void testTwoThrows()
	{
		
	}
	
	public void testThreeThrows()
	{
		
	}

}
