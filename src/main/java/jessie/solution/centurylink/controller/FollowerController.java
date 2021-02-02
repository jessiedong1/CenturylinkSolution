package jessie.solution.centurylink.controller;


import jessie.solution.centurylink.exception.RateLimitException;
import jessie.solution.centurylink.exception.UsernameNotFoundException;
import jessie.solution.centurylink.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FollowerController {
    @Autowired
    FollowerService fService;
    @GetMapping(value="/{username}")
    public ResponseEntity<List<String>>getFollowers(@PathVariable String username){
        List<String> followers;
        try {
            followers = fService.getAllFollowersList(username);
            return new ResponseEntity<>(followers, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (RateLimitException e)
        {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

    }
}
