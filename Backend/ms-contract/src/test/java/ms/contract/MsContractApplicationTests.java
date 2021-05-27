package ms.contract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ms.contract.MsContractApplication;
import ms.contract.service.IContractService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsContractApplication.class)
@WebAppConfiguration
public class MsContractApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(MsContractApplicationTests.class);

	@Autowired
	private IContractService hystrixApi;

	@Test
	public void test() {

	}

}