package com.pdamkotamadiun.aduin.model.token;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Serializable
{

    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("nama_user")
    @Expose
    private String namaUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    private final static long serialVersionUID = -2240110598102106385L;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idUser", idUser).append("namaUser", namaUser).append("username", username).append("jabatan", jabatan).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jabatan).append(username).append(namaUser).append(idUser).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(jabatan, rhs.jabatan).append(username, rhs.username).append(namaUser, rhs.namaUser).append(idUser, rhs.idUser).isEquals();
    }

}