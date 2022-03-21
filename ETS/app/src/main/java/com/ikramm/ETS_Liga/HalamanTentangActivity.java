package com.ikramm.ETS_Liga;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ikramm.ETS_Liga.R;

public class HalamanTentangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void Ayo_Pilih(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"gunawankaji47@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "I want to order ... ");
        i.putExtra(Intent.EXTRA_TEXT, "This is my Address");
        startActivity(i.createChooser(i, "Choose Email "));
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
