package ms.invoice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ms.invoice.MsInvoiceApplication;
import ms.invoice.service.IInvoiceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsInvoiceApplication.class)
@WebAppConfiguration
public class MsInvoiceApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(MsInvoiceApplicationTests.class);

	@Autowired
	private IInvoiceService hystrixApi;

	@Test
	public void test() {

	}

}