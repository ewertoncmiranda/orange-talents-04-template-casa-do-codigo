package miranda.ewerton.zup.casadocodigo.config.health;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MeuHealthChecker implements HealthIndicator {

	@Override
	public Health health() {
		Map<String, Object> detailhes = new HashMap<>();
		detailhes.put("versao", "1.2.3");
		detailhes.put("descricao", "Custom HealthChecker - Casa do Codigo ");
		detailhes.put("endereço", "127.0.0.1");
		


		return Health.status(Status.UNKNOWN).withDetails(detailhes).build();
	}

}
