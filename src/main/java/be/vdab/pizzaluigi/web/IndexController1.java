package be.vdab.pizzaluigi.web;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.valueobjects.Adres;
import be.vdab.pizzaluigi.valueobjects.Persoon;

@Controller
@RequestMapping("/")

class IndexController1 {

	/*@GetMapping
	ModelAndView index() {
		String boodschap;
		int uur = LocalTime.now().getHour();
		if (uur < 12) {
			boodschap = "Goede morgen";
		} else if (uur < 18) {
			boodschap = "Goede middag";
		} else {
			boodschap = "Goede avond";
		}
		return new ModelAndView("index1", "boodschap", boodschap)
						.addObject("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true, new Adres("Grote Markt", "3", 9700, "Oudenaarde"))); 
	}*/

	@GetMapping
	ModelAndView index(@CookieValue(name = "laatstBezocht", required = false) String laatstBezocht, HttpServletResponse response) {
		String boodschap;
		int uur = LocalTime.now().getHour();
		if (uur < 12) {
			boodschap = "Goede morgen";
		} else if (uur < 18) {
			boodschap = "Goede middag";
		} else {
			boodschap = "Goede avond";
		}

		Cookie cookie = new Cookie("laatstBezocht", LocalDateTime.now().toString());
		cookie.setMaxAge(31_536_000);
		response.addCookie(cookie);
		ModelAndView modelAndView = new ModelAndView("index1", "boodschap", boodschap)
				.addObject("zaakvoerder", new Persoon("Luigi", "Peperone", 7, true, new Adres("Grote Markt", "3", 9700, "Oudenaarde")));
		if (laatstBezocht != null) {
			modelAndView.addObject("laatstBezocht", laatstBezocht);
		}
		return modelAndView;
	}
	
}
