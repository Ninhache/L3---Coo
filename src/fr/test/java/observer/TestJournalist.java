package fr.test.java.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.main.java.observer.IObserver;
import fr.main.java.observer.Journalist;

public class TestJournalist extends TestObserver {

	@Test
	public void testSetObserver() {
		Journalist journalist = new Journalist();
		List<IObserver> list = new ArrayList<>();
		list.add(journalist);
		this.competition.setObservers(list);
		assertEquals(list,this.competition.getObservers());
	}

}
