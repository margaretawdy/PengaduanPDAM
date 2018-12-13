package com.pdamkotamadiun.aduin.service;

import com.pdamkotamadiun.aduin.model.keluhan.KeluhanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JenisKeluhanService {
    @GET
    Call<KeluhanResponse> getKeluhan();
}
