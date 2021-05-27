package ms.authentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ms.authentication.MsAuthenticationApplication;
import ms.authentication.service.IAuthenticationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsAuthenticationApplication.class)
@WebAppConfiguration
public class MsAuthenticationApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(MsAuthenticationApplicationTests.class);

	@Autowired
	private IAuthenticationService hystrixApi;

	@Test
	public void test() {

	}

}