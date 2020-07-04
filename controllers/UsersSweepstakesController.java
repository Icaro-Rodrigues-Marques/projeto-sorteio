package br.com.imepac.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imepac.site.entities.Sweepstakes;
import br.com.imepac.site.entities.Users;
import br.com.imepac.site.interfaces.impl.SweepstakesServiceImpl;
import br.com.imepac.site.interfaces.impl.UsersService;

@RestController
@RequestMapping(value = "/sweepstakes/{sweepstakesId}/user")
public class UsersSweepstakesController {

	@Autowired
	private SweepstakesServiceImpl sweepstakesService;
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping(value = "/{userId}")
	public Sweepstakes insertSweepstakes(@PathVariable Long sweepstakesId, @PathVariable Long userId) {
		Sweepstakes sweepstakes = sweepstakesService.read(sweepstakesId);
		Users users = usersService.read(userId);
		sweepstakes.getUsers().add(users);
		sweepstakesService.save(sweepstakes);
		return sweepstakes;
	}

	@GetMapping(value = "/{userId}")
	public List<Users> findAll(@PathVariable Long sweepstakesId, @PathVariable Long userId) {
		Sweepstakes sweepstakes = sweepstakesService.read(sweepstakesId);
		return sweepstakes.getUsers();
	}
	
}
