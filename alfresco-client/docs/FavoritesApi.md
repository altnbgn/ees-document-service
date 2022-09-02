# FavoritesApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFavorite**](FavoritesApi.md#createFavorite) | **POST** /people/{personId}/favorites | Create a favorite
[**createSiteFavorite**](FavoritesApi.md#createSiteFavorite) | **POST** /people/{personId}/favorite-sites | Create a site favorite
[**deleteFavorite**](FavoritesApi.md#deleteFavorite) | **DELETE** /people/{personId}/favorites/{favoriteId} | Delete a favorite
[**deleteSiteFavorite**](FavoritesApi.md#deleteSiteFavorite) | **DELETE** /people/{personId}/favorite-sites/{siteId} | Delete a site favorite
[**getFavorite**](FavoritesApi.md#getFavorite) | **GET** /people/{personId}/favorites/{favoriteId} | Get a favorite
[**getFavoriteSite**](FavoritesApi.md#getFavoriteSite) | **GET** /people/{personId}/favorite-sites/{siteId} | Get a favorite site
[**listFavoriteSitesForPerson**](FavoritesApi.md#listFavoriteSitesForPerson) | **GET** /people/{personId}/favorite-sites | List favorite sites
[**listFavorites**](FavoritesApi.md#listFavorites) | **GET** /people/{personId}/favorites | List favorites


<a name="createFavorite"></a>
# **createFavorite**
> FavoriteEntry createFavorite(personId, favoriteBodyCreate, include, fields)

Create a favorite

Favorite a **site**, **file**, or **folder** in the repository.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.  **Note:** You can favorite more than one entity by specifying a list of objects in the JSON body like this:  &#x60;&#x60;&#x60;JSON [   {        \&quot;target\&quot;: {           \&quot;file\&quot;: {              \&quot;guid\&quot;: \&quot;abcde-01234-....\&quot;           }        }    },    {        \&quot;target\&quot;: {           \&quot;file\&quot;: {              \&quot;guid\&quot;: \&quot;abcde-09863-....\&quot;           }        }    }, ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:  &#x60;&#x60;&#x60;JSON {   \&quot;list\&quot;: {     \&quot;pagination\&quot;: {       \&quot;count\&quot;: 2,       \&quot;hasMoreItems\&quot;: false,       \&quot;totalItems\&quot;: 2,       \&quot;skipCount\&quot;: 0,       \&quot;maxItems\&quot;: 100     },     \&quot;entries\&quot;: [       {         \&quot;entry\&quot;: {           ...         }       },       {         \&quot;entry\&quot;: {           ...         }       }     ]   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    FavoriteBodyCreate favoriteBodyCreate = new FavoriteBodyCreate(); // FavoriteBodyCreate | An object identifying the entity to be favorited.  The object consists of a single property which is an object with the name `site`, `file`, or `folder`. The content of that object is the `guid` of the target entity.  For example, to favorite a file the following body would be used:  ```JSON {    \"target\": {       \"file\": {          \"guid\": \"abcde-01234-....\"       }    } } ``` 
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      FavoriteEntry result = apiInstance.createFavorite(personId, favoriteBodyCreate, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#createFavorite");
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
 **favoriteBodyCreate** | [**FavoriteBodyCreate**](FavoriteBodyCreate.md)| An object identifying the entity to be favorited.  The object consists of a single property which is an object with the name &#x60;site&#x60;, &#x60;file&#x60;, or &#x60;folder&#x60;. The content of that object is the &#x60;guid&#x60; of the target entity.  For example, to favorite a file the following body would be used:  &#x60;&#x60;&#x60;JSON {    \&quot;target\&quot;: {       \&quot;file\&quot;: {          \&quot;guid\&quot;: \&quot;abcde-01234-....\&quot;       }    } } &#x60;&#x60;&#x60;  |
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**FavoriteEntry**](FavoriteEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful response |  -  |
**400** | Invalid parameter: **favoriteBodyCreate** invalid  |  -  |
**401** | Authentication failed |  -  |
**404** | **personId** does not exist, or the target entity does not exist, or a favorite already exists with the specified id, or an entity exists with the id of the posted object but is not of the same type of the posted object  |  -  |
**409** | The target **guid** has already been favorited |  -  |
**0** | Unexpected error |  -  |

<a name="createSiteFavorite"></a>
# **createSiteFavorite**
> FavoriteSiteEntry createSiteFavorite(personId, favoriteSiteBodyCreate, fields)

Create a site favorite

**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use &#x60;/people/{personId}/favorites&#x60; instead.  Create a site favorite for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.   **Note:** You can favorite more than one site by specifying a list of sites in the JSON body like this:  &#x60;&#x60;&#x60;JSON [   {     \&quot;id\&quot;: \&quot;test-site-1\&quot;   },   {     \&quot;id\&quot;: \&quot;test-site-2\&quot;   } ] &#x60;&#x60;&#x60; If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example:  &#x60;&#x60;&#x60;JSON {   \&quot;list\&quot;: {     \&quot;pagination\&quot;: {       \&quot;count\&quot;: 2,       \&quot;hasMoreItems\&quot;: false,       \&quot;totalItems\&quot;: 2,       \&quot;skipCount\&quot;: 0,       \&quot;maxItems\&quot;: 100     },     \&quot;entries\&quot;: [       {         \&quot;entry\&quot;: {           ...         }       },       {         \&quot;entry\&quot;: {           ...         }       }     ]   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    FavoriteSiteBodyCreate favoriteSiteBodyCreate = new FavoriteSiteBodyCreate(); // FavoriteSiteBodyCreate | The id of the site to favorite.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      FavoriteSiteEntry result = apiInstance.createSiteFavorite(personId, favoriteSiteBodyCreate, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#createSiteFavorite");
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
 **favoriteSiteBodyCreate** | [**FavoriteSiteBodyCreate**](FavoriteSiteBodyCreate.md)| The id of the site to favorite. |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**FavoriteSiteEntry**](FavoriteSiteEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful response |  -  |
**400** | Invalid parameter: **favoriteSiteBodyCreate** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | Current user does not have access to the favorite sites for **personId** |  -  |
**404** | **personId** does not exist  |  -  |
**409** | **id** is already a site favorite  |  -  |
**0** | Unexpected error |  -  |

<a name="deleteFavorite"></a>
# **deleteFavorite**
> deleteFavorite(personId, favoriteId)

Delete a favorite

Deletes **favoriteId** as a favorite of person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    String favoriteId = "favoriteId_example"; // String | The identifier of a favorite.
    try {
      apiInstance.deleteFavorite(personId, favoriteId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#deleteFavorite");
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
 **favoriteId** | **String**| The identifier of a favorite. |

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
**404** | **personId** or **favoriteId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="deleteSiteFavorite"></a>
# **deleteSiteFavorite**
> deleteSiteFavorite(personId, siteId)

Delete a site favorite

**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use &#x60;/people/{personId}/favorites/{favoriteId}&#x60; instead.  Deletes site **siteId** from the favorite site list of person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    String siteId = "siteId_example"; // String | The identifier of a site.
    try {
      apiInstance.deleteSiteFavorite(personId, siteId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#deleteSiteFavorite");
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
 **siteId** | **String**| The identifier of a site. |

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
**403** | Current user does not have access to the favorite sites for **personId** |  -  |
**404** | **personId** or **siteId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="getFavorite"></a>
# **getFavorite**
> FavoriteEntry getFavorite(personId, favoriteId, include, fields)

Get a favorite

Gets favorite **favoriteId** for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    String favoriteId = "favoriteId_example"; // String | The identifier of a favorite.
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      FavoriteEntry result = apiInstance.getFavorite(personId, favoriteId, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#getFavorite");
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
 **favoriteId** | **String**| The identifier of a favorite. |
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**FavoriteEntry**](FavoriteEntry.md)

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
**404** | **personId** or **favoriteId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="getFavoriteSite"></a>
# **getFavoriteSite**
> SiteEntry getFavoriteSite(personId, siteId, fields)

Get a favorite site

**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use &#x60;/people/{personId}/favorites/{favoriteId}&#x60; instead.  Gets information on favorite site **siteId** of person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    String siteId = "siteId_example"; // String | The identifier of a site.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      SiteEntry result = apiInstance.getFavoriteSite(personId, siteId, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#getFavoriteSite");
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
 **siteId** | **String**| The identifier of a site. |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**SiteEntry**](SiteEntry.md)

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
**403** | Current user does not have access to the favorite sites for **personId** |  -  |
**404** | **personId** or **siteId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listFavoriteSitesForPerson"></a>
# **listFavoriteSitesForPerson**
> SitePaging listFavoriteSitesForPerson(personId, skipCount, maxItems, fields)

List favorite sites

**Note:** this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use &#x60;/people/{personId}/favorites&#x60; instead.  Gets a list of a person&#39;s favorite sites.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      SitePaging result = apiInstance.listFavoriteSitesForPerson(personId, skipCount, maxItems, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#listFavoriteSitesForPerson");
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

[**SitePaging**](SitePaging.md)

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
**403** | Current user does not have access to the favorite sites for **personId** |  -  |
**404** | **personId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listFavorites"></a>
# **listFavorites**
> FavoritePaging listFavorites(personId, skipCount, maxItems, orderBy, where, include, fields)

List favorites

Gets a list of favorites for person **personId**.  You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.  The default sort order for the returned list of favorites is type ascending, createdAt descending. You can override the default by using the **orderBy** parameter.  You can use any of the following fields to order the results: *   &#x60;type&#x60; *   &#x60;createdAt&#x60; *   &#x60;title&#x60;  You can use the **where** parameter to restrict the list in the response to entries of a specific kind. The **where** parameter takes a value. The value is a single predicate that can include one or more **EXISTS** conditions. The **EXISTS** condition uses a single operand to limit the list to include entries that include that one property. The property values are:  *   &#x60;target/file&#x60; *   &#x60;target/folder&#x60; *   &#x60;target/site&#x60;  For example, the following **where** parameter restricts the returned list to the file favorites for a person:  &#x60;&#x60;&#x60;SQL (EXISTS(target/file)) &#x60;&#x60;&#x60; You can specify more than one condition using **OR**. The predicate must be enclosed in parentheses.   For example, the following **where** parameter restricts the returned list to the file and folder favorites for a person:  &#x60;&#x60;&#x60;SQL (EXISTS(target/file) OR EXISTS(target/folder)) &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> orderBy = Arrays.asList(); // List<String> | A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. 
    String where = "where_example"; // String | A string to restrict the returned objects by using a predicate.
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      FavoritePaging result = apiInstance.listFavorites(personId, skipCount, maxItems, orderBy, where, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#listFavorites");
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
 **orderBy** | [**List&lt;String&gt;**](String.md)| A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field.  | [optional]
 **where** | **String**| A string to restrict the returned objects by using a predicate. | [optional]
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**FavoritePaging**](FavoritePaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems**, **skipCount**, **orderBy**, or **where** is invalid  |  -  |
**401** | Authentication failed |  -  |
**404** | **personId** does not exist or the current user does not have permission to access the favorites of **personId**  |  -  |
**0** | Unexpected error |  -  |

