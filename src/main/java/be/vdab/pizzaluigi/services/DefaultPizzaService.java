package be.vdab.pizzaluigi.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.vdab.pizzaluigi.entities.Pizza;
import be.vdab.pizzaluigi.repositories.PizzaRepository;

@Service
class DefaultPizzaService implements PizzaService {
	private final PizzaRepository pizzaRepository;

	DefaultPizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	@Override
	public void create(Pizza pizza) {
		pizzaRepository.create(pizza);
	}

	@Override
	public Optional<Pizza> read(long id) {
		return pizzaRepository.read(id);
	}

	@Override
	public void update(Pizza pizza) {
		pizzaRepository.update(pizza);
	}

	@Override
	public void delete(long id) {
		pizzaRepository.delete(id);
	}

	@Override
	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}

	@Override
	public List<Pizza> findByPrijsBetween(BigDecimal van, BigDecimal tot) {
		return pizzaRepository.findByPrijsBetween(van, tot);
	}

	@Override
	public long findAantalPizzas() {
		return pizzaRepository.findAantalPizzas();
	}

	@Override
	public List<BigDecimal> findUniekePrijzen() {
		return pizzaRepository.findUniekePrijzen();
	}

	@Override
	public List<Pizza> findByPrijs(BigDecimal prijs) {
		return pizzaRepository.findByPrijs(prijs);
	}
}