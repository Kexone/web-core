package examples;

import com.web.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ExampleTests {

    @Autowired
    private ExampleService exampleService;

   // public ExampleService exampleService() {
    //    return null;
   // }
}
