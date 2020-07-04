package br.com.imepac.site.interfaces.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imepac.site.entities.Sweepstakes;
import br.com.imepac.site.entities.repositories.SweepstakesRepository;

@Component
public class SweepstakesServiceImpl implements SweepstakesService {
	
	@Autowired
	private SweepstakesRepository sweepstakesRepository;


	public void save(Sweepstakes sweepstakes) {
		sweepstakesRepository.save(sweepstakes);
	}

	
	public List<Sweepstakes> reads() {
		return sweepstakesRepository.findAll();
	}

	public Sweepstakes read(long id) {
		return sweepstakesRepository.findById(id).get();
	}

	public void delete(long id) {
		sweepstakesRepository.deleteById(id);
	}

	public void update(Sweepstakes sweepstakes) {
		sweepstakesRepository.save(sweepstakes);
	}


	
	

}
