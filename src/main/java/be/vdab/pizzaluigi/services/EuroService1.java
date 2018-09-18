package be.vdab.pizzaluigi.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import be.vdab.pizzaluigi.restclients.KoersClient;

@Service
class EuroService1 {
		private final KoersClient koersClient;

		EuroService1(KoersClient koersClient) {
			this.koersClient = koersClient;
		}

		BigDecimal naarDollar(BigDecimal euro) {
			return euro.multiply(koersClient.getDollarKoers()).setScale(2, RoundingMode.HALF_UP);
		}
}
