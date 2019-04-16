package lab.cqrs.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(LocalDateTime.now().toString());
	}

}
