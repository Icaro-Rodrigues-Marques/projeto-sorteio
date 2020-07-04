package br.com.imepac.site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imepac.site.entities.Sweepstakes;
import br.com.imepac.site.entities.SweepstakesNotUser;
import br.com.imepac.site.entities.SweepstakesView;
import br.com.imepac.site.entities.Users;
import br.com.imepac.site.interfaces.impl.SweepstakesServiceImpl;

@RestController
@RequestMapping(value = "/sweepstakes")
public class SweepstakesController {

	@Autowired
	private SweepstakesServiceImpl sweepstakesImpl;

	@GetMapping
	public List<Sweepstakes> homePageCadastrar() {
		return sweepstakesImpl.reads();
	}

	@GetMapping(value = "/{id}")
	public SweepstakesView findById(@PathVariable Long id) {
		Sweepstakes sweepstakes = sweepstakesImpl.read(id);
		List<Users> users = sweepstakes.getUsers();
		SweepstakesNotUser sweepstakesNotUser = toModel(sweepstakes);
		SweepstakesView view = new SweepstakesView(sweepstakesNotUser, users);
		return view;
		
	}
	
	private SweepstakesNotUser toModel(Sweepstakes sweepstakes) {
		SweepstakesNotUser sweepstakesNotUser = new SweepstakesNotUser();
		sweepstakesNotUser.setId(sweepstakes.getId());
		sweepstakesNotUser.setCreator(sweepstakes.getCreator());
		sweepstakesNotUser.setAward(sweepstakes.getAward());
		sweepstakesNotUser.setDate(sweepstakes.getDate());
		sweepstakesNotUser.setDescription(sweepstakes.getDescription());
		sweepstakesNotUser.setTitle(sweepstakes.getTitle());
		sweepstakesNotUser.setType(sweepstakes.getType());
		sweepstakesNotUser.setWinner(sweepstakes.getWinner());
		return sweepstakesNotUser;
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Sweepstakes sweepstakes) {
			sweepstakesImpl.save(sweepstakes);
		  return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@Valid @RequestBody  Sweepstakes sweepstakes  ) {
		Sweepstakes sweepstakesUpdate = sweepstakesImpl.read(id);
		BeanUtils.copyProperties(sweepstakes, sweepstakesUpdate, "id", "users");
		sweepstakesImpl.save(sweepstakesUpdate);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		sweepstakesImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
