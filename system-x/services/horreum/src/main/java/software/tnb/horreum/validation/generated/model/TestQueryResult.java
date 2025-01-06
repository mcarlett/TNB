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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Generated;

/**
 * TestQueryResult
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class TestQueryResult {
    public static final String SERIALIZED_NAME_TESTS = "tests";
    @SerializedName(SERIALIZED_NAME_TESTS)
    @javax.annotation.Nonnull
    private List<Test> tests = new ArrayList<>();

    public static final String SERIALIZED_NAME_COUNT = "count";
    @SerializedName(SERIALIZED_NAME_COUNT)
    @javax.annotation.Nonnull
    private Long count;

    public TestQueryResult() {
    }

    public TestQueryResult tests(@javax.annotation.Nonnull List<Test> tests) {
        this.tests = tests;
        return this;
    }

    public TestQueryResult addTestsItem(Test testsItem) {
        if (this.tests == null) {
            this.tests = new ArrayList<>();
        }
        this.tests.add(testsItem);
        return this;
    }

    /**
     * Array of Tests
     *
     * @return tests
     */
    @javax.annotation.Nonnull
    public List<Test> getTests() {
        return tests;
    }

    public void setTests(@javax.annotation.Nonnull List<Test> tests) {
        this.tests = tests;
    }

    public TestQueryResult count(@javax.annotation.Nonnull Long count) {
        this.count = count;
        return this;
    }

    /**
     * Count of available tests. This is a count of tests that the current user has access to
     *
     * @return count
     */
    @javax.annotation.Nonnull
    public Long getCount() {
        return count;
    }

    public void setCount(@javax.annotation.Nonnull Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestQueryResult testQueryResult = (TestQueryResult) o;
        return Objects.equals(this.tests, testQueryResult.tests) &&
            Objects.equals(this.count, testQueryResult.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tests, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TestQueryResult {\n");
        sb.append("    tests: ").append(toIndentedString(tests)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
        openapiFields.add("tests");
        openapiFields.add("count");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("tests");
        openapiRequiredFields.add("count");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to TestQueryResult
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!TestQueryResult.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in TestQueryResult is not found in the empty JSON string",
                    TestQueryResult.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!TestQueryResult.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `TestQueryResult` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : TestQueryResult.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // ensure the json data is an array
        if (!jsonObj.get("tests").isJsonArray()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `tests` to be an array in the JSON string but got `%s`", jsonObj.get("tests").toString()));
        }

        JsonArray jsonArraytests = jsonObj.getAsJsonArray("tests");
        // validate the required field `tests` (array)
        for (int i = 0; i < jsonArraytests.size(); i++) {
            Test.validateJsonElement(jsonArraytests.get(i));
        }
        ;
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TestQueryResult.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TestQueryResult' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<TestQueryResult> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(TestQueryResult.class));

            return (TypeAdapter<T>) new TypeAdapter<TestQueryResult>() {
                @Override
                public void write(JsonWriter out, TestQueryResult value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public TestQueryResult read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of TestQueryResult given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TestQueryResult
     * @throws IOException if the JSON string is invalid with respect to TestQueryResult
     */
    public static TestQueryResult fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, TestQueryResult.class);
    }

    /**
     * Convert an instance of TestQueryResult to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
