package jessie.solution.centurylink.service;

import jessie.solution.centurylink.exception.RateLimitException;
import jessie.solution.centurylink.exception.UsernameNotFoundException;
import jessie.solution.centurylink.model.FollowersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerService {
    @Autowired
    RestTemplate restTemplate;

    public List<String> getFollowersList(String username) throws UsernameNotFoundException, RateLimitException {
        //octocat
        String fooResourceUrl
                = "https://api.github.com/users/"+username+"/followers";
        ResponseEntity<FollowersResponse[]> response = null;
        try{
            response = restTemplate.getForEntity(fooResourceUrl, FollowersResponse[].class);
        }catch (HttpClientErrorException e){
            throw new RateLimitException("Sorry, you can only send 60 requests per hour");
        }

        List<String> result = new ArrayList<>();
        int length;
        if(response.getStatusCode().equals(HttpStatus.OK)){
            length = response.getBody().length>=5?5:response.getBody().length;
            for(int i=0;i<length;i++)
                result.add(response.getBody()[i].login);
            return result;
        }
        else
            throw new UsernameNotFoundException("Sorry, no such username");
    }

    public List<String> getAllFollowersList(String username) throws UsernameNotFoundException, RateLimitException {
        List<String> result = getFollowersList(username);
        List<String> resultLevel2 =new ArrayList<>();
        List<String> resultLevel3 =new ArrayList<>();
        for(String name: result){
            resultLevel2.addAll(getFollowersList(name));
        }
        for(String name: resultLevel2){
            resultLevel3.addAll(getFollowersList(name));
        }
        result.addAll(resultLevel2);
        result.addAll(resultLevel3);
        return result;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
