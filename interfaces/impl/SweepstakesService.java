package br.com.imepac.site.interfaces.impl;

import java.util.List;

import javax.validation.Valid;

import br.com.imepac.site.entities.Sweepstakes;

public interface SweepstakesService {

	public static void save(@Valid Sweepstakes sweepstakes) {
		// TODO Auto-generated method stub
		
	}

	public static List<Sweepstakes> reads() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Sweepstakes read(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Sweepstakes sweepstakes);
}
