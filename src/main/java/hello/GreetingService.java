package hello;

import org.springframework.stereotype.Service;
/**
 * Created by vincentvu on 2/9/2017.
 */
@Service
public class GreetingService {

    public String greet() {
        return "Hello World";
    }
}
