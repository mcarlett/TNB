/*
 * Horreum API
 * Horreum data repository API
 *
 * The version of the OpenAPI document: 0.1-SNAPSHOT
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package software.tnb.horreum.validation.generated.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RunCount
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class RunCount {
    public static final String SERIALIZED_NAME_TOTAL = "total";
    public static final String SERIALIZED_NAME_ACTIVE = "active";
    public static final String SERIALIZED_NAME_TRASHED = "trashed";
    @SerializedName(SERIALIZED_NAME_TOTAL)
    private Long total;
    @SerializedName(SERIALIZED_NAME_ACTIVE)
    private Long active;
    @SerializedName(SERIALIZED_NAME_TRASHED)
    private Long trashed;

    public RunCount() {
    }

    public RunCount total(Long total) {

        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public RunCount active(Long active) {

        this.active = active;
        return this;
    }

    /**
     * Get active
     *
     * @return active
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public RunCount trashed(Long trashed) {

        this.trashed = trashed;
        return this;
    }

    /**
     * Get trashed
     *
     * @return trashed
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Long getTrashed() {
        return trashed;
    }

    public void setTrashed(Long trashed) {
        this.trashed = trashed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RunCount runCount = (RunCount) o;
        return Objects.equals(this.total, runCount.total) &&
            Objects.equals(this.active, runCount.active) &&
            Objects.equals(this.trashed, runCount.trashed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, active, trashed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RunCount {\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    active: ").append(toIndentedString(active)).append("\n");
        sb.append("    trashed: ").append(toIndentedString(trashed)).append("\n");
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
