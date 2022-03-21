package com.ikramm.ETS_Liga;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ikramm.ETS_Liga.R;
import com.ikramm.ETS_Liga.model.Klub;
import com.squareup.picasso.Picasso;

public class HalamanDetailActivity extends AppCompatActivity {
    TextView resultName,resultDesc,resultDetail;
    ImageView resultImgUrl;
    public static final String Key_HalamanUtamaActivity="Key_HalamanUtamaActivity";

    Klub klub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_detail);
        resultName=findViewById(R.id.nameDetail);
        resultDesc=findViewById(R.id.descklub);
        resultDetail=findViewById(R.id.descDetail);
        resultImgUrl=findViewById(R.id.imgDetail);

        klub = getIntent().getParcelableExtra(Key_HalamanUtamaActivity);

        //terakhir sampai sini
        resultName.setText(klub.getName());
        resultDesc.setText(klub.getDesc());
        resultDetail.setText(klub.getDetail());
        Picasso.get().load(klub.getImageUrl()).into(resultImgUrl);

    }

    public void Detail(View view) {
        Intent i = new Intent(HalamanDetailActivity.this,HalamanTentangActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;//super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.halamanutama){
            startActivity(new Intent(this, HalamanUtamaActivity.class));
        } else if (item.getItemId() == R.id.halamandetail) {
            startActivity(new Intent(this, HalamanDetailActivity.class));
        } else if (item.getItemId() == R.id.halamantentang) {
            startActivity(new Intent(this, HalamanTentangActivity.class));
        }
        return true;//super.onOptionsItemSelected(item);

    }
}
