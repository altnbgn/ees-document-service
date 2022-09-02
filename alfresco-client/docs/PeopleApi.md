# PeopleApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerson**](PeopleApi.md#createPerson) | **POST** /people | Create person
[**deleteAvatarImage**](PeopleApi.md#deleteAvatarImage) | **DELETE** /people/{personId}/avatar | Delete avatar image
[**getAvatarImage**](PeopleApi.md#getAvatarImage) | **GET** /people/{personId}/avatar | Get avatar image
[**getPerson**](PeopleApi.md#getPerson) | **GET** /people/{personId} | Get a person
[**listPeople**](PeopleApi.md#listPeople) | **GET** /people | List people
[**requestPasswordReset**](PeopleApi.md#requestPasswordReset) | **POST** /people/{personId}/request-password-reset | Request password reset
[**resetPassword**](PeopleApi.md#resetPassword) | **POST** /people/{personId}/reset-password | Reset password
[**updateAvatarImage**](PeopleApi.md#updateAvatarImage) | **PUT** /people/{personId}/avatar | Update avatar image
[**updatePerson**](PeopleApi.md#updatePerson) | **PUT** /people/{personId} | Update person


<a name="createPerson"></a>
# **createPerson**
> PersonEntry createPerson(personBodyCreate, fields)

Create person

**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Create a person.  If applicable, the given person&#39;s login access can also be optionally disabled.  You must have admin rights to create a person.  You can set custom properties when you create a person: &#x60;&#x60;&#x60;JSON {   \&quot;id\&quot;: \&quot;abeecher\&quot;,   \&quot;firstName\&quot;: \&quot;Alice\&quot;,   \&quot;lastName\&quot;: \&quot;Beecher\&quot;,   \&quot;displayName\&quot;: \&quot;Alice Beecher\&quot;,   \&quot;email\&quot;: \&quot;abeecher@example.com\&quot;,   \&quot;password\&quot;: \&quot;secret\&quot;,   \&quot;properties\&quot;:   {     \&quot;my:property\&quot;: \&quot;The value\&quot;   } } &#x60;&#x60;&#x60; **Note:** setting properties of type d:content and d:category are not supported. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    PersonBodyCreate personBodyCreate = new PersonBodyCreate(); // PersonBodyCreate | The person details.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PersonEntry result = apiInstance.createPerson(personBodyCreate, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#createPerson");
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
 **personBodyCreate** | [**PersonBodyCreate**](PersonBodyCreate.md)| The person details. |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PersonEntry**](PersonEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful response |  -  |
**400** | Invalid parameter: **personBodyCreate** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have permission to create a person |  -  |
**409** | Person within given *id* already exists |  -  |
**422** | Model integrity exception |  -  |
**0** | Unexpected error |  -  |

<a name="deleteAvatarImage"></a>
# **deleteAvatarImage**
> deleteAvatarImage(personId)

Delete avatar image

**Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.  Deletes the avatar image related to person **personId**.  You must be the person or have admin rights to update a person&#39;s avatar.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    try {
      apiInstance.deleteAvatarImage(personId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#deleteAvatarImage");
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

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful response |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have permission to delete the avatar image for **personId** |  -  |
**404** | **personId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="getAvatarImage"></a>
# **getAvatarImage**
> File getAvatarImage(personId, attachment, ifModifiedSince, placeholder)

Get avatar image

**Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.  Gets the avatar image related to the person **personId**. If the person has no related avatar then the **placeholder** query parameter can be optionally used to request a placeholder image to be returned.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Boolean attachment = true; // Boolean | **true** enables a web browser to download the file as an attachment. **false** means a web browser may preview the file in a new tab or window.  You can only set this parameter to **false** if the content type of the file is in the supported list; for example, certain image files and PDF files.  If the content type is not supported for preview, then a value of **false**  is ignored, and the attachment will be returned in the response. 
    OffsetDateTime ifModifiedSince = OffsetDateTime.now(); // OffsetDateTime | Only returns the content if it has been modified since the date provided. Use the date format defined by HTTP. For example, `Wed, 09 Mar 2016 16:56:34 GMT`. 
    Boolean placeholder = true; // Boolean | If **true** and there is no avatar for this **personId** then the placeholder image is returned, rather than a 404 response. 
    try {
      File result = apiInstance.getAvatarImage(personId, attachment, ifModifiedSince, placeholder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#getAvatarImage");
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
 **attachment** | **Boolean**| **true** enables a web browser to download the file as an attachment. **false** means a web browser may preview the file in a new tab or window.  You can only set this parameter to **false** if the content type of the file is in the supported list; for example, certain image files and PDF files.  If the content type is not supported for preview, then a value of **false**  is ignored, and the attachment will be returned in the response.  | [optional] [default to true]
 **ifModifiedSince** | **OffsetDateTime**| Only returns the content if it has been modified since the date provided. Use the date format defined by HTTP. For example, &#x60;Wed, 09 Mar 2016 16:56:34 GMT&#x60;.  | [optional]
 **placeholder** | **Boolean**| If **true** and there is no avatar for this **personId** then the placeholder image is returned, rather than a 404 response.  | [optional] [default to true]

### Return type

[**File**](File.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**304** | Content has not been modified since the date provided in the If-Modified-Since header |  -  |
**400** | Invalid parameter: **personId** is not a valid format  |  -  |
**401** | Authentication failed |  -  |
**404** | **personId** does not exist or avatar does not exist (and no placeholder requested)  |  -  |
**0** | Unexpected error |  -  |

<a name="getPerson"></a>
# **getPerson**
> PersonEntry getPerson(personId, fields)

Get a person

Gets information for the person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PersonEntry result = apiInstance.getPerson(personId, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#getPerson");
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
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PersonEntry**](PersonEntry.md)

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
**404** | **personId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listPeople"></a>
# **listPeople**
> PersonPaging listPeople(skipCount, maxItems, orderBy, include, fields)

List people

**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  List people.  You can use the **include** parameter to return any additional information.  The default sort order for the returned list is for people to be sorted by ascending id. You can override the default by using the **orderBy** parameter.  You can use any of the following fields to order the results: * id * firstName * lastName 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> orderBy = Arrays.asList(); // List<String> | A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. 
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the person. The following optional fields can be requested: * properties * aspectNames * capabilities 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PersonPaging result = apiInstance.listPeople(skipCount, maxItems, orderBy, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#listPeople");
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
 **skipCount** | **Integer**| The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.  | [optional] [default to 0]
 **maxItems** | **Integer**| The maximum number of items to return in the list. If not supplied then the default value is 100.  | [optional] [default to 100]
 **orderBy** | [**List&lt;String&gt;**](String.md)| A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field.  | [optional]
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the person. The following optional fields can be requested: * properties * aspectNames * capabilities  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PersonPaging**](PersonPaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems**, **skipCount** or **orderBy** is invalid  |  -  |
**401** | Authentication failed |  -  |
**0** | Unexpected error |  -  |

<a name="requestPasswordReset"></a>
# **requestPasswordReset**
> requestPasswordReset(personId, clientBody)

Request password reset

**Note:** this endpoint is deprecated as of Alfresco 7.1, and will be removed in the future.  Initiates the reset password workflow to send an email with reset password instruction to the user&#39;s registered email.  The client is mandatory in the request body. For example: &#x60;&#x60;&#x60;JSON {   \&quot;client\&quot;: \&quot;myClient\&quot; } &#x60;&#x60;&#x60; **Note:** The client must be registered before this API can send an email. See [server documentation]. However, out-of-the-box share is registered as a default client, so you could pass **share** as the client name: &#x60;&#x60;&#x60;JSON {   \&quot;client\&quot;: \&quot;share\&quot; } &#x60;&#x60;&#x60; **Note:** No authentication is required to call this endpoint. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    ClientBody clientBody = new ClientBody(); // ClientBody | The client name to send email with app-specific url.
    try {
      apiInstance.requestPasswordReset(personId, clientBody);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#requestPasswordReset");
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
 **clientBody** | [**ClientBody**](ClientBody.md)| The client name to send email with app-specific url. |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Successful response or even when the **personId** does not exist or the user is disabled by an Administrator  |  -  |
**404** | **client** is not registered  |  -  |

<a name="resetPassword"></a>
# **resetPassword**
> resetPassword(personId, passwordResetBody)

Reset password

**Note:** this endpoint is deprecated as of Alfresco 7.1, and will be removed in the future. Resets user&#39;s password  The password, id and key properties are mandatory in the request body. For example: &#x60;&#x60;&#x60;JSON {   \&quot;password\&quot;:\&quot;newPassword\&quot;,   \&quot;id\&quot;:\&quot;activiti$10\&quot;,   \&quot;key\&quot;:\&quot;4dad6d00-0daf-413a-b200-f64af4e12345\&quot; } &#x60;&#x60;&#x60; **Note:** No authentication is required to call this endpoint. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    PasswordResetBody passwordResetBody = new PasswordResetBody(); // PasswordResetBody | The reset password details
    try {
      apiInstance.resetPassword(personId, passwordResetBody);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#resetPassword");
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
 **passwordResetBody** | [**PasswordResetBody**](PasswordResetBody.md)| The reset password details |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Successful response or even when no workflow instance is found with the given **id** or the workflow instance is invalid (already been used or expired) or the given **personId** does not match the person&#39;s id requesting the password reset or the given workflow **key** does not match the recovered key.  |  -  |
**400** | Invalid parameter: Value of **password**, **id** or **key** is invalid  |  -  |

<a name="updateAvatarImage"></a>
# **updateAvatarImage**
> updateAvatarImage(personId, contentBodyUpdate)

Update avatar image

**Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.  Updates the avatar image related to the person **personId**.  The request body should be the binary stream for the avatar image. The content type of the file should be an image file. This will be used to generate an \&quot;avatar\&quot; thumbnail rendition.  You must be the person or have admin rights to update a person&#39;s avatar.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    File contentBodyUpdate = new File("/path/to/file"); // File | The binary content
    try {
      apiInstance.updateAvatarImage(personId, contentBodyUpdate);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#updateAvatarImage");
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
 **contentBodyUpdate** | **File**| The binary content |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **personId** is not a valid format or the avatar cannot be uploaded  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have permission to update the avatar image for **personId** |  -  |
**404** | **personId** does not exist  |  -  |
**413** | Content exceeds individual file size limit (configured for network/system) |  -  |
**501** | Renditions/thumbnails are disabled for the system |  -  |
**507** | Content exceeds overall storage quota limit configured for the network/system |  -  |
**0** | Unexpected error |  -  |

<a name="updatePerson"></a>
# **updatePerson**
> PersonEntry updatePerson(personId, personBodyUpdate, fields)

Update person

**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Update the given person&#39;s details.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.  If applicable, the given person&#39;s login access can also be optionally disabled or re-enabled.  You must have admin rights to update a person — unless updating your own details.  If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value).  Admin users cannot be disabled by setting enabled to false.  Non-admin users may not disable themselves.  You can set custom properties when you update a person: &#x60;&#x60;&#x60;JSON {   \&quot;firstName\&quot;: \&quot;Alice\&quot;,   \&quot;properties\&quot;:   {     \&quot;my:property\&quot;: \&quot;The value\&quot;   } } &#x60;&#x60;&#x60; **Note:** setting properties of type d:content and d:category are not supported. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PeopleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    PeopleApi apiInstance = new PeopleApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    PersonBodyUpdate personBodyUpdate = new PersonBodyUpdate(); // PersonBodyUpdate | The person details.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      PersonEntry result = apiInstance.updatePerson(personId, personBodyUpdate, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PeopleApi#updatePerson");
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
 **personBodyUpdate** | [**PersonBodyUpdate**](PersonBodyUpdate.md)| The person details. |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**PersonEntry**](PersonEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: the update request is invalid or **personId** is not a valid format or **personBodyUpdate** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have permission to update a person |  -  |
**404** | **personId** does not exist  |  -  |
**422** | Model integrity exception |  -  |
**0** | Unexpected error |  -  |

