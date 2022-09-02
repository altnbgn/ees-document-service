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
 * NodeBodyLock
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-29T14:17:06.136707300+08:00[Asia/Ulaanbaatar]")
public class NodeBodyLock {
  public static final String SERIALIZED_NAME_TIME_TO_EXPIRE = "timeToExpire";
  @SerializedName(SERIALIZED_NAME_TIME_TO_EXPIRE)
  private Integer timeToExpire;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    ALLOW_OWNER_CHANGES("ALLOW_OWNER_CHANGES"),
    
    FULL("FULL");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type = TypeEnum.ALLOW_OWNER_CHANGES;

  /**
   * Gets or Sets lifetime
   */
  @JsonAdapter(LifetimeEnum.Adapter.class)
  public enum LifetimeEnum {
    PERSISTENT("PERSISTENT"),
    
    EPHEMERAL("EPHEMERAL");

    private String value;

    LifetimeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LifetimeEnum fromValue(String value) {
      for (LifetimeEnum b : LifetimeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LifetimeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LifetimeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LifetimeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LifetimeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LIFETIME = "lifetime";
  @SerializedName(SERIALIZED_NAME_LIFETIME)
  private LifetimeEnum lifetime = LifetimeEnum.PERSISTENT;


  public NodeBodyLock timeToExpire(Integer timeToExpire) {
    
    this.timeToExpire = timeToExpire;
    return this;
  }

   /**
   * Get timeToExpire
   * minimum: 0
   * @return timeToExpire
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTimeToExpire() {
    return timeToExpire;
  }


  public void setTimeToExpire(Integer timeToExpire) {
    this.timeToExpire = timeToExpire;
  }


  public NodeBodyLock type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  public NodeBodyLock lifetime(LifetimeEnum lifetime) {
    
    this.lifetime = lifetime;
    return this;
  }

   /**
   * Get lifetime
   * @return lifetime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public LifetimeEnum getLifetime() {
    return lifetime;
  }


  public void setLifetime(LifetimeEnum lifetime) {
    this.lifetime = lifetime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeBodyLock nodeBodyLock = (NodeBodyLock) o;
    return Objects.equals(this.timeToExpire, nodeBodyLock.timeToExpire) &&
        Objects.equals(this.type, nodeBodyLock.type) &&
        Objects.equals(this.lifetime, nodeBodyLock.lifetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeToExpire, type, lifetime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeBodyLock {\n");
    sb.append("    timeToExpire: ").append(toIndentedString(timeToExpire)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lifetime: ").append(toIndentedString(lifetime)).append("\n");
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

