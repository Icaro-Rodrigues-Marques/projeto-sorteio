package br.com.imepac.site.interfaces.impl;

import java.util.List;

public interface Users_SweepstakesService {

	public void save(Users_SweepstakesService usuario);

	public List<Users_SweepstakesService> reads();

	public static Users_SweepstakesService read(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(long id);

	public void update(Users_SweepstakesService usuario);
	
	public Users_SweepstakesService login(String email);

	public static void save() {
		// TODO Auto-generated method stub
		
	}
}
