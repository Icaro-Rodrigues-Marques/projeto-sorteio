package br.com.imepac.site.entities;

import java.util.ArrayList;
import java.util.List;

public class SweepstakesView {

	private SweepstakesNotUser sweepstakes;
	private List<Users> user = new ArrayList<>();

	public SweepstakesView(SweepstakesNotUser sweepstakes, List<Users> user) {
		super();
		this.sweepstakes = sweepstakes;
		this.user = user;
	}

	public SweepstakesNotUser getSweepstakes() {
		return sweepstakes;
	}

	public void setSweepstakes(SweepstakesNotUser sweepstakes) {
		this.sweepstakes = sweepstakes;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

}
