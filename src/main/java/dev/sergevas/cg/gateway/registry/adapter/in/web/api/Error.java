package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.json.bind.annotation.JsonbProperty;

import java.util.Objects;

public class Error {

    private String errorCode = null;

    private String errorMsg = null;

    /**
     * Unique error code
     **/
    public Error errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @JsonbProperty("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Detailed error description
     **/
    public Error errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    @JsonbProperty("errorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(errorCode, error.errorCode) &&
                Objects.equals(errorMsg, error.errorMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMsg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    errorMsg: ").append(toIndentedString(errorMsg)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
