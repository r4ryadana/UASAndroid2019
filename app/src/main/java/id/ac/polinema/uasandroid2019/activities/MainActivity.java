package id.ac.polinema.uasandroid2019.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import id.ac.polinema.uasandroid2019.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout mlinePilGan, mLineEssay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlinePilGan = (LinearLayout) findViewById(R.id.linePilGan);
        mLineEssay = (LinearLayout) findViewById(R.id.lineEssay);

        mlinePilGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, KuisPilihanGanda.class);
                startActivity(i);
            }
        });

        mLineEssay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, KuisEssay.class);
                startActivity(i);
            }
        });
    }

}
