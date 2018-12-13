package com.pdamkotamadiun.aduin.model.keluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class JenisKeluhan implements Serializable
{

    @SerializedName("id_keluhan")
    @Expose
    private int idKeluhan;
    @SerializedName("nama_keluhan")
    @Expose
    private String namaKeluhan;
    private final static long serialVersionUID = -7871855690247657095L;

    public int getIdKeluhan() {
        return idKeluhan;
    }

    public void setIdKeluhan(int idKeluhan) {
        this.idKeluhan = idKeluhan;
    }

    public String getNamaKeluhan() {
        return namaKeluhan;
    }

    public void setNamaKeluhan(String namaKeluhan) {
        this.namaKeluhan = namaKeluhan;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idKeluhan", idKeluhan).append("namaKeluhan", namaKeluhan).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idKeluhan).append(namaKeluhan).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JenisKeluhan)) {
            return false;
        }
        JenisKeluhan rhs = ((JenisKeluhan) other);
        return new EqualsBuilder().append(idKeluhan, rhs.idKeluhan).append(namaKeluhan, rhs.namaKeluhan).isEquals();
    }

}