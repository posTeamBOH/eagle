package eagle.com;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ���λ��
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"
	,"classpath:spring/spring-activemq.xml"})
public class BaseTest {

}