package mn.erin.ees.dms.domain.document.repository.alfresco_repository;

import java.util.Map;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ActionsApi;
import org.openapitools.client.api.NodesApi;
import org.openapitools.client.api.QueriesApi;
import org.openapitools.client.api.SitesApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Altanbagana
 */

public class AlfrescoClient
{
  private static final Logger LOG = LoggerFactory.getLogger(AlfrescoClient.class);

  private String apiBase = "/alfresco/versions/1";

  private ApiClient coreApiClient;

  public AlfrescoClient setApiBase(String apiBase)
  {
    this.apiBase = apiBase;
    return this;
  }

  public NodesApi getNodesApi()
  {
    return new NodesApi(getCoreApiClient());
  }

  public SitesApi getSitesApi()
  {
    return new SitesApi(getCoreApiClient());
  }

  public QueriesApi getQueriesApi()
  {
    return new QueriesApi(getCoreApiClient());
  }

  public ActionsApi getActionsApi()
  {
    return new ActionsApi(getCoreApiClient());
  }

  public ApiClient getCoreApiClient()
  {
    if (coreApiClient != null)
    {
      return coreApiClient;
    }
    coreApiClient = new ApiClient();
    Map<String, String> env = System.getenv();
    String apiUrl = env.getOrDefault("ALFRESCO_HOST", "http://localhost:8080") + "/alfresco/api/-default-/public" + apiBase;
    LOG.info("Using alfresco core API url [{}]", apiUrl);
    coreApiClient.setBasePath(apiUrl);
    coreApiClient.setUsername(env.getOrDefault("ALFRESCO_USERNAME", "admin"));
    coreApiClient.setPassword(env.getOrDefault("ALFRESCO_PASSWORD", "admin"));
    return coreApiClient;
  }
}
