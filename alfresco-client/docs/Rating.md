

# Rating

A person can rate an item of content by liking it. They can also remove their like of an item of content. API methods exist to get a list of ratings and to add a new rating. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  | 
**aggregate** | [**RatingAggregate**](RatingAggregate.md) |  | 
**ratedAt** | **OffsetDateTime** |  |  [optional]
**myRating** | **String** | The rating. The type is specific to the rating scheme, boolean for the likes and an integer for the fiveStar. |  [optional]



