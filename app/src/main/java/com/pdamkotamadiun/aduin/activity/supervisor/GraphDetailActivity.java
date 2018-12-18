package com.pdamkotamadiun.aduin.activity.supervisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdamkotamadiun.aduin.R;

import java.util.ArrayList;
import java.util.List;

public class GraphDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_detail);

        Spinner spinnerJenisKeluhan     = (Spinner) findViewById(R.id.activity_graph_detail_spinner_jenisKeluhan);
        Spinner spinnerJenisPengaduan   = (Spinner) findViewById(R.id.activity_graph_detail_spinner_jenisPengaduan);
        Spinner spinnerWilayah          = (Spinner) findViewById(R.id.activity_graph_detail_spinner_wilayah);
        Spinner spinnerKelurahan        = (Spinner) findViewById(R.id.activity_graph_detail_spinner_kelurahan);
        Spinner spinnerBulan            = (Spinner) findViewById(R.id.activity_graph_detail_spinner_bulan);

//        Item Listener untuk Spinner Jenis Keluhan
        spinnerJenisKeluhan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {

            }
        });

//        Item Listener untuk Spinner Jenis Pengaduan
        spinnerJenisPengaduan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {

            }
        });

//        Item Listener untuk Spinner Wilayah
        spinnerWilayah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Item Listener untuk Spinner Kelurahan
        spinnerKelurahan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Item Listener untuk Spinner Bulan
        spinnerBulan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Elemen untuk Spinner Jenis Keluhan
        List<String> jenisKeluhan = new ArrayList<String>();
        jenisKeluhan.add("Pemasangan Baru");
        jenisKeluhan.add("Tutup Rekening");
        jenisKeluhan.add("Pengaduan");

//        Elemen untuk Spinner Jenis Pengaduan
        List<String> jenisPengaduan = new ArrayList<String>();
        jenisPengaduan.add("Pipa Bocor");
        jenisPengaduan.add("Terameter 25%");
        jenisPengaduan.add("Terameter 50%");
        jenisPengaduan.add("Terameter 75%");
        jenisPengaduan.add("Air Tidak Keluar");
        jenisPengaduan.add("Air Keluar Kecil");
        jenisPengaduan.add("Air Keruh");
        jenisPengaduan.add("Ganti Meter");

//        Elemen untuk Spinner Wilayah
        List<String> wilayah = new ArrayList<String>();
        wilayah.add("Wilayah I");
        wilayah.add("Wilayah II");
        wilayah.add("Wilayah III");

//        Elemen untuk Spinner Kelurahan
        List<String> kelurahan = new ArrayList<String>();
        kelurahan.add("Mangunharjo");
        kelurahan.add("Bangunkarto");
        kelurahan.add("Bala-bala");

//        Elemen untuk Spinner Bulan
        List<String> bulan = new ArrayList<String>();
        bulan.add("Januari");
        bulan.add("Februari");
        bulan.add("Maret");
        bulan.add("April");
        bulan.add("Mei");
        bulan.add("Juni");
        bulan.add("Juli");
        bulan.add("Agustun");
        bulan.add("September");
        bulan.add("Oktober");
        bulan.add("November");
        bulan.add("Desember");

        ArrayAdapter<String> dataJenisKeluhan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jenisKeluhan);
        spinnerJenisKeluhan.setAdapter(dataJenisKeluhan);

        ArrayAdapter<String> dataJenisPengaduan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jenisPengaduan);
        spinnerJenisPengaduan.setAdapter(dataJenisPengaduan);

        ArrayAdapter<String> dataWilayah = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wilayah);
        spinnerWilayah.setAdapter(dataWilayah);

        ArrayAdapter<String> dataKelurahan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kelurahan);
        spinnerKelurahan.setAdapter(dataKelurahan);

        ArrayAdapter<String> dataBulan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bulan);
        spinnerBulan.setAdapter(dataBulan);

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

