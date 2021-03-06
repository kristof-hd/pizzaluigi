package be.vdab.pizzaluigi.web;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.entities.Pizza;
import be.vdab.pizzaluigi.services.EuroService2;
import be.vdab.pizzaluigi.services.PizzaService;

@Controller
@RequestMapping("pizzas15")
class PizzaController15 {
	private static final String PIZZAS_VIEW = "pizzas15";
	private static final String PRIJZEN_VIEW = "prijzen";
	private static final String PIZZA_VIEW = "pizza15";
	private static final String VAN_TOT_PRIJS_VIEW = "vantotprijs";
	private static final String TOEVOEGEN_VIEW = "toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/pizzas15";
	private final EuroService2 euroService;
	private final PizzaService pizzaService;

	PizzaController15(EuroService2 euroService, PizzaService pizzaService) {
		this.euroService = euroService;
		this.pizzaService = pizzaService;
	}

	@GetMapping
	ModelAndView pizzas() {
		return new ModelAndView(PIZZAS_VIEW, "pizzas", pizzaService.findAll());
	}

	@GetMapping("{id}")
	ModelAndView pizza(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(PIZZA_VIEW);
		pizzaService.read(id).ifPresent(pizza -> {
			modelAndView.addObject(pizza);
			modelAndView.addObject("inDollar", euroService.naarDollar(pizza.getPrijs()));
		});
		return modelAndView;
	}

	@GetMapping("prijzen")
	ModelAndView prijzen() {
		return new ModelAndView(PRIJZEN_VIEW, "prijzen", pizzaService.findUniekePrijzen());
	}

	@GetMapping(params = "prijs")
	ModelAndView pizzasVanPrijs(BigDecimal prijs) {
		return new ModelAndView(PRIJZEN_VIEW, "pizzas", pizzaService.findByPrijs(prijs)).addObject("prijs", prijs)
				.addObject("prijzen", pizzaService.findUniekePrijzen());
	}

	@GetMapping("vantotprijs")
	ModelAndView findVanTotPrijs() {
		VanTotPrijsForm form = new VanTotPrijsForm();
		form.setVan(BigDecimal.ZERO);
		form.setTot(BigDecimal.ZERO);
		return new ModelAndView(VAN_TOT_PRIJS_VIEW).addObject(form);

	}

	@GetMapping(params= {"van", "tot"})
	ModelAndView findVanTotPrijs(@Valid VanTotPrijsForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(VAN_TOT_PRIJS_VIEW); 
		if (bindingResult.hasErrors()) {
			return modelAndView; 
		}
		List<Pizza> pizzas = pizzaService.findByPrijsBetween(form.getVan(), form.getTot());
		if (pizzas.isEmpty()) {
			bindingResult.reject("geenPizzas");
		} else {
			modelAndView.addObject("pizzas", pizzas); 
		}
		return modelAndView; 
	}		

	@GetMapping("toevoegen")
	ModelAndView toevoegen() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Pizza());
	}

	@PostMapping("toevoegen")
	ModelAndView toevoegen(@Valid Pizza pizza, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(TOEVOEGEN_VIEW);
		}
		pizzaService.create(pizza);
		//return new ModelAndView(PIZZAS_VIEW, "pizzas", pizzaService.findAll());
		return new ModelAndView(REDIRECT_URL_NA_TOEVOEGEN);
	}
}