package jessie.solution.centurylink.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }
}
