package incubadora.carpoolingtrayectos;

import incubadora.carpoolingtrayectos.Entities.TrayectoEntity;
import incubadora.carpoolingtrayectos.Mapper.TrayectoMapper;
import incubadora.carpoolingtrayectos.Repositories.TrayectoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableDiscoveryClient
public class CarpoolingTrayectosApplication {
	@Autowired
	TrayectoRepository trayectoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CarpoolingTrayectosApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<TrayectoEntity> users = new ArrayList<>();
//		LocalDateTime LocalDateTime.now() = LocalDateTime.parse("2024-12-30 12:20");
//		LocalDateTime LocalDateTime = TrayectoMapper.formattTime("2024-12-30 12:20", "yyyy-MM-dd hh:mm");
		TrayectoEntity trayectoEntity = new TrayectoEntity("Plasencia","Caceres", LocalDateTime.now(), LocalDateTime.now());
		users.add(trayectoEntity);
		trayectoRepository.saveAll(users);


	}
}
