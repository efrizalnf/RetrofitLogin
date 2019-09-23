package com.zlz.retrofitlogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zlz on 19,September,2019
 */
public class StatusLogin {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("is_internal")
    @Expose
    private Integer isInternal;
    @SerializedName("data")
    @Expose
    private Login data;

    /**
     * No args constructor for use in serialization
     *
     */
    public StatusLogin() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     * @param isInternal
     */
    public StatusLogin(Boolean status, String message, Integer isInternal, Login data) {
        super();
        this.status = status;
        this.message = message;
        this.isInternal = isInternal;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Integer isInternal) {
        this.isInternal = isInternal;
    }

    public Login getData() {
        return data;
    }

    public void setData(Login data) {
        this.data = data;
    }

    public String getIs_internal() {
        return null;
    }
}
