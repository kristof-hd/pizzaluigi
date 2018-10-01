package be.vdab.pizzaluigi.web;

import java.util.List;

interface Mandje {
	void addPizzaId(long pizzaId);
	public List<Long> getPizzaIds();
}