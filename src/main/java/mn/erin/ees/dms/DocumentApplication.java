package mn.erin.ees.dms;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DocumentApplication
{
  @Autowired
  private ObjectMapper objectMapper;

  @PostConstruct
  public void setUp()
  {
    objectMapper.registerModule(new JavaTimeModule());
  }

  public static void main(String... args)
  {
    SpringApplication.run(DocumentApplication.class, args);
  }
}
