# ActivitiesApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listActivitiesForPerson**](ActivitiesApi.md#listActivitiesForPerson) | **GET** /people/{personId}/activities | List activities


<a name="listActivitiesForPerson"></a>
# **listActivitiesForPerson**
> ActivityPaging listActivitiesForPerson(personId, skipCount, maxItems, who, siteId, fields)

List activities

Gets a list of activities for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ActivitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    ActivitiesApi apiInstance = new ActivitiesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    String who = "who_example"; // String | A filter to include the user's activities only `me`, other user's activities only `others`' 
    String siteId = "siteId_example"; // String | Include only activity feed entries relating to this site.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      ActivityPaging result = apiInstance.listActivitiesForPerson(personId, skipCount, maxItems, who, siteId, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ActivitiesApi#listActivitiesForPerson");
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
 **personId** | **String**| The identifier of a person. |
 **skipCount** | **Integer**| The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.  | [optional] [default to 0]
 **maxItems** | **Integer**| The maximum number of items to return in the list. If not supplied then the default value is 100.  | [optional] [default to 100]
 **who** | **String**| A filter to include the user&#39;s activities only &#x60;me&#x60;, other user&#39;s activities only &#x60;others&#x60;&#39;  | [optional]
 **siteId** | **String**| Include only activity feed entries relating to this site. | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**ActivityPaging**](ActivityPaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems**, **skipCount**, or **who** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have access to the activities for **personId** |  -  |
**404** | **personId** or **siteId** does not exist  |  -  |
**0** | Unexpected error |  -  |

