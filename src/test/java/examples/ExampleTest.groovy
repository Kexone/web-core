package examples

import com.web.example.Product
import com.web.example.ProductService
import jdk.internal.loader.AbstractClassLoaderValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Timeout
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

//import spock.lang.*;

@SpringBootTest(classes=com.web.Application)
@AutoConfigureMockMvc
class ExampleTest extends Specification{

    @Autowired
    ProductService productService

    Publisher publisher = new Publisher()
    Subscriber subscriber = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2
    }


    def "product-test"() {
        given: "a new product service is created"
        def product = productService.getProduct(1)

        expect: "Get the right product"
        product.getName() == "Honey"
    }
    @Timeout(value = 120, unit = TimeUnit.MILLISECONDS)
    def "should send messages to all subscribers"() {
        when:
        publisher.send("hello")

        then:
        1 * subscriber.receive("hello")
        1 * subscriber2.receive("hello")
    }

}

class Publisher {
    List<Subscriber> subscribers = []
    int messageCount = 0
    void send(String message){
        subscribers*.receive(message)
        messageCount++
    }
}

interface Subscriber {
    void receive(String message)
}

class PublisherSpec extends Specification {
    Publisher publisher = new Publisher()
}