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
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class ChangeDetectionConfig extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(ChangeDetectionConfig.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ChangeDetectionConfig.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ChangeDetectionConfig' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RelativeDifferenceDetectionConfig> adapterRelativeDifferenceDetectionConfig =
                gson.getDelegateAdapter(this, TypeToken.get(RelativeDifferenceDetectionConfig.class));
            final TypeAdapter<FixedThresholdDetectionConfig> adapterFixedThresholdDetectionConfig =
                gson.getDelegateAdapter(this, TypeToken.get(FixedThresholdDetectionConfig.class));
            final TypeAdapter<EDivisiveDetectionConfig> adapterEDivisiveDetectionConfig =
                gson.getDelegateAdapter(this, TypeToken.get(EDivisiveDetectionConfig.class));

            return (TypeAdapter<T>) new TypeAdapter<ChangeDetectionConfig>() {
                @Override
                public void write(JsonWriter out, ChangeDetectionConfig value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `RelativeDifferenceDetectionConfig`
                    if (value.getActualInstance() instanceof RelativeDifferenceDetectionConfig) {
                        JsonElement element =
                            adapterRelativeDifferenceDetectionConfig.toJsonTree((RelativeDifferenceDetectionConfig) value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `FixedThresholdDetectionConfig`
                    if (value.getActualInstance() instanceof FixedThresholdDetectionConfig) {
                        JsonElement element =
                            adapterFixedThresholdDetectionConfig.toJsonTree((FixedThresholdDetectionConfig) value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `EDivisiveDetectionConfig`
                    if (value.getActualInstance() instanceof EDivisiveDetectionConfig) {
                        JsonElement element = adapterEDivisiveDetectionConfig.toJsonTree((EDivisiveDetectionConfig) value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException(
                        "Failed to serialize as the type doesn't match oneOf schemas: EDivisiveDetectionConfig, FixedThresholdDetectionConfig, "
                            + "RelativeDifferenceDetectionConfig");
                }

                @Override
                public ChangeDetectionConfig read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize RelativeDifferenceDetectionConfig
                    try {
                        // validate the JSON object to see if any exception is thrown
                        RelativeDifferenceDetectionConfig.validateJsonElement(jsonElement);
                        actualAdapter = adapterRelativeDifferenceDetectionConfig;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'RelativeDifferenceDetectionConfig'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for RelativeDifferenceDetectionConfig failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'RelativeDifferenceDetectionConfig'", e);
                    }
                    // deserialize FixedThresholdDetectionConfig
                    try {
                        // validate the JSON object to see if any exception is thrown
                        FixedThresholdDetectionConfig.validateJsonElement(jsonElement);
                        actualAdapter = adapterFixedThresholdDetectionConfig;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'FixedThresholdDetectionConfig'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for FixedThresholdDetectionConfig failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'FixedThresholdDetectionConfig'", e);
                    }
                    // deserialize EDivisiveDetectionConfig
                    try {
                        // validate the JSON object to see if any exception is thrown
                        EDivisiveDetectionConfig.validateJsonElement(jsonElement);
                        actualAdapter = adapterEDivisiveDetectionConfig;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'EDivisiveDetectionConfig'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for EDivisiveDetectionConfig failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'EDivisiveDetectionConfig'", e);
                    }

                    if (match == 1) {
                        ChangeDetectionConfig ret = new ChangeDetectionConfig();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format(
                        "Failed deserialization for ChangeDetectionConfig: %d classes match result, expected 1. Detailed failure message for oneOf "
                            + "schemas: %s. JSON: %s",
                        match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public ChangeDetectionConfig() {
        super("oneOf", Boolean.FALSE);
    }

    public ChangeDetectionConfig(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("RelativeDifferenceDetectionConfig", RelativeDifferenceDetectionConfig.class);
        schemas.put("FixedThresholdDetectionConfig", FixedThresholdDetectionConfig.class);
        schemas.put("EDivisiveDetectionConfig", EDivisiveDetectionConfig.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return ChangeDetectionConfig.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * EDivisiveDetectionConfig, FixedThresholdDetectionConfig, RelativeDifferenceDetectionConfig
     * <p>
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof RelativeDifferenceDetectionConfig) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof FixedThresholdDetectionConfig) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof EDivisiveDetectionConfig) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException(
            "Invalid instance type. Must be EDivisiveDetectionConfig, FixedThresholdDetectionConfig, RelativeDifferenceDetectionConfig");
    }

    /**
     * Get the actual instance, which can be the following:
     * EDivisiveDetectionConfig, FixedThresholdDetectionConfig, RelativeDifferenceDetectionConfig
     *
     * @return The actual instance (EDivisiveDetectionConfig, FixedThresholdDetectionConfig, RelativeDifferenceDetectionConfig)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `RelativeDifferenceDetectionConfig`. If the actual instance is not `RelativeDifferenceDetectionConfig`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `RelativeDifferenceDetectionConfig`
     * @throws ClassCastException if the instance is not `RelativeDifferenceDetectionConfig`
     */
    public RelativeDifferenceDetectionConfig getRelativeDifferenceDetectionConfig() throws ClassCastException {
        return (RelativeDifferenceDetectionConfig) super.getActualInstance();
    }

    /**
     * Get the actual instance of `FixedThresholdDetectionConfig`. If the actual instance is not `FixedThresholdDetectionConfig`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `FixedThresholdDetectionConfig`
     * @throws ClassCastException if the instance is not `FixedThresholdDetectionConfig`
     */
    public FixedThresholdDetectionConfig getFixedThresholdDetectionConfig() throws ClassCastException {
        return (FixedThresholdDetectionConfig) super.getActualInstance();
    }

    /**
     * Get the actual instance of `EDivisiveDetectionConfig`. If the actual instance is not `EDivisiveDetectionConfig`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `EDivisiveDetectionConfig`
     * @throws ClassCastException if the instance is not `EDivisiveDetectionConfig`
     */
    public EDivisiveDetectionConfig getEDivisiveDetectionConfig() throws ClassCastException {
        return (EDivisiveDetectionConfig) super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ChangeDetectionConfig
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with RelativeDifferenceDetectionConfig
        try {
            RelativeDifferenceDetectionConfig.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for RelativeDifferenceDetectionConfig failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with FixedThresholdDetectionConfig
        try {
            FixedThresholdDetectionConfig.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for FixedThresholdDetectionConfig failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with EDivisiveDetectionConfig
        try {
            EDivisiveDetectionConfig.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for EDivisiveDetectionConfig failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format(
                "The JSON string is invalid for ChangeDetectionConfig with oneOf schemas: EDivisiveDetectionConfig, FixedThresholdDetectionConfig, "
                    + "RelativeDifferenceDetectionConfig. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s"
                    + ". JSON: %s",
                validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of ChangeDetectionConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ChangeDetectionConfig
     * @throws IOException if the JSON string is invalid with respect to ChangeDetectionConfig
     */
    public static ChangeDetectionConfig fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ChangeDetectionConfig.class);
    }

    /**
     * Convert an instance of ChangeDetectionConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

