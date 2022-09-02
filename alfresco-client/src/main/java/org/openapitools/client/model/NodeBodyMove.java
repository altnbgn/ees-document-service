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

/**
 * NodeBodyMove
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-29T14:17:06.136707300+08:00[Asia/Ulaanbaatar]")
public class NodeBodyMove {
  public static final String SERIALIZED_NAME_TARGET_PARENT_ID = "targetParentId";
  @SerializedName(SERIALIZED_NAME_TARGET_PARENT_ID)
  private String targetParentId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;


  public NodeBodyMove targetParentId(String targetParentId) {
    
    this.targetParentId = targetParentId;
    return this;
  }

   /**
   * Get targetParentId
   * @return targetParentId
  **/
  @ApiModelProperty(required = true, value = "")

  public String getTargetParentId() {
    return targetParentId;
  }


  public void setTargetParentId(String targetParentId) {
    this.targetParentId = targetParentId;
  }


  public NodeBodyMove name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name must not contain spaces or the following special characters: * \&quot; &lt; &gt; \\ / ? : and |. The character . must not be used at the end of the name. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name must not contain spaces or the following special characters: * \" < > \\ / ? : and |. The character . must not be used at the end of the name. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeBodyMove nodeBodyMove = (NodeBodyMove) o;
    return Objects.equals(this.targetParentId, nodeBodyMove.targetParentId) &&
        Objects.equals(this.name, nodeBodyMove.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetParentId, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeBodyMove {\n");
    sb.append("    targetParentId: ").append(toIndentedString(targetParentId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

