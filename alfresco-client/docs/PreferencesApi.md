# PreferencesApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPreference**](PreferencesApi.md#getPreference) | **GET** /people/{personId}/preferences/{preferenceName} | Get a preference
[**listPreferences**](PreferencesApi.md#listPreferences) | **GET** /people/{personId}/preferences | List preferences


<a name="getPreference"></a>
# **getPreference**
> PreferenceEntry getPreference(personId, preferenceName, fields)

Get a preference

Gets a specific preference for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PreferencesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PreferencesApi apiInstance = new PreferencesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    String preferenceName = "preferenceName_example"; // String | The name of the preference.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PreferenceEntry result = apiInstance.getPreference(personId, preferenceName, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PreferencesApi#getPreference");
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
 **preferenceName** | **String**| The name of the preference. |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PreferenceEntry**](PreferenceEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have access to the preferences for **personId** |  -  |
**404** | **personId** or **preferenceName** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listPreferences"></a>
# **listPreferences**
> PreferencePaging listPreferences(personId, skipCount, maxItems, fields)

List preferences

Gets a list of preferences for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. Note that each preference consists of an **id** and a **value**.  The **value** can be of any JSON type. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PreferencesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PreferencesApi apiInstance = new PreferencesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PreferencePaging result = apiInstance.listPreferences(personId, skipCount, maxItems, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PreferencesApi#listPreferences");
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
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PreferencePaging**](PreferencePaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems** or **skipCount** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have access to the preferences for **personId** |  -  |
**404** | **personId** does not exist  |  -  |
**0** | Unexpected error |  -  |

