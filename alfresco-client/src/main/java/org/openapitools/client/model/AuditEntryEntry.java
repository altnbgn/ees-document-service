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
import org.openapitools.client.model.AuditEntry;

/**
 * AuditEntryEntry
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-29T14:17:06.136707300+08:00[Asia/Ulaanbaatar]")
public class AuditEntryEntry {
  public static final String SERIALIZED_NAME_ENTRY = "entry";
  @SerializedName(SERIALIZED_NAME_ENTRY)
  private AuditEntry entry;


  public AuditEntryEntry entry(AuditEntry entry) {
    
    this.entry = entry;
    return this;
  }

   /**
   * Get entry
   * @return entry
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AuditEntry getEntry() {
    return entry;
  }


  public void setEntry(AuditEntry entry) {
    this.entry = entry;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditEntryEntry auditEntryEntry = (AuditEntryEntry) o;
    return Objects.equals(this.entry, auditEntryEntry.entry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entry);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditEntryEntry {\n");
    sb.append("    entry: ").append(toIndentedString(entry)).append("\n");
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

