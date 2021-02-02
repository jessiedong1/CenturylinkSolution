package jessie.solution.centurylink;

import jessie.solution.centurylink.model.FollowersResponse;
import jessie.solution.centurylink.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class CenturylinkApplication //implements CommandLineRunner
{
    @Autowired
    FollowerService fService;
    public static void main(String[] args) {
        SpringApplication.run(CenturylinkApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        fService.getAllFollowersList("octocat").forEach(System.out::println);
//
//    }
}
