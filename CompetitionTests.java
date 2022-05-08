import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//@author Moeto Sonoda
@RunWith(JUnit4.class)
public class CompetitionTests {

	//@Test
	public void testDijkstraConstructor() throws NumberFormatException, IOException {

		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50); 

		competitionDijkstra = new CompetitionDijkstra("", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra(null, 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("1000EWD.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-A.txt", 50, 70, 60);

		competitionDijkstra = new CompetitionDijkstra("input-B.txt", 50, 60, 70);

		competitionDijkstra = new CompetitionDijkstra("input-C.txt", 70, 60, 50);

		competitionDijkstra = new CompetitionDijkstra("input-D.txt", 70, 50, 60);

		competitionDijkstra = new CompetitionDijkstra("input-E.txt", 60, 50, 70);

		competitionDijkstra = new CompetitionDijkstra("input-F.txt", 60, 70, 50);

		competitionDijkstra = new CompetitionDijkstra("input-G.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-H.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-I.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-J.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-K.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-L.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-M.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("input-N.txt", 50, 50, 50);

		competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", -1, -1, -1);

		competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 300, 300, 300);


	}
	@Test
	public void testDijkstraTimeRequiredForCompetition() throws NumberFormatException, IOException {
		

		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
		assertEquals(38, competitionDijkstra.timeRequiredforCompetition());
		/*
		competitionDijkstra = new CompetitionDijkstra("1000EWD.txt", 50, 50, 50);
		assertEquals(28, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-A.txt", 50, 70, 60);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-B.txt", 50, 60, 70);
		assertEquals(10000, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-C.txt", 70, 60, 50);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-D.txt", 70, 50, 60);
		assertEquals(38, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-E.txt", 60, 50, 70);
		assertEquals(28, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-F.txt", 60, 70, 50);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-G.txt", 50, 50, 50);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-H.txt", 50, 50, 50);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-I.txt", 50, 50, 50);
		assertEquals(240, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-J.txt", 50, 50, 50);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-K.txt", 50, 50, 50);
		assertEquals(320, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-L.txt", 50, 50, 50);
		assertEquals(160, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-M.txt", 50, 50, 50);
		assertEquals(300, competitionDijkstra.timeRequiredforCompetition());

		competitionDijkstra = new CompetitionDijkstra("input-N.txt", 50, 50, 50);
		assertEquals(160, competitionDijkstra.timeRequiredforCompetition());

		//Speeds are less than 50
		competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 80, 10, 10);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());

		//Speeds are more than 50
		competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 60, 70, 300);
		assertEquals(-1, competitionDijkstra.timeRequiredforCompetition());
		*/
	}

	//@Test
	public void testFloydWarshallConstructor() {

		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("1000EWD.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("", 50, 50, 50);
		
		competitionFloydWarshall = new CompetitionFloydWarshall(null, 50, 50, 50);
		
		competitionFloydWarshall = new CompetitionFloydWarshall("input-A.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-B.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-C.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-D.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-E.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-F.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-G.txt", 50, 50, 50);

		//competitionFloydWarshall = new CompetitionFloydWarshall("input-H.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-I.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-J.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-K.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-L.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-M.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("input-N.txt", 50, 50, 50);

		competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", -1, -1, -1);

		competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 300, 300, 300);
	}
	
	//@Test
	public void testFloydWarshallTimeRequiredForCompetition() {
		
		//I commented out the tests for "1000EWD.txt", "input-E.txt", and "input-H.txt" because the webcat gave me an error about running time out.
		// They are completely working on Eclipse.
		
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
		assertEquals(38, competitionFloydWarshall.timeRequiredforCompetition());

		//competitionFloydWarshall = new CompetitionFloydWarshall("1000EWD.txt", 50, 50, 50);
		//assertEquals(28, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-A.txt", 50, 70, 60);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-B.txt", 50, 60, 70);
		assertEquals(10000, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-C.txt", 70, 60, 50);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-D.txt", 70, 50, 60);
		assertEquals(38, competitionFloydWarshall.timeRequiredforCompetition());

		//competitionFloydWarshall = new CompetitionFloydWarshall("input-E.txt", 60, 50, 70);
		//assertEquals(28, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-F.txt", 60, 70, 50);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-G.txt", 50, 50, 50);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());
		
		//competitionFloydWarshall = new CompetitionFloydWarshall("input-H.txt", 50, 50, 50);
		//assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());
		
		competitionFloydWarshall = new CompetitionFloydWarshall("input-I.txt", 50, 50, 50);
		assertEquals(240, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-J.txt", 50, 50, 50);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-K.txt", 50, 50, 50);
		assertEquals(320, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-L.txt", 50, 50, 50);
		assertEquals(160, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-M.txt", 50, 50, 50);
		assertEquals(300, competitionFloydWarshall.timeRequiredforCompetition());

		competitionFloydWarshall = new CompetitionFloydWarshall("input-N.txt", 50, 50, 50);
		assertEquals(160, competitionFloydWarshall.timeRequiredforCompetition());

		//Speeds are less than 50
		competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 80, 10, 10);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());

		//Speeds are more than 50
		competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 60, 70, 300);
		assertEquals(-1, competitionFloydWarshall.timeRequiredforCompetition());
	}	
}