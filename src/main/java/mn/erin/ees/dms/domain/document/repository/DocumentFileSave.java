package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class DocumentFileSave implements DocumentFileSaveRepository
{

  private final Path folder = Paths.get("fsRoot/test-1/");

  @Override
  public Path upload(String file, InputStream content){

    try
    {
      Files.createDirectories(folder);
      return Files.write(folder.resolve(file), content.readAllBytes());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
