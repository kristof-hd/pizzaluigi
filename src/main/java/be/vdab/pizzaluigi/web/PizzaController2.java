package be.vdab.pizzaluigi.web;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.entities.Pizza;

@Controller
@RequestMapping("pizzas2")
	
class PizzaController2 {
		
		private static final String PIZZAS_VIEW="pizzas2";

		private final List<Pizza> pizzas=Arrays.asList(
				new Pizza(1, "Prosciutto", BigDecimal.valueOf(4), true),
				new Pizza(2, "Margherita", BigDecimal.valueOf(5), false),
				new Pizza(3, "Calzone", BigDecimal.valueOf(4), false));
		
		@GetMapping
		ModelAndView pizzas() {
			return new ModelAndView(PIZZAS_VIEW, "pizzas", pizzas);
		}
		
}
	
