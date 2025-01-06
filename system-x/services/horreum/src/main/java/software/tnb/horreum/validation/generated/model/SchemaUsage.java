/*
 * Horreum REST API
 * Horreum automated change anomaly detection. For more information, please see [https://horreum.hyperfoil.io/](https://horreum.hyperfoil.io/)
 *
 * The version of the OpenAPI document: 0.17
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package software.tnb.horreum.validation.generated.model;

import software.tnb.horreum.validation.generated.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Generated;

/**
 * SchemaUsage
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class SchemaUsage {
    public static final String SERIALIZED_NAME_ID = "id";
    @SerializedName(SERIALIZED_NAME_ID)
    @javax.annotation.Nonnull
    private Integer id;

    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName(SERIALIZED_NAME_NAME)
    @javax.annotation.Nonnull
    private String name;

    public static final String SERIALIZED_NAME_URI = "uri";
    @SerializedName(SERIALIZED_NAME_URI)
    @javax.annotation.Nonnull
    private String uri;

    public static final String SERIALIZED_NAME_SOURCE = "source";
    @SerializedName(SERIALIZED_NAME_SOURCE)
    @javax.annotation.Nonnull
    private Integer source;

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nonnull
    private Integer type;

    public static final String SERIALIZED_NAME_KEY = "key";
    @SerializedName(SERIALIZED_NAME_KEY)
    @javax.annotation.Nullable
    private String key;

    public static final String SERIALIZED_NAME_HAS_JSON_SCHEMA = "hasJsonSchema";
    @SerializedName(SERIALIZED_NAME_HAS_JSON_SCHEMA)
    @javax.annotation.Nonnull
    private Boolean hasJsonSchema;

    public SchemaUsage() {
    }

    public SchemaUsage id(@javax.annotation.Nonnull Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Schema unique ID
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(@javax.annotation.Nonnull Integer id) {
        this.id = id;
    }

    public SchemaUsage name(@javax.annotation.Nonnull String name) {
        this.name = name;
        return this;
    }

    /**
     * Schema name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(@javax.annotation.Nonnull String name) {
        this.name = name;
    }

    public SchemaUsage uri(@javax.annotation.Nonnull String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Schema name
     *
     * @return uri
     */
    @javax.annotation.Nonnull
    public String getUri() {
        return uri;
    }

    public void setUri(@javax.annotation.Nonnull String uri) {
        this.uri = uri;
    }

    public SchemaUsage source(@javax.annotation.Nonnull Integer source) {
        this.source = source;
        return this;
    }

    /**
     * Source of schema usage, 0 is data, 1 is metadata. DataSets always use 0
     *
     * @return source
     */
    @javax.annotation.Nonnull
    public Integer getSource() {
        return source;
    }

    public void setSource(@javax.annotation.Nonnull Integer source) {
        this.source = source;
    }

    public SchemaUsage type(@javax.annotation.Nonnull Integer type) {
        this.type = type;
        return this;
    }

    /**
     * Location of Schema Usage, 0 for Run, 1 for Dataset
     *
     * @return type
     */
    @javax.annotation.Nonnull
    public Integer getType() {
        return type;
    }

    public void setType(@javax.annotation.Nonnull Integer type) {
        this.type = type;
    }

    public SchemaUsage key(@javax.annotation.Nullable String key) {
        this.key = key;
        return this;
    }

    /**
     * Ordinal position of schema usage in Run/Dataset
     *
     * @return key
     */
    @javax.annotation.Nullable
    public String getKey() {
        return key;
    }

    public void setKey(@javax.annotation.Nullable String key) {
        this.key = key;
    }

    public SchemaUsage hasJsonSchema(@javax.annotation.Nonnull Boolean hasJsonSchema) {
        this.hasJsonSchema = hasJsonSchema;
        return this;
    }

    /**
     * Does schema have a JSON validation schema defined?
     *
     * @return hasJsonSchema
     */
    @javax.annotation.Nonnull
    public Boolean getHasJsonSchema() {
        return hasJsonSchema;
    }

    public void setHasJsonSchema(@javax.annotation.Nonnull Boolean hasJsonSchema) {
        this.hasJsonSchema = hasJsonSchema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchemaUsage schemaUsage = (SchemaUsage) o;
        return Objects.equals(this.id, schemaUsage.id) &&
            Objects.equals(this.name, schemaUsage.name) &&
            Objects.equals(this.uri, schemaUsage.uri) &&
            Objects.equals(this.source, schemaUsage.source) &&
            Objects.equals(this.type, schemaUsage.type) &&
            Objects.equals(this.key, schemaUsage.key) &&
            Objects.equals(this.hasJsonSchema, schemaUsage.hasJsonSchema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uri, source, type, key, hasJsonSchema);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SchemaUsage {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    hasJsonSchema: ").append(toIndentedString(hasJsonSchema)).append("\n");
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

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("id");
        openapiFields.add("name");
        openapiFields.add("uri");
        openapiFields.add("source");
        openapiFields.add("type");
        openapiFields.add("key");
        openapiFields.add("hasJsonSchema");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("id");
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("uri");
        openapiRequiredFields.add("source");
        openapiRequiredFields.add("type");
        openapiRequiredFields.add("hasJsonSchema");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to SchemaUsage
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!SchemaUsage.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in SchemaUsage is not found in the empty JSON string",
                    SchemaUsage.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!SchemaUsage.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `SchemaUsage` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : SchemaUsage.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
        }
        if (!jsonObj.get("uri").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("uri").toString()));
        }
        if ((jsonObj.get("key") != null && !jsonObj.get("key").isJsonNull()) && !jsonObj.get("key").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("key").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!SchemaUsage.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'SchemaUsage' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SchemaUsage> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(SchemaUsage.class));

            return (TypeAdapter<T>) new TypeAdapter<SchemaUsage>() {
                @Override
                public void write(JsonWriter out, SchemaUsage value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public SchemaUsage read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of SchemaUsage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SchemaUsage
     * @throws IOException if the JSON string is invalid with respect to SchemaUsage
     */
    public static SchemaUsage fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, SchemaUsage.class);
    }

    /**
     * Convert an instance of SchemaUsage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
