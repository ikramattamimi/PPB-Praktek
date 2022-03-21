package com.ikramm.ETS_Liga;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

    import com.ikramm.ETS_Liga.model.DataKlub;
    import com.ikramm.ETS_Liga.R;
    import com.ikramm.ETS_Liga.model.Klub;

import java.util.ArrayList;
import java.util.List;

public class HalamanUtamaActivity extends AppCompatActivity implements DataKlub.KlubClickListener {
    public static final String Key_HalamanUtamaActivity="Key_HalamanUtamaActivity";

    public RecyclerView rv;
    public DataKlub dataKlub;
    public RecyclerView.LayoutManager layoutManager;
    public List<Klub> listKlub = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        rv = findViewById(R.id.rvKlub);
        listKlub.add(new Klub("Bali United",
                "Peringkat 1 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/5/5e/Bali_United_logo.svg/200px-Bali_United_logo.svg.png",
                "Bali United F.C. (sebelumnya bernama Persisam Putra Samarinda) merupakan sebuah klub sepak bola Indonesia," +
                        "yang bermarkas Stadion Kapten I Wayan Dipta, Kabupaten Gianyar, Provinsi Bali, Indonesia"));
        listKlub.add(new Klub("Persib",
                "Peringkat 2 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/1/12/Logo_Persib.png/200px-Logo_Persib.png",
                " klub sepak bola Indonesia yang berdiri pada 14 Maret 1933, berbasis di Bandung, Jawa Barat. " +
                        "Persib saat ini bermain di Liga 1 Indonesia. Julukan mereka adalah Maung Bandung dan Pangeran Biru "));
        listKlub.add(new Klub("Persebaya",
                "Peringkat 3 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/a/a1/Persebaya_logo.svg/200px-Persebaya_logo.svg.png",
                "APersebaya adalah sebuah klub sepak bola profesional di Indonesia yang berbasis di Surabaya dan berdiri pada 18 Juni 1927 dengan nama asalnya adalah Soerabajasche Indonesische Voetbal Bond (SIVB). " ));
        listKlub.add(new Klub("Bhayangkara",
                "Peringkat 4 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/f/fe/Logo_Bhayangkara_Solo_FC.png?20201128151858",
                "Bhayangkara Football Club adalah sebuah tim sepak bola Indonesia yang dimiliki oleh Polri yang berbasis di Jakarta Selatan. " +
                        " Klub ini bermain di Liga 1. "));
        listKlub.add(new Klub("Arema",
                "Peringkat 5 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/4/40/Logo_Arema_FC_2017_logo.svg/200px-Logo_Arema_FC_2017_logo.svg.png",
                "Arema Football Club, biasa disebut dengan Arema adalah sebuah klub sepak bola profesional yang berasal dari Malang, Jawa Timur, Indonesia.  " +
                        "Arema berkompetisi di Liga 1 yang merupakan kasta tertinggi sepak bola Indonesia. "));
        dataKlub = new DataKlub(listKlub);
        dataKlub.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(dataKlub);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Klub klub = listKlub.get(position);
        Intent apkklub = new Intent(HalamanUtamaActivity.this,HalamanDetailActivity.class);
        apkklub.putExtra(Key_HalamanUtamaActivity,klub);
        startActivity(apkklub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;//super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.halamanutama:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamandetail:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamantentang:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;//super.onOptionsItemSelected(item);

    }
}
