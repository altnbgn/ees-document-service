package mn.erin.ees.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class DocumentApplication
{
  public static void main(String... args)
  {
    SpringApplication.run(DocumentApplication.class, args);
  }
}
