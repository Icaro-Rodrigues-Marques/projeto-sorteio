package br.com.imepac.site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imepac.site.entities.Sweepstakes;
import br.com.imepac.site.interfaces.impl.SweepstakesServiceImpl;

@RestController
@RequestMapping(value = "/sweepstakers")
public class SweepstakesController {

	@Autowired
	private SweepstakesServiceImpl sweepstakesImpl;

	@GetMapping
	public List<Sweepstakes> homePageCadastrar() {
		return sweepstakesImpl.reads();
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Sweepstakes sweepstakes) {
			sweepstakesImpl.save(sweepstakes);
		  return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@Valid @RequestBody  Sweepstakes sweepstakes  ) {
		Sweepstakes sweepstakesUpdate = sweepstakesImpl.read(id);
		BeanUtils.copyProperties(sweepstakes, sweepstakesUpdate, "id");
		sweepstakesImpl.save(sweepstakesUpdate);
		return ResponseEntity.noContent().build();
	}
}
