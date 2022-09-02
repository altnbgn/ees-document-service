# ProbesApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProbe**](ProbesApi.md#getProbe) | **GET** /probes/{probeId} | Check readiness and liveness of the repository


<a name="getProbe"></a>
# **getProbe**
> ProbeEntry getProbe(probeId)

Check readiness and liveness of the repository

**Note:** this endpoint is available in Alfresco 6.0 and newer versions.  Returns a status of 200 to indicate success and 503 for failure.  The readiness probe is normally only used to check repository startup.  The liveness probe should then be used to check the repository is still responding to requests.  **Note:** No authentication is required to call this endpoint. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProbesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    ProbesApi apiInstance = new ProbesApi(defaultClient);
    String probeId = "probeId_example"; // String | The name of the probe: * -ready- * -live- 
    try {
      ProbeEntry result = apiInstance.getProbe(probeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProbesApi#getProbe");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **probeId** | **String**| The name of the probe: * -ready- * -live-  |

### Return type

[**ProbeEntry**](ProbeEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**404** | **probeId** does not exist  |  -  |
**503** | Service Unavailable - Probe failure status. |  -  |
**0** | Unexpected error |  -  |

