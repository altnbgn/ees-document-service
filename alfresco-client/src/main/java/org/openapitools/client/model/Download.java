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
 * Download
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-29T14:17:06.136707300+08:00[Asia/Ulaanbaatar]")
public class Download {
  public static final String SERIALIZED_NAME_FILES_ADDED = "filesAdded";
  @SerializedName(SERIALIZED_NAME_FILES_ADDED)
  private Integer filesAdded;

  public static final String SERIALIZED_NAME_BYTES_ADDED = "bytesAdded";
  @SerializedName(SERIALIZED_NAME_BYTES_ADDED)
  private Integer bytesAdded;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_TOTAL_FILES = "totalFiles";
  @SerializedName(SERIALIZED_NAME_TOTAL_FILES)
  private Integer totalFiles;

  public static final String SERIALIZED_NAME_TOTAL_BYTES = "totalBytes";
  @SerializedName(SERIALIZED_NAME_TOTAL_BYTES)
  private Integer totalBytes;

  /**
   * the current status of the download node creation
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("PENDING"),
    
    CANCELLED("CANCELLED"),
    
    IN_PROGRESS("IN_PROGRESS"),
    
    DONE("DONE"),
    
    MAX_CONTENT_SIZE_EXCEEDED("MAX_CONTENT_SIZE_EXCEEDED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status = StatusEnum.PENDING;


  public Download filesAdded(Integer filesAdded) {
    
    this.filesAdded = filesAdded;
    return this;
  }

   /**
   * number of files added so far in the zip
   * @return filesAdded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "number of files added so far in the zip")

  public Integer getFilesAdded() {
    return filesAdded;
  }


  public void setFilesAdded(Integer filesAdded) {
    this.filesAdded = filesAdded;
  }


  public Download bytesAdded(Integer bytesAdded) {
    
    this.bytesAdded = bytesAdded;
    return this;
  }

   /**
   * number of bytes added so far in the zip
   * @return bytesAdded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "number of bytes added so far in the zip")

  public Integer getBytesAdded() {
    return bytesAdded;
  }


  public void setBytesAdded(Integer bytesAdded) {
    this.bytesAdded = bytesAdded;
  }


  public Download id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the id of the download node
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the download node")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Download totalFiles(Integer totalFiles) {
    
    this.totalFiles = totalFiles;
    return this;
  }

   /**
   * the total number of files to be added in the zip
   * @return totalFiles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the total number of files to be added in the zip")

  public Integer getTotalFiles() {
    return totalFiles;
  }


  public void setTotalFiles(Integer totalFiles) {
    this.totalFiles = totalFiles;
  }


  public Download totalBytes(Integer totalBytes) {
    
    this.totalBytes = totalBytes;
    return this;
  }

   /**
   * the total number of bytes to be added in the zip
   * @return totalBytes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the total number of bytes to be added in the zip")

  public Integer getTotalBytes() {
    return totalBytes;
  }


  public void setTotalBytes(Integer totalBytes) {
    this.totalBytes = totalBytes;
  }


  public Download status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * the current status of the download node creation
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the current status of the download node creation")

  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Download download = (Download) o;
    return Objects.equals(this.filesAdded, download.filesAdded) &&
        Objects.equals(this.bytesAdded, download.bytesAdded) &&
        Objects.equals(this.id, download.id) &&
        Objects.equals(this.totalFiles, download.totalFiles) &&
        Objects.equals(this.totalBytes, download.totalBytes) &&
        Objects.equals(this.status, download.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filesAdded, bytesAdded, id, totalFiles, totalBytes, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Download {\n");
    sb.append("    filesAdded: ").append(toIndentedString(filesAdded)).append("\n");
    sb.append("    bytesAdded: ").append(toIndentedString(bytesAdded)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    totalFiles: ").append(toIndentedString(totalFiles)).append("\n");
    sb.append("    totalBytes: ").append(toIndentedString(totalBytes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

