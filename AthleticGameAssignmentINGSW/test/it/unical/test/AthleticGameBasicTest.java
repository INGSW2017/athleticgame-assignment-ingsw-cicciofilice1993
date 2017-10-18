package it.unical.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.AthleticGame;


public class AthleticGameBasicTest {
	
	
   /* aggiungere un test per testare il metodo addArrival(String participant, Instant arrival). 
	* In questo test verificare che, aggiungendo un nuovo arrivo, la taglia della mappa arrivals 
	* diventi pari ad 1 */
	@Test
	public void addArrivalTest(){
		AthleticGame athleticGame = new AthleticGame("CALCIO");
		athleticGame.addArrival("Francesco" , Instant.now().plusMillis(1000));
		Assert.assertEquals(1, athleticGame.getArrivals().size());
	}
	
    /* aggiungere un test per verificare che getParecipiantTime(String participant) lanci un'eccezione 
     * in caso di partecipante non valido
     */
	@Test(expected = IllegalArgumentException.class)
	public void getParecipiantTimeTest(){
		AthleticGame athleticGame = new AthleticGame("CORSA");
		athleticGame.addArrival("Francesco" , Instant.now().plusMillis(1000));
		athleticGame.getParecipiantTime("Francesco");
	}
}
