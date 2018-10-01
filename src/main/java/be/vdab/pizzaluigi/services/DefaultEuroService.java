package be.vdab.pizzaluigi.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import be.vdab.pizzaluigi.restclients.KoersClient;

@Service
class DefaultEuroService implements EuroService2 {

	private final KoersClient koersClient;

	DefaultEuroService(KoersClient koersClient) {
		this.koersClient = koersClient;
	}

	@Override
	public BigDecimal naarDollar(BigDecimal euro) {
		return euro.multiply(koersClient.getDollarKoers()).setScale(2, RoundingMode.HALF_UP);
	}

	/*
	 * private final KoersClient[] koersClients; private static final Logger LOGGER
	 * = LoggerFactory.getLogger(DefaultEuroService.class);
	 * 
	 * DefaultEuroService(KoersClient[] koersClients) { this.koersClients =
	 * koersClients; }
	 * 
	 * @Override public BigDecimal naarDollar(BigDecimal euro) { for (KoersClient
	 * koersClient : koersClients) { try { return
	 * euro.multiply(koersClient.getDollarKoers()).setScale(2,
	 * RoundingMode.HALF_UP); } catch (KoersClientException ex) {
	 * LOGGER.error("kan dollar koers niet lezen", ex); } }
	 * LOGGER.error("kan dollar koers van geen enkele bron lezen"); return null; }
	 */
}
