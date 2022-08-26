package mn.erin.ees.dms.domain.document.repository;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;

public interface DocumentFileSaveRepository
{
  Path upload(String file, InputStream content) throws FileNotFoundException;
}
