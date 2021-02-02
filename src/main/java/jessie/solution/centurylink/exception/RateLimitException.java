package jessie.solution.centurylink.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class RateLimitException extends Exception{
    public RateLimitException(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }
}
