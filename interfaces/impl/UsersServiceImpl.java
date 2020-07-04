package br.com.imepac.site.interfaces.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imepac.site.entities.Users;
import br.com.imepac.site.entities.repositories.UsersRepository;

@Component
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usuarioRepository;


	public void save(Users usuario) {
		usuarioRepository.save(usuario);
	}

	
	public List<Users> reads() {
		return usuarioRepository.findAll();
	}

	public Users read(long id) {
		return usuarioRepository.findById(id).get();
	}

	public void delete(long id) {
		usuarioRepository.deleteById(id);
	}

	public void update(Users usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Users login(String email) {
		return usuarioRepository.findByEmail(email).get();
	}	
	

}
