package id.ac.polinema.uasandroid2019.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import id.ac.polinema.uasandroid2019.R;

public class KuisPilihanGanda extends AppCompatActivity {
    //membuat variabel baru sesuai tipe
    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3;
    Button mbtnSubmit;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;
    String jawaban;

    SoalPilihanGanda soalPG = new SoalPilihanGanda();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pilihan_ganda);

        mtvSkor = (TextView) findViewById(R.id.tvSkor);
        mtvSoal = (TextView) findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mbtnSubmit = (Button) findViewById(R.id.btnSubmit);

        mtvSkor.setText(""+skor);
        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.pertanyaan.length;
        if(x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(KuisPilihanGanda.this, HasilSkoring.class);
            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{
            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText(""+skor);	//mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()){
            if(mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }
}
