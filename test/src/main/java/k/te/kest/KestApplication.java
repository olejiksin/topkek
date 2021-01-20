package k.te.kest;

import k.te.kest.model.Resume;
import k.te.kest.services.ResumeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class KestApplication {
    public static void main(String[] args) {
        SpringApplication.run(KestApplication.class, args);
    }
    
}
