package be.vdab.pizzaluigi.web;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.entities.Pizza;

@Controller
@RequestMapping("pizzas6")

class PizzaController6 {
		
		private static final String PIZZAS_VIEW="pizzas6";
	
		private final Map<Long, Pizza> pizzas=new LinkedHashMap<>(); 
		
		PizzaController6() {
				pizzas.put(1L, new Pizza(1, "Prosciutto", BigDecimal.valueOf(4), true));
				pizzas.put(2L, new Pizza(2, "Margherita", BigDecimal.valueOf(5), false));
				pizzas.put(3L, new Pizza(3, "Calzone", BigDecimal.valueOf(4), false));
				pizzas.put(4L, new Pizza(4, "Fungi & Olive", BigDecimal.valueOf(5), false));
				pizzas.put(23L, new Pizza(23, "Fungi & Olive", BigDecimal.valueOf(5), false)); 
		}
		
		@GetMapping
		ModelAndView pizzas() {
			return new ModelAndView(PIZZAS_VIEW, "pizzas", pizzas);
		}
		
}
	
