/*
 * Alfresco Content Services REST API
 * **Core API**  Provides access to the core features of Alfresco Content Services. 
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DownloadBodyCreate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-29T14:17:06.136707300+08:00[Asia/Ulaanbaatar]")
public class DownloadBodyCreate {
  public static final String SERIALIZED_NAME_NODE_IDS = "nodeIds";
  @SerializedName(SERIALIZED_NAME_NODE_IDS)
  private List<String> nodeIds = new ArrayList<String>();


  public DownloadBodyCreate nodeIds(List<String> nodeIds) {
    
    this.nodeIds = nodeIds;
    return this;
  }

  public DownloadBodyCreate addNodeIdsItem(String nodeIdsItem) {
    this.nodeIds.add(nodeIdsItem);
    return this;
  }

   /**
   * Get nodeIds
   * @return nodeIds
  **/
  @ApiModelProperty(required = true, value = "")

  public List<String> getNodeIds() {
    return nodeIds;
  }


  public void setNodeIds(List<String> nodeIds) {
    this.nodeIds = nodeIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadBodyCreate downloadBodyCreate = (DownloadBodyCreate) o;
    return Objects.equals(this.nodeIds, downloadBodyCreate.nodeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadBodyCreate {\n");
    sb.append("    nodeIds: ").append(toIndentedString(nodeIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

