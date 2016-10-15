package id.sch.smktelkom_mlg.tugas01.xiirpl1028.pemesanantiket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNoKTP;
    EditText etAlamat;
    EditText etTahun;
    EditText etTanggal;
    EditText etJam;
    TextView tvHasil;
    RadioGroup rgStatus;
    CheckBox cbDW, cbAN, cbBS, cbEX, cbEK;
    Spinner spProvinsi, spProvinsi2, spKota, spKota2;
    Button bOK;
    String[][] arKota = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan", "Jakarta Timur", "Jakarta Utara"},
            {"Bandung", "Cirebon", "Bekasi"}, {"Semarang",
            "Magelang", "Yogyakarta", "Surakarta"}, {"Surabaya", "Malang", "Blitar", "Kediri",
            "Banyuwangi", "Jombang", "Nganjuk", "Ponorogo"}};

    ArrayList<String> listKota = new ArrayList<>();
    ArrayAdapter<String> adapter;


    String[][] arKota2 = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan", "Jakarta Timur", "Jakarta Utara"},
            {"Bandung", "Cirebon", "Bekasi"}, {"Semarang",
            "Magelang", "Yogyakarta", "Surakarta"}, {"Surabaya", "Malang", "Blitar", "Kediri",
            "Banyuwangi", "Jombang", "Nganjuk", "Ponorogo"}};
    ArrayList<String> listKota2 = new ArrayList<>();
    ArrayAdapter<String> adapter2;


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
        cbBS = (CheckBox) findViewById(R.id.checkBoxB);
        cbEX = (CheckBox) findViewById(R.id.checkBoxX);
        cbEK = (CheckBox) findViewById(R.id.checkBoxE);
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi1);
        spProvinsi2 = (Spinner) findViewById(R.id.spinnerProvinsi2);
        spKota = (Spinner) findViewById(R.id.spinnerKota1);
        spKota2 = (Spinner) findViewById(R.id.spinnerKota2);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        etJam = (EditText) findViewById(R.id.editTextJam);
        bOK = (Button) findViewById(R.id.buttonOK);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKota2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota2.setAdapter(adapter2);


        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spProvinsi2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                listKota2.clear();
                listKota2.addAll(Arrays.asList(arKota2[pos]));
                adapter2.notifyDataSetChanged();
                spKota2.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> AdapterView) {

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

                String maka = "";
                int readlen = jadi.length();
                if (cbBS.isChecked()) maka += cbBS.getText() + "\n";
                if (cbEX.isChecked()) maka += cbEX.getText() + "\n";
                if (cbEK.isChecked()) maka += cbEK.getText() + "\n";

                if (maka.length() == readlen) maka += "Tidak ada Pilihan";

                tvHasil.setText(maka);

                String nama = etNama.getText().toString();
                String noktp = etNoKTP.getText().toString();
                String alamat = etAlamat.getText().toString();
                String tahun = etTahun.getText().toString();
                String tanggal = etTanggal.getText().toString();
                String jam = etJam.getText().toString();
                tvHasil.setText(" Terimakasih " + nama + ". Pesanan Anda berhasil di Proses. \nBerikut data diri Anda : " +
                        "\nNama             :" + nama +
                        "\nNo KTP           : " + noktp +
                        "\nAlamat           : " + alamat +
                        "\nUsia             : " + tahun +
                        "\nJenis Kelamin    : " + hasil +
                        "\nType Penumpang   :" + jadi +
                        "\nAsal             : " + spProvinsi.getSelectedItem().toString() + " " + spKota.getSelectedItem().toString() +
                        "\nTujuan           : " + spProvinsi2.getSelectedItem().toString() + " " + spKota2.getSelectedItem().toString() +
                        "\nTanggal          : " + tanggal +
                        "\nJam              : " + jam +
                        "\nKelas            : " + maka);

            }
        });

    }
}
