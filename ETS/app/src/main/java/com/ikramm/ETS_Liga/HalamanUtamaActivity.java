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
                "Total main                                       31\n" +
                        "Menang                                           21\n" +
                        "Seri                                                     6\n" +
                        "Kalah                                                 4\n" +
                        "Goal Masuk                                    52\n" +
                        "Goal Kemasukan                           22\n" +
                        "Selisih Goal                                    30"));
        listKlub.add(new Klub("Persib",
                "Peringkat 2 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/1/12/Logo_Persib.png/200px-Logo_Persib.png",
                "Total main                                       31\n" +
                        "Menang                                           20\n" +
                        "Seri                                                     6\n" +
                        "Kalah                                                 5\n" +
                        "Goal Masuk                                    46\n" +
                        "Goal Kemasukan                           20\n" +
                        "Selisih Goal                                    26"));
        listKlub.add(new Klub("Persebaya",
                "Peringkat 3 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/a/a1/Persebaya_logo.svg/200px-Persebaya_logo.svg.png",
                "Total main                                       31\n" +
                        "Menang                                           17\n" +
                        "Seri                                                     8\n" +
                        "Kalah                                                 6\n" +
                        "Goal Masuk                                    51\n" +
                        "Goal Kemasukan                           32\n" +
                        "Selisih Goal                                    19"));
        listKlub.add(new Klub("Bhayangkara",
                "Peringkat 4 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/f/fe/Logo_Bhayangkara_Solo_FC.png?20201128151858",
                "Total main                                       31\n" +
                        "Menang                                           17\n" +
                        "Seri                                                     8\n" +
                        "Kalah                                                 6\n" +
                        "Goal Masuk                                    51\n" +
                        "Goal Kemasukan                           32\n" +
                        "Selisih Goal                                    19"));
        listKlub.add(new Klub("Arema",
                "Peringkat 5 Klasemen Sementara Liga 1",
                "https://upload.wikimedia.org/wikipedia/id/thumb/4/40/Logo_Arema_FC_2017_logo.svg/200px-Logo_Arema_FC_2017_logo.svg.png",
                "Total main                                       31\n" +
                        "Menang                                           16\n" +
                        "Seri                                                10\n" +
                        "Kalah                                                 5\n" +
                        "Goal Masuk                                    38\n" +
                        "Goal Kemasukan                           22\n" +
                        "Selisih Goal                                    16"));
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
