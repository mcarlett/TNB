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
 * Preview a Label Value derived from a Dataset Data. A preview allows users to apply a Label to a dataset and preview the Label Value result and
 * processing errors in the UI
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class LabelPreview {
    public static final String SERIALIZED_NAME_VALUE = "value";
    @SerializedName(SERIALIZED_NAME_VALUE)
    @javax.annotation.Nullable
    private String value;

    public static final String SERIALIZED_NAME_OUTPUT = "output";
    @SerializedName(SERIALIZED_NAME_OUTPUT)
    @javax.annotation.Nullable
    private String output;

    public LabelPreview() {
    }

    public LabelPreview value(@javax.annotation.Nullable String value) {
        this.value = value;
        return this;
    }

    /**
     * Value value extracted from Dataset. This can be a scalar, array or JSON object
     *
     * @return value
     */
    @javax.annotation.Nullable
    public String getValue() {
        return value;
    }

    public void setValue(@javax.annotation.Nullable String value) {
        this.value = value;
    }

    public LabelPreview output(@javax.annotation.Nullable String output) {
        this.output = output;
        return this;
    }

    /**
     * Description of errors occurred attempting to generate Label Value Preview
     *
     * @return output
     */
    @javax.annotation.Nullable
    public String getOutput() {
        return output;
    }

    public void setOutput(@javax.annotation.Nullable String output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LabelPreview labelPreview = (LabelPreview) o;
        return Objects.equals(this.value, labelPreview.value) &&
            Objects.equals(this.output, labelPreview.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, output);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LabelPreview {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
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
        openapiFields.add("value");
        openapiFields.add("output");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to LabelPreview
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!LabelPreview.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in LabelPreview is not found in the empty JSON string",
                    LabelPreview.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!LabelPreview.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `LabelPreview` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("value") != null && !jsonObj.get("value").isJsonNull()) && !jsonObj.get("value").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("value").toString()));
        }
        if ((jsonObj.get("output") != null && !jsonObj.get("output").isJsonNull()) && !jsonObj.get("output").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `output` to be a primitive type in the JSON string but got `%s`",
                jsonObj.get("output").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!LabelPreview.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'LabelPreview' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<LabelPreview> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(LabelPreview.class));

            return (TypeAdapter<T>) new TypeAdapter<LabelPreview>() {
                @Override
                public void write(JsonWriter out, LabelPreview value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public LabelPreview read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of LabelPreview given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of LabelPreview
     * @throws IOException if the JSON string is invalid with respect to LabelPreview
     */
    public static LabelPreview fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, LabelPreview.class);
    }

    /**
     * Convert an instance of LabelPreview to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

