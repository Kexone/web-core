package examples;

import com.web.example.ProductService;
import org.spockframework.runtime.SpockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ExampleTests extends SpockException {


   // public ProductService exampleService() {
    //    return null;
   // }
}
