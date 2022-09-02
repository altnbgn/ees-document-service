# GroupsApi

All URIs are relative to *http://localhost/alfresco/api/-default-/public/alfresco/versions/1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createGroup**](GroupsApi.md#createGroup) | **POST** /groups | Create a group
[**createGroupMembership**](GroupsApi.md#createGroupMembership) | **POST** /groups/{groupId}/members | Create a group membership
[**deleteGroup**](GroupsApi.md#deleteGroup) | **DELETE** /groups/{groupId} | Delete a group
[**deleteGroupMembership**](GroupsApi.md#deleteGroupMembership) | **DELETE** /groups/{groupId}/members/{groupMemberId} | Delete a group membership
[**getGroup**](GroupsApi.md#getGroup) | **GET** /groups/{groupId} | Get group details
[**listGroupMemberships**](GroupsApi.md#listGroupMemberships) | **GET** /groups/{groupId}/members | List memberships of a group
[**listGroupMembershipsForPerson**](GroupsApi.md#listGroupMembershipsForPerson) | **GET** /people/{personId}/groups | List group memberships
[**listGroups**](GroupsApi.md#listGroups) | **GET** /groups | List groups
[**updateGroup**](GroupsApi.md#updateGroup) | **PUT** /groups/{groupId} | Update group details


<a name="createGroup"></a>
# **createGroup**
> GroupEntry createGroup(groupBodyCreate, include, fields)

Create a group

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Create a group.  The group id must start with \&quot;GROUP\\_\&quot;. If this is omitted it will be added automatically. This format is also returned when listing groups or group memberships. It should be noted that the other group-related operations also expect the id to start with \&quot;GROUP\\_\&quot;.  If one or more parentIds are specified then the group will be created and become a member of each of the specified parent groups.  If no parentIds are specified then the group will be created as a root group.  The group will be created in the **APP.DEFAULT** and **AUTH.ALF** zones.  You must have admin rights to create a group. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    GroupBodyCreate groupBodyCreate = new GroupBodyCreate(); // GroupBodyCreate | The group to create.
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the group. The following optional fields can be requested: * parentIds * zones 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupEntry result = apiInstance.createGroup(groupBodyCreate, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#createGroup");
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
 **groupBodyCreate** | [**GroupBodyCreate**](GroupBodyCreate.md)| The group to create. |
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the group. The following optional fields can be requested: * parentIds * zones  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupEntry**](GroupEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful response |  -  |
**400** | Invalid parameter: invalid **groupBodyCreate**  |  -  |
**401** | Authentication failed |  -  |
**403** | User does not have permission to create a group |  -  |
**404** | **parentIds** does not exist  |  -  |
**409** | **id** clashes with an existing group  |  -  |
**0** | Unexpected error |  -  |

<a name="createGroupMembership"></a>
# **createGroupMembership**
> GroupMemberEntry createGroupMembership(groupId, groupMembershipBodyCreate, fields)

Create a group membership

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Create a group membership (for an existing person or group) within a group **groupId**.  If the added group was previously a root group then it becomes a non-root group since it now has a parent.  It is an error to specify an **id** that does not exist.  You must have admin rights to create a group membership. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    GroupMembershipBodyCreate groupMembershipBodyCreate = new GroupMembershipBodyCreate(); // GroupMembershipBodyCreate | The group membership to add (person or sub-group).
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupMemberEntry result = apiInstance.createGroupMembership(groupId, groupMembershipBodyCreate, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#createGroupMembership");
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
 **groupId** | **String**| The identifier of a group. |
 **groupMembershipBodyCreate** | [**GroupMembershipBodyCreate**](GroupMembershipBodyCreate.md)| The group membership to add (person or sub-group). |
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupMemberEntry**](GroupMemberEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful response |  -  |
**400** | Invalid parameter: **groupId** or **groupMembershipBodyCreate** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | User does not have permission to create a group membership |  -  |
**404** | **groupId** or *id* (of group or person) does not exist  |  -  |
**409** | Trying to modify a pre-defined system group, such as GROUP_EVERYONE.  |  -  |
**0** | Unexpected error |  -  |

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(groupId, cascade)

Delete a group

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Delete group **groupId**.  The option to cascade delete applies this recursively to any hierarchy of group members. In this case, removing a group member does not delete the person or sub-group itself. If a removed sub-group no longer has any parent groups then it becomes a root group.  You must have admin rights to delete a group. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    Boolean cascade = false; // Boolean | If **true** then the delete will be applied in cascade to sub-groups. 
    try {
      apiInstance.deleteGroup(groupId, cascade);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#deleteGroup");
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
 **groupId** | **String**| The identifier of a group. |
 **cascade** | **Boolean**| If **true** then the delete will be applied in cascade to sub-groups.  | [optional] [default to false]

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
**400** | Invalid parameter: **groupId** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | User does not have permission to delete a group member |  -  |
**404** | **groupId** does not exist  |  -  |
**409** | Trying to delete a pre-defined system group, such as GROUP_EVERYONE.  |  -  |
**0** | Unexpected error |  -  |

<a name="deleteGroupMembership"></a>
# **deleteGroupMembership**
> deleteGroupMembership(groupId, groupMemberId)

Delete a group membership

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Delete group member **groupMemberId** (person or sub-group) from group **groupId**.  Removing a group member does not delete the person or sub-group itself.  If a removed sub-group no longer has any parent groups then it becomes a root group.  You must have admin rights to delete a group membership. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    String groupMemberId = "groupMemberId_example"; // String | The identifier of a person or group.
    try {
      apiInstance.deleteGroupMembership(groupId, groupMemberId);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#deleteGroupMembership");
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
 **groupId** | **String**| The identifier of a group. |
 **groupMemberId** | **String**| The identifier of a person or group. |

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
**400** | Invalid parameter: value of **groupId**, or **groupMemberId** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | User does not have permission to delete a group membership |  -  |
**404** | **groupId** or **groupMemberId** does not exist  |  -  |
**409** | Trying to delete a member of a pre-defined system group, such as GROUP_EVERYONE  |  -  |
**0** | Unexpected error |  -  |

<a name="getGroup"></a>
# **getGroup**
> GroupEntry getGroup(groupId, include, fields)

Get group details

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Get details for group **groupId**.  You can use the **include** parameter to return additional information. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the group. The following optional fields can be requested: * parentIds * zones 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupEntry result = apiInstance.getGroup(groupId, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#getGroup");
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
 **groupId** | **String**| The identifier of a group. |
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the group. The following optional fields can be requested: * parentIds * zones  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupEntry**](GroupEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: invalid **groupId**  |  -  |
**401** | Authentication failed |  -  |
**404** | **groupId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listGroupMemberships"></a>
# **listGroupMemberships**
> GroupMemberPaging listGroupMemberships(groupId, skipCount, maxItems, orderBy, where, fields)

List memberships of a group

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Gets a list of the group memberships for the group **groupId**.  You can use the **where** parameter to filter the returned groups by **memberType**.  Example to filter by **memberType**, use any one of:  &#x60;&#x60;&#x60; (memberType&#x3D;&#39;GROUP&#39;) (memberType&#x3D;&#39;PERSON&#39;) &#x60;&#x60;&#x60;  The default sort order for the returned list is for group members to be sorted by ascending displayName. You can override the default by using the **orderBy** parameter. You can specify one of the following fields in the **orderBy** parameter: * id * displayName 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> orderBy = Arrays.asList(); // List<String> | A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. 
    String where = "where_example"; // String | A string to restrict the returned objects by using a predicate.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupMemberPaging result = apiInstance.listGroupMemberships(groupId, skipCount, maxItems, orderBy, where, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#listGroupMemberships");
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
 **groupId** | **String**| The identifier of a group. |
 **skipCount** | **Integer**| The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.  | [optional] [default to 0]
 **maxItems** | **Integer**| The maximum number of items to return in the list. If not supplied then the default value is 100.  | [optional] [default to 100]
 **orderBy** | [**List&lt;String&gt;**](String.md)| A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field.  | [optional]
 **where** | **String**| A string to restrict the returned objects by using a predicate. | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupMemberPaging**](GroupMemberPaging.md)

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
**404** | **groupId** does not exist  |  -  |
**405** | Trying to list all members of a pre-defined system group, such as GROUP_EVERYONE  |  -  |
**0** | Unexpected error |  -  |

<a name="listGroupMembershipsForPerson"></a>
# **listGroupMembershipsForPerson**
> GroupPaging listGroupMembershipsForPerson(personId, skipCount, maxItems, orderBy, include, where, fields)

List group memberships

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.   Gets a list of group membership information for person **personId**.   You can use the &#x60;-me-&#x60; string in place of &#x60;&lt;personId&gt;&#x60; to specify the currently authenticated user.   You can use the **include** parameter to return additional information.   You can use the **where** parameter to filter the returned groups by **isRoot**. For example, the following **where**  clause will return just the root groups:   &#x60;&#x60;&#x60;  (isRoot&#x3D;true)  &#x60;&#x60;&#x60;   The **where** parameter can also be used to filter by ***zone***. This may be combined with isRoot to narrow  a result set even further. For example, the following where clause will only return groups belonging to the  &#x60;MY.ZONE&#x60; zone.   &#x60;&#x60;&#x60;  where&#x3D;(zones in (&#39;MY.ZONE&#39;))  &#x60;&#x60;&#x60;   This may be combined with the isRoot filter, as shown below:   &#x60;&#x60;&#x60;  where&#x3D;(isRoot&#x3D;false AND zones in (&#39;MY.ZONE&#39;))  &#x60;&#x60;&#x60;   ***Note:*** restrictions include  * &#x60;AND&#x60; is the only supported operator when combining &#x60;isRoot&#x60; and &#x60;zones&#x60; filters  * Only one zone is supported by the filter  * The quoted zone name must be placed in parenthesis — a 400 error will result if these are omitted.    The default sort order for the returned list is for groups to be sorted by ascending displayName.  You can override the default by using the **orderBy** parameter. You can specify one or more of the following fields in the **orderBy** parameter:  * id  * displayName 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String personId = "personId_example"; // String | The identifier of a person.
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> orderBy = Arrays.asList(); // List<String> | A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. 
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the group. The following optional fields can be requested: * parentIds * zones 
    String where = "where_example"; // String | A string to restrict the returned objects by using a predicate.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupPaging result = apiInstance.listGroupMembershipsForPerson(personId, skipCount, maxItems, orderBy, include, where, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#listGroupMembershipsForPerson");
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
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the group. The following optional fields can be requested: * parentIds * zones  | [optional]
 **where** | **String**| A string to restrict the returned objects by using a predicate. | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupPaging**](GroupPaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems**, **skipCount**, **orderBy** or **personId** is invalid  |  -  |
**401** | Authentication failed |  -  |
**404** | **personId** does not exist  |  -  |
**0** | Unexpected error |  -  |

<a name="listGroups"></a>
# **listGroups**
> GroupPaging listGroups(skipCount, maxItems, orderBy, include, where, fields)

List groups

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Gets a list of groups.  You can use the **include** parameter to return additional information.  You can use the **where** parameter to filter the returned groups by **isRoot**. For example, the following **where** clause will return just the root groups:  &#x60;&#x60;&#x60; (isRoot&#x3D;true) &#x60;&#x60;&#x60;  The **where** parameter can also be used to filter by ***zone*** and ***displayName***. They may be combined with isRoot to narrow a result set even further.  For example, the following where clause will only return groups belonging to the &#x60;MY.ZONE&#x60; zone.  &#x60;&#x60;&#x60; where&#x3D;(zones in (&#39;MY.ZONE&#39;)) &#x60;&#x60;&#x60;  This may be combined with the isRoot filter, as shown below:  &#x60;&#x60;&#x60; where&#x3D;(isRoot&#x3D;false AND zones in (&#39;MY.ZONE&#39;)) &#x60;&#x60;&#x60; The following where clause will only return groups with displayName &#x60;MY.GROUP.NAME&#x60;.   &#x60;&#x60;&#x60; where&#x3D;(displayName in (&#39;MY.GROUP.NAME&#39;)) &#x60;&#x60;&#x60; This may be combined with the isRoot and zones filter, as shown below:  &#x60;&#x60;&#x60; where&#x3D;(isRoot&#x3D;false AND displayName in (&#39;MY.GROUP.NAME&#39;)) &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; where&#x3D;(zones in (&#39;MY.ZONE&#39;) AND displayName in (&#39;MY.GROUP.NAME&#39;)) &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; where&#x3D;(isRoot&#x3D;false AND zones in (&#39;MY.ZONE&#39;) AND displayName in (&#39;MY.GROUP.NAME&#39;)) &#x60;&#x60;&#x60;  ***Note:*** restrictions include * &#x60;AND&#x60; is the only supported operator when combining &#x60;isRoot&#x60;, &#x60;zones&#x60; and &#x60;displayName&#x60; filters * Only one zone is supported by the filter * Only one displayName is supported by the filter * The quoted zone name and displayName must be placed in parenthesis — a 400 error will result if these are omitted.  The default sort order for the returned list is for groups to be sorted by ascending displayName. You can override the default by using the **orderBy** parameter. You can specify one of the following fields in the **orderBy** parameter: * id * displayName 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    Integer skipCount = 0; // Integer | The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0. 
    Integer maxItems = 100; // Integer | The maximum number of items to return in the list. If not supplied then the default value is 100. 
    List<String> orderBy = Arrays.asList(); // List<String> | A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. 
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the group. The following optional fields can be requested: * parentIds * zones 
    String where = "where_example"; // String | A string to restrict the returned objects by using a predicate.
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupPaging result = apiInstance.listGroups(skipCount, maxItems, orderBy, include, where, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#listGroups");
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
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the group. The following optional fields can be requested: * parentIds * zones  | [optional]
 **where** | **String**| A string to restrict the returned objects by using a predicate. | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupPaging**](GroupPaging.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: value of **maxItems** or **skipCount**, or **orderBy**, or **where** is invalid  |  -  |
**401** | Authentication failed |  -  |
**0** | Unexpected error |  -  |

<a name="updateGroup"></a>
# **updateGroup**
> GroupEntry updateGroup(groupId, groupBodyUpdate, include, fields)

Update group details

**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Update details (displayName) for group **groupId**.  You must have admin rights to update a group. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/alfresco/api/-default-/public/alfresco/versions/1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    GroupsApi apiInstance = new GroupsApi(defaultClient);
    String groupId = "groupId_example"; // String | The identifier of a group.
    GroupBodyUpdate groupBodyUpdate = new GroupBodyUpdate(); // GroupBodyUpdate | The group information to update.
    List<String> include = Arrays.asList(); // List<String> | Returns additional information about the group. The following optional fields can be requested: * parentIds * zones 
    List<String> fields = Arrays.asList(); // List<String> | A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. 
    try {
      GroupEntry result = apiInstance.updateGroup(groupId, groupBodyUpdate, include, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GroupsApi#updateGroup");
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
 **groupId** | **String**| The identifier of a group. |
 **groupBodyUpdate** | [**GroupBodyUpdate**](GroupBodyUpdate.md)| The group information to update. |
 **include** | [**List&lt;String&gt;**](String.md)| Returns additional information about the group. The following optional fields can be requested: * parentIds * zones  | [optional]
 **fields** | [**List&lt;String&gt;**](String.md)| A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter.  | [optional]

### Return type

[**GroupEntry**](GroupEntry.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful response |  -  |
**400** | Invalid parameter: **groupId** or **groupBodyCreate** is invalid  |  -  |
**401** | Authentication failed |  -  |
**403** | User does not have permission to update a group |  -  |
**404** | **groupId** does not exist  |  -  |
**409** | Trying to modify a pre-defined system group, such as GROUP_EVERYONE  |  -  |
**0** | Unexpected error |  -  |

