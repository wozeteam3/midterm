package com.t3.midterm;

public class Benefits {
	int benefit_id;
	int dental;
	int life;
	int health;
	int k_match_amount;
	
	public Benefits() {}
	
	public Benefits(int id, int dental, int life, int health, int k_match_amount) {
		this.benefit_id = id;
		this.dental=dental;
		this.life=life;
		this.health=health;
		this.k_match_amount=k_match_amount;
	}

	public int getBenefit_id() {
		return benefit_id;
	}

	public void setBenefit_id(int benefit_id) {
		this.benefit_id = benefit_id;
	}

	public int getDental() {
		return dental;
	}

	public void setDental(int dental) {
		this.dental = dental;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getK_match_amount() {
		return k_match_amount;
	}

	public void setK_match_amount(int k_match_amount) {
		this.k_match_amount = k_match_amount;
	}

}
