package fr.test.java.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.main.java.observer.Bookmaker;
import fr.main.java.observer.IObserver;

public class TestBookmaker extends TestObserver {

	@Test
	public void testSetObserver() {
		Bookmaker bookmaker = new Bookmaker();
		List<IObserver> list = new ArrayList<>();
		list.add(bookmaker);
		this.competition.setObservers(list);
		assertEquals(list,this.competition.getObservers());
	}

}
