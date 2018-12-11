package com.pdamkotamadiun.aduin.model.keluhan;

import android.support.annotation.NonNull;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pengguna implements Serializable
{

    @SerializedName("id_pengguna")
    @Expose
    private int idPengguna;
    @SerializedName("id_kelurahan")
    @Expose
    private int idKelurahan;
    @SerializedName("nomor_sambung")
    @Expose
    private String nomorSambung;
    @SerializedName("nama_pengguna")
    @Expose
    private String namaPengguna;
    @SerializedName("alamat_pengguna")
    @Expose
    private String alamatPengguna;
    @SerializedName("stanmeter_sebelum")
    @Expose
    private int stanmeterSebelum;
    @SerializedName("stanmeter_sesudah")
    @Expose
    private int stanmeterSesudah;
    private final static long serialVersionUID = -8249954283503846646L;

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNomorSambung() {
        return nomorSambung;
    }

    public void setNomorSambung(String nomorSambung) {
        this.nomorSambung = nomorSambung;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getAlamatPengguna() {
        return alamatPengguna;
    }

    public void setAlamatPengguna(String alamatPengguna) {
        this.alamatPengguna = alamatPengguna;
    }

    public int getStanmeterSebelum() {
        return stanmeterSebelum;
    }

    public void setStanmeterSebelum(int stanmeterSebelum) {
        this.stanmeterSebelum = stanmeterSebelum;
    }

    public int getStanmeterSesudah() {
        return stanmeterSesudah;
    }

    public void setStanmeterSesudah(int stanmeterSesudah) {
        this.stanmeterSesudah = stanmeterSesudah;
    }

    @NonNull
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("idPengguna", idPengguna).append("idKelurahan", idKelurahan).append("nomorSambung", nomorSambung).append("namaPengguna", namaPengguna).append("alamatPengguna", alamatPengguna).append("stanmeterSebelum", stanmeterSebelum).append("stanmeterSesudah", stanmeterSesudah).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idPengguna).append(alamatPengguna).append(idKelurahan).append(nomorSambung).append(namaPengguna).append(stanmeterSesudah).append(stanmeterSebelum).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pengguna)) {
            return false;
        }
        Pengguna rhs = ((Pengguna) other);
        return new EqualsBuilder().append(idPengguna, rhs.idPengguna).append(alamatPengguna, rhs.alamatPengguna).append(idKelurahan, rhs.idKelurahan).append(nomorSambung, rhs.nomorSambung).append(namaPengguna, rhs.namaPengguna).append(stanmeterSesudah, rhs.stanmeterSesudah).append(stanmeterSebelum, rhs.stanmeterSebelum).isEquals();
    }

}