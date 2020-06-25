package br.com.imepac.site.interfaces.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.imepac.site.entities.Users;

@Service
public interface UsersService  {

	public void save(Users usuario);

	public List<Users> reads();

	public Users read(long id);
	
	public void delete(long id);

	public void update(Users usuario);
}
