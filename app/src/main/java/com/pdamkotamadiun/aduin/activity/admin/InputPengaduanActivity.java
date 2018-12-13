package com.pdamkotamadiun.aduin.activity.admin;

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

import static android.widget.Toast.makeText;

public class InputPengaduanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pengaduan);

        Spinner spinner = (Spinner) findViewById(R.id.activity_input_pengaduan_spinner_value_jenisKeluhan);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> jenisKeluhan = new ArrayList<String>();
        jenisKeluhan.add("Pemasangan Baru");
        jenisKeluhan.add("Tutup Rekening");
        jenisKeluhan.add("Pengaduan");

        ArrayAdapter<String> dataJenisKeluhan = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jenisKeluhan);

        spinner.setAdapter(dataJenisKeluhan);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
