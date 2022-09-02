# StorageInfoApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStorageProperties**](StorageInfoApi.md#getStorageProperties) | **GET** /nodes/{nodeId}/storage-info/{contentPropName} | Retrieve storage properties for given content
[**getVersionStorageProperties**](StorageInfoApi.md#getVersionStorageProperties) | **GET** /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName} | Retrieve storage properties for given version content
[**requestArchiveContent**](StorageInfoApi.md#requestArchiveContent) | **POST** /nodes/{nodeId}/storage-info/{contentPropName}/archive | Request to send given content to archive
[**requestArchiveVersionContent**](StorageInfoApi.md#requestArchiveVersionContent) | **POST** /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive | Request to send given version content to archive
[**requestRestoreContentFromArchive**](StorageInfoApi.md#requestRestoreContentFromArchive) | **POST** /nodes/{nodeId}/storage-info/{contentPropName}/archive-restore | Request to restore given content from archive
[**requestRestoreVersionContentFromArchive**](StorageInfoApi.md#requestRestoreVersionContentFromArchive) | **POST** /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive-restore | Request to restore given version content from archive


<a name="getStorageProperties"></a>
# **getStorageProperties**
> ContentStorageInfo getStorageProperties(nodeId, contentPropName)

Retrieve storage properties for given content

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Gets storage properties for given content.  Please find below sample responses for this endpoint when Alfresco Content Connector for AWS S3 is installed.  Similar responses will be returned when Alfresco Content Connector for Azure Blob is installed, albeit it with  some native storage properties with x-ms- prefix instead of x-amz- prefix.  Standard storage class: &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Intelligent tiering storage class: &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;INTELLIGENT_TIERING\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (no restore request ongoing or submitted): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;true\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (restore request ongoing, not completed): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archive-restore-in-progress\&quot;: \&quot;true\&quot;,       \&quot;x-amz-restore\&quot;: \&quot;ongoing-request&#x3D;\\\&quot;true\\\&quot;\&quot;,       \&quot;x-alf-archived\&quot;: \&quot;true\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (restore request completed): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archive-restore-in-progress\&quot;: \&quot;false\&quot;,       \&quot;x-amz-restore\&quot;: \&quot;ongoing-request&#x3D;\\\&quot;false\\\&quot;, expiry-date&#x3D;\\\&quot;Fri Nov 26 01:00:00 CET 2021\\\&quot;\&quot;,       \&quot;x-alf-archive-restore-expiry\&quot;: \&quot;2021-11-26T00:00:00.000Z\&quot;,       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    try {
      ContentStorageInfo result = apiInstance.getStorageProperties(nodeId, contentPropName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#getStorageProperties");
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
 **nodeId** | **String**| The identifier of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |

### Return type

[**ContentStorageInfo**](ContentStorageInfo.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **nodeId** or **contentPropName** is not a valid format, or is not a file  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **contentPropName** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="getVersionStorageProperties"></a>
# **getVersionStorageProperties**
> ContentStorageInfo getVersionStorageProperties(nodeId, versionId, contentPropName)

Retrieve storage properties for given version content

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Gets storage properties for given version content.  Please find below sample responses for this endpoint when Alfresco Content Connector for AWS S3 is installed.  Similar responses will be returned when Alfresco Content Connector for Azure Blob is installed, albeit it with  some native storage properties with x-ms- prefix instead of x-amz- prefix.  Standard storage class: &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Intelligent tiering storage class: &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;INTELLIGENT_TIERING\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (no restore request ongoing or submitted): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archived\&quot;: \&quot;true\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (restore request ongoing, not completed): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archive-restore-in-progress\&quot;: \&quot;true\&quot;,       \&quot;x-amz-restore\&quot;: \&quot;ongoing-request&#x3D;\\\&quot;true\\\&quot;\&quot;,       \&quot;x-alf-archived\&quot;: \&quot;true\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; Glacier archive storage class (restore request completed): &#x60;&#x60;&#x60;json {   \&quot;entry\&quot;: {     \&quot;storageProperties\&quot;: {       \&quot;x-alf-archive-restore-in-progress\&quot;: \&quot;false\&quot;,       \&quot;x-amz-restore\&quot;: \&quot;ongoing-request&#x3D;\\\&quot;false\\\&quot;, expiry-date&#x3D;\\\&quot;Fri Nov 26 01:00:00 CET 2021\\\&quot;\&quot;,       \&quot;x-alf-archive-restore-expiry\&quot;: \&quot;2021-11-26T00:00:00.000Z\&quot;,       \&quot;x-alf-archived\&quot;: \&quot;false\&quot;,       \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;     },     \&quot;id\&quot;: \&quot;cm:content\&quot;   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String versionId = "versionId_example"; // String | The identifier of a version, ie. version label, within the version history of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    try {
      ContentStorageInfo result = apiInstance.getVersionStorageProperties(nodeId, versionId, contentPropName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#getVersionStorageProperties");
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
 **nodeId** | **String**| The identifier of a node. |
 **versionId** | **String**| The identifier of a version, ie. version label, within the version history of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |

### Return type

[**ContentStorageInfo**](ContentStorageInfo.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **nodeId** or **versionId** or **contentPropName** is not a valid format, or is not a file  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **versionId** or **contentPropName** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="requestArchiveContent"></a>
# **requestArchiveContent**
> requestArchiveContent(nodeId, contentPropName, archiveContentRequest)

Request to send given content to archive

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Request to send given content to archive. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    ArchiveContentRequest archiveContentRequest = new ArchiveContentRequest(); // ArchiveContentRequest | Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: ```JSON {   \"archiveParams\": {                 \"x-amz-storage-class\": \"GLACIER\"               } } ``` 
    try {
      apiInstance.requestArchiveContent(nodeId, contentPropName, archiveContentRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#requestArchiveContent");
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
 **nodeId** | **String**| The identifier of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |
 **archiveContentRequest** | [**ArchiveContentRequest**](ArchiveContentRequest.md)| Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: &#x60;&#x60;&#x60;JSON {   \&quot;archiveParams\&quot;: {                 \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;               } } &#x60;&#x60;&#x60;  | [optional]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **nodeId** or **contentPropName** is not a valid format, or is not a file Content&#39;s storage state does not allow archive. Invalid archive paramters.  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **contentPropName** does not exist  |  -  |
**409** | Content already archived |  -  |
**0** | Unexpected error |  -  |

<a name="requestArchiveVersionContent"></a>
# **requestArchiveVersionContent**
> requestArchiveVersionContent(nodeId, versionId, contentPropName, archiveContentRequest)

Request to send given version content to archive

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Request to send given version content to archive. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String versionId = "versionId_example"; // String | The identifier of a version, ie. version label, within the version history of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    ArchiveContentRequest archiveContentRequest = new ArchiveContentRequest(); // ArchiveContentRequest | Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: ```JSON {   \"archiveParams\": {                 \"x-amz-storage-class\": \"GLACIER\"               } } ``` 
    try {
      apiInstance.requestArchiveVersionContent(nodeId, versionId, contentPropName, archiveContentRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#requestArchiveVersionContent");
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
 **nodeId** | **String**| The identifier of a node. |
 **versionId** | **String**| The identifier of a version, ie. version label, within the version history of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |
 **archiveContentRequest** | [**ArchiveContentRequest**](ArchiveContentRequest.md)| Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: &#x60;&#x60;&#x60;JSON {   \&quot;archiveParams\&quot;: {                 \&quot;x-amz-storage-class\&quot;: \&quot;GLACIER\&quot;               } } &#x60;&#x60;&#x60;  | [optional]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **nodeId** or **versionId** or **contentPropName** is not a valid format, or is not a file Content&#39;s storage state does not allow archive. Invalid archive paramters.  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **versionId** or **contentPropName** does not exist  |  -  |
**409** | Content already archived |  -  |
**0** | Unexpected error |  -  |

<a name="requestRestoreContentFromArchive"></a>
# **requestRestoreContentFromArchive**
> requestRestoreContentFromArchive(nodeId, contentPropName, restoreArchivedContentRequest)

Request to restore given content from archive

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Request to restore given content from archive. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    RestoreArchivedContentRequest restoreArchivedContentRequest = new RestoreArchivedContentRequest(); // RestoreArchivedContentRequest | Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. 'High' restore priority translates to 'Expedited' Glacier restore tier in AWS S3 and 'High' rehydrate priority in Azure Blob. 'Standard' restore priority translates to 'Standard' Glacier restore tier in AWS S3 and 'Standard' rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: ```JSON {   \"restorePriority\": \"High\" } ``` Standard restore priority request body example: ```JSON {   \"restorePriority\": \"Standard\" } ``` 
    try {
      apiInstance.requestRestoreContentFromArchive(nodeId, contentPropName, restoreArchivedContentRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#requestRestoreContentFromArchive");
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
 **nodeId** | **String**| The identifier of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |
 **restoreArchivedContentRequest** | [**RestoreArchivedContentRequest**](RestoreArchivedContentRequest.md)| Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. &#39;High&#39; restore priority translates to &#39;Expedited&#39; Glacier restore tier in AWS S3 and &#39;High&#39; rehydrate priority in Azure Blob. &#39;Standard&#39; restore priority translates to &#39;Standard&#39; Glacier restore tier in AWS S3 and &#39;Standard&#39; rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: &#x60;&#x60;&#x60;JSON {   \&quot;restorePriority\&quot;: \&quot;High\&quot; } &#x60;&#x60;&#x60; Standard restore priority request body example: &#x60;&#x60;&#x60;JSON {   \&quot;restorePriority\&quot;: \&quot;Standard\&quot; } &#x60;&#x60;&#x60;  | [optional]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Successful response (request accepted) |  -  |
**400** | Invalid parameter: n**nodeId** or **contentPropName** is not a valid format, or is not a file Content&#39;s storage state does not allow restore. Invalid restore paramters.  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **contentPropName** does not exist  |  -  |
**409** | Content already restored or restoration is already in progress |  -  |
**0** | Unexpected error |  -  |

<a name="requestRestoreVersionContentFromArchive"></a>
# **requestRestoreVersionContentFromArchive**
> requestRestoreVersionContentFromArchive(nodeId, versionId, contentPropName, restoreArchivedContentRequest)

Request to restore given version content from archive

**Note:** this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s).  Request to restore given version content from archive. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.StorageInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    StorageInfoApi apiInstance = new StorageInfoApi(defaultClient);
    String nodeId = "nodeId_example"; // String | The identifier of a node.
    String versionId = "versionId_example"; // String | The identifier of a version, ie. version label, within the version history of a node.
    String contentPropName = "contentPropName_example"; // String | The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content'). 
    RestoreArchivedContentRequest restoreArchivedContentRequest = new RestoreArchivedContentRequest(); // RestoreArchivedContentRequest | Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. 'High' restore priority translates to 'Expedited' Glacier restore tier in AWS S3 and 'High' rehydrate priority in Azure Blob. 'Standard' restore priority translates to 'Standard' Glacier restore tier in AWS S3 and 'Standard' rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: ```JSON {   \"restorePriority\": \"High\" } ``` Standard restore priority request body example: ```JSON {   \"restorePriority\": \"Standard\" } ``` 
    try {
      apiInstance.requestRestoreVersionContentFromArchive(nodeId, versionId, contentPropName, restoreArchivedContentRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling StorageInfoApi#requestRestoreVersionContentFromArchive");
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
 **nodeId** | **String**| The identifier of a node. |
 **versionId** | **String**| The identifier of a version, ie. version label, within the version history of a node. |
 **contentPropName** | **String**| The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (&#39;:&#39;) or underscore (&#39;_&#39;) character (e.g., &#39;cm:content&#39; or &#39;cm_content&#39;).  |
 **restoreArchivedContentRequest** | [**RestoreArchivedContentRequest**](RestoreArchivedContentRequest.md)| Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. &#39;High&#39; restore priority translates to &#39;Expedited&#39; Glacier restore tier in AWS S3 and &#39;High&#39; rehydrate priority in Azure Blob. &#39;Standard&#39; restore priority translates to &#39;Standard&#39; Glacier restore tier in AWS S3 and &#39;Standard&#39; rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: &#x60;&#x60;&#x60;JSON {   \&quot;restorePriority\&quot;: \&quot;High\&quot; } &#x60;&#x60;&#x60; Standard restore priority request body example: &#x60;&#x60;&#x60;JSON {   \&quot;restorePriority\&quot;: \&quot;Standard\&quot; } &#x60;&#x60;&#x60;  | [optional]

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Successful response (request accepted) |  -  |
**400** | Invalid parameter: **nodeId** or **versionId** or **contentPropName** is not a valid format, or is not a file Content&#39;s storage state does not allow restore. Invalid restore paramters.  |  -  |
**401** | Authentication failed |  -  |
**403** | Not authorized |  -  |
**404** | **nodeId** or **versionId** or **contentPropName** does not exist  |  -  |
**409** | Content already restored or restoration is already in progress |  -  |
**0** | Unexpected error |  -  |

