package c.t.ttes;

import c.t.ttes.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtesApplication.class, args);
    }

}
