package it.unical.test;
import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;


public class AthleticGameWinnersTest {
	/* utilizzare @BeforeClass per istanziare un campo privato statico 
	 * di tipo AthleticGame su cui effettuare i test
	 */
	private static AthleticGame athleticGame;
	@BeforeClass
	public static void init(){
		athleticGame = new AthleticGame("Corsa");
	}
	//utilizzare @After per richiamare il metodo reset()
	@After
	public void resetTest(){
		athleticGame.reset();
	}
	
	// utilizzare @Before per richiamare il metodo start()
	@Before
	public void startTest(){
		athleticGame.start();
	}
	
	/* aggiungere due metodi di test per la funzione getWinner 
	 * (scegliere i test in modo significativo, ma a piacere)
	 */
	
	// TEST verificare il giusto vincitore
	@Test
	public void getWinnerTest1(){
		athleticGame.addArrival("Francesco" , Instant.now().plusMillis(1000));
		athleticGame.addArrival("Giovanni" , Instant.now().plusMillis(2000));
		athleticGame.addArrival("Paolo" , Instant.now().plusMillis(3000));
		Assert.assertEquals("Francesco", athleticGame.getWinner());
	}
	
	// TEST verificare se l'atleta che ha fatto il tempo migliore ha vinto la gara
	@Test
	public void getWinnerTest2(){
		athleticGame.addArrival("Francesco" , Instant.now().plusMillis(1000));
		athleticGame.addArrival("Giovanni" , Instant.now().plusMillis(2000));
		athleticGame.addArrival("Paolo" , Instant.now().plusMillis(3000));
		Assert.assertEquals(1000, athleticGame.getParecipiantTime("Francesco"));
		Assert.assertEquals("Francesco", athleticGame.getWinner());
	}
	

}
