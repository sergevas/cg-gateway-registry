package dev.sergevas.cg.gateway.registry.boundary.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class ErrorWithDeviceErrorInfo {

    private @Valid String errorCode = null;
    private @Valid String errorMsg = null;
    private @Valid Integer deviceResponseHttpCode = null;
    private @Valid String deviceErrorCode = null;
    private @Valid String deviceErrorMsg = null;

    /**
     * Unique error code
     **/
    public ErrorWithDeviceErrorInfo errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @JsonbProperty("errorCode")
    @Size(max=4)
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Detailed error description
     **/
    public ErrorWithDeviceErrorInfo errorMsg(String errorMsg) {
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

    /**
     * Device response original HTTP code
     **/
    public ErrorWithDeviceErrorInfo deviceResponseHttpCode(Integer deviceResponseHttpCode) {
        this.deviceResponseHttpCode = deviceResponseHttpCode;
        return this;
    }


    @JsonbProperty("deviceResponseHttpCode")
    public Integer getDeviceResponseHttpCode() {
        return deviceResponseHttpCode;
    }

    public void setDeviceResponseHttpCode(Integer deviceResponseHttpCode) {
        this.deviceResponseHttpCode = deviceResponseHttpCode;
    }

    /**
     * Device original error code
     **/
    public ErrorWithDeviceErrorInfo deviceErrorCode(String deviceErrorCode) {
        this.deviceErrorCode = deviceErrorCode;
        return this;
    }

    @JsonbProperty("deviceErrorCode")
    @Size(max=4)
    public String getDeviceErrorCode() {
        return deviceErrorCode;
    }

    public void setDeviceErrorCode(String deviceErrorCode) {
        this.deviceErrorCode = deviceErrorCode;
    }

    /**
     * Device original error description
     **/
    public ErrorWithDeviceErrorInfo deviceErrorMsg(String deviceErrorMsg) {
        this.deviceErrorMsg = deviceErrorMsg;
        return this;
    }


    @JsonbProperty("deviceErrorMsg")
    public String getDeviceErrorMsg() {
        return deviceErrorMsg;
    }

    public void setDeviceErrorMsg(String deviceErrorMsg) {
        this.deviceErrorMsg = deviceErrorMsg;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorWithDeviceErrorInfo errorWithDeviceErrorInfo = (ErrorWithDeviceErrorInfo) o;
        return Objects.equals(errorCode, errorWithDeviceErrorInfo.errorCode) &&
                Objects.equals(errorMsg, errorWithDeviceErrorInfo.errorMsg) &&
                Objects.equals(deviceResponseHttpCode, errorWithDeviceErrorInfo.deviceResponseHttpCode) &&
                Objects.equals(deviceErrorCode, errorWithDeviceErrorInfo.deviceErrorCode) &&
                Objects.equals(deviceErrorMsg, errorWithDeviceErrorInfo.deviceErrorMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMsg, deviceResponseHttpCode, deviceErrorCode, deviceErrorMsg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorWithDeviceErrorInfo {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    errorMsg: ").append(toIndentedString(errorMsg)).append("\n");
        sb.append("    deviceResponseHttpCode: ").append(toIndentedString(deviceResponseHttpCode)).append("\n");
        sb.append("    deviceErrorCode: ").append(toIndentedString(deviceErrorCode)).append("\n");
        sb.append("    deviceErrorMsg: ").append(toIndentedString(deviceErrorMsg)).append("\n");
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
