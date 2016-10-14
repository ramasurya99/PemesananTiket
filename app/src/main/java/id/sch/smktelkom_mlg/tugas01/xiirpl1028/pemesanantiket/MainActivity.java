package id.sch.smktelkom_mlg.tugas01.xiirpl1028.pemesanantiket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.tugas01.xiirpl1028.pemesanantiket.adapter.KotaAdapter;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNoKTP;
    EditText etAlamat;
    EditText etTahun;
    TextView tvHasil;
    RadioGroup rgStatus;
    CheckBox cbDW, cbAN;
    Spinner spProvinsi1, spKota1;
    Button bOK;
    String[][] arKota1 = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan" +
            "Jakarta Timur", "Jakarta Utara"}, {"Bandung", "Cirebon", "Bekasi"}, {"Semarang",
            "Magelang", "Yogyakarta", "Surakarta"}, {"Surabaya", "Malang", "Blitar", "Kediri",
            "Banyuwangi", "Jombang", "Nganjuk", "Ponorogo"}};

    ArrayList<String> listKota = new ArrayList<>();
    KotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNoKTP = (EditText) findViewById(R.id.editTextNoKTP);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupJenisKelamin);
        cbDW = (CheckBox) findViewById(R.id.checkBoxDW);
        cbAN = (CheckBox) findViewById(R.id.checkBoxAN);
        spProvinsi1 = (Spinner) findViewById(R.id.spinnerProvinsi1);
        spKota1 = (Spinner) findViewById(R.id.spinnerKota1);
        bOK = (Button) findViewById(R.id.buttonOK);

        adapter = new KotaAdapter(this, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota1.setAdapter(adapter);

        spProvinsi1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota1[pos]));
                adapter.setmProvinsi((String) spProvinsi1.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spKota1.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasil = null;
                if (rgStatus.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton)
                            findViewById(rgStatus.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();
                } else if (hasil == null) {
                    hasil = "Belum memilih Jenis Kelamin";
                }


                String jadi = "";
                int stratlen = jadi.length();
                if (cbDW.isChecked()) jadi += cbDW.getText() + "\n";
                if (cbAN.isChecked()) jadi += cbAN.getText() + "\n";

                if (jadi.length() == stratlen) jadi += "Tidak ada Pilihan";

                tvHasil.setText(jadi);


                String nama = etNama.getText().toString();
                String noktp = etNoKTP.getText().toString();
                String alamat = etAlamat.getText().toString();
                String tahun = etTahun.getText().toString();
                tvHasil.setText(" Terimakasih " + nama + ". Pesanan Anda berhasil di Proses. \nBerikut data diri Anda : " +
                        "\nNama :" + nama +
                        "\nNo KTP: " + noktp +
                        "\nAlamat: " + alamat +
                        "\nUsia : " + tahun +
                        "\nJenis Kelamin : " + hasil +
                        "\nType Penumpang :" + jadi +
                        "\nAsal : " + spProvinsi1.getSelectedItem().toString() + " " + spKota1.getSelectedItem().toString());


            }
        });

    }
}
