package id.ac.polinema.uasandroid2019.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.uasandroid2019.R;

import static android.R.attr.x;

public class KuisEssay extends AppCompatActivity {
    TextView mtvSkor2,mtvSoal2;
    ImageView mivGambar;
    EditText medtJawaban;
    Button mbtnSubmit2;
    int x=0;
    int arr;
    int skor;
    String jawaban;

    SoalEssay essay = new SoalEssay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_essay);

        mtvSkor2 = (TextView) findViewById(R.id.tvSkor2);
        mtvSoal2 = (TextView) findViewById(R.id.tvSoal2);
        mivGambar = (ImageView) findViewById(R.id.ivGambar);
        medtJawaban = (EditText) findViewById(R.id.edtJawaban);
        mbtnSubmit2 = (Button) findViewById(R.id.btnSubmit2);

        setKonten();

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = essay.pertanyaan.length;
        if(x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(KuisEssay.this, HasilSkoring.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir2
            i.putExtra("skorAkhir2",jumlahSkor);
            i.putExtra("activity","Essay");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalEssay
            mtvSoal2.setText(essay.getPertanyaan(x));
            ubahGambar();
            jawaban = essay.getJawabanBenar(x);
        }
        x++;
    }

    public void ubahGambar(){
        Resources res = getResources();
        String mPhoto = essay.getStringGambar(x);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mivGambar.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 20;
                mtvSkor2.setText(""+skor);	//mtvSkor2 diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                mtvSkor2.setText(""+skor);
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
