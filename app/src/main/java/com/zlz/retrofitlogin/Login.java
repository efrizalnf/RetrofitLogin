package com.zlz.retrofitlogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zlz on 18,September,2019
 */
public class Login {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("akses")
    @Expose
    private String akses;
    @SerializedName("is_internal")
    @Expose
    private Integer is_internal;

    /**
     * No args constructor for use in serialization
     *
     * @param isInternal
     */
    public Login(Integer isInternal) {
    }

    /**
     *
     * @param token
     * @param email
     * @param akses
     * @param is_internal
     * @param foto
     */
    public Login(String email, String foto, String token, String akses, Integer is_internal) {
        super();
        this.email = email;
        this.foto = foto;
        this.token = token;
        this.akses = akses;
        this.is_internal = is_internal;
    }

    public Login(String toString) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }

    public Integer getIsInternal() {
        return is_internal;
    }

    public void setIsInternal(Integer isInternal) {
        this.is_internal = is_internal;
    }
    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", foto='" + foto + '\'' +
                ", token='" + token + '\'' +
                ", akses='" + akses + '\'' +
                ", is_internal=" + is_internal +
                '}';
    }
}
