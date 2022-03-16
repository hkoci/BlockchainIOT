package uk.ac.brunel.blockchainIOT.springBoot;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BlockchainIotApplicationTests {
    
	@Autowired
	private springController restController;

	@Test
	void contextLoads() throws Exception {
            assertThat(restController).isNotNull();
	}

}
