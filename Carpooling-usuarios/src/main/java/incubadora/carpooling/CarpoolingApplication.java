package incubadora.carpooling;

import incubadora.carpooling.Entities.UserEntity;
import incubadora.carpooling.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CarpoolingApplication {
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(CarpoolingApplication.class, args);
    }

    @PostConstruct
    public void init() {
        List<UserEntity> users = new ArrayList<>();

        UserEntity user = new UserEntity("Sergio", "semartinl@alumnos.unex.es","12345","UNEX");
        users.add(user);
        userRepository.saveAll(users);




    }
}
