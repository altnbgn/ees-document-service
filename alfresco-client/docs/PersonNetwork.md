

# PersonNetwork

A network is the group of users and sites that belong to an organization. Networks are organized by email domain. When a user signs up for an Alfresco account , their email domain becomes their Home Network. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | This network&#39;s unique id | 
**homeNetwork** | **Boolean** | Is this the home network? |  [optional]
**isEnabled** | **Boolean** |  | 
**createdAt** | **OffsetDateTime** |  |  [optional]
**paidNetwork** | **Boolean** |  |  [optional]
**subscriptionLevel** | [**SubscriptionLevelEnum**](#SubscriptionLevelEnum) |  |  [optional]
**quotas** | [**List&lt;NetworkQuota&gt;**](NetworkQuota.md) |  |  [optional]



## Enum: SubscriptionLevelEnum

Name | Value
---- | -----
FREE | &quot;Free&quot;
STANDARD | &quot;Standard&quot;
ENTERPRISE | &quot;Enterprise&quot;



