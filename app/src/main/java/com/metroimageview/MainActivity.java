package com.metroimageview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private MetroImageView metroImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);

        metroImageView = (MetroImageView) findViewById(R.id.metroImageView);
        metroImageView.setAnimationSpeed(1000);
        metroImageView.setStartDelay(3000);
        metroImageView.setAnimationsToUse(Defaults.FADE, Defaults.SLIDE_DOWN, Defaults.SLIDE_UP);
        List<Uri> uris = new ArrayList<>();
        uris.add(Uri.parse("http://i.telegraph.co.uk/multimedia/archive/02674/BANANA_2674767b.jpg"));
        uris.add(Uri.parse("http://www.prowallpapers.ro/wallpapers/ananas_2-1600x1200.jpg"));
        uris.add(Uri.parse("http://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Strawberry_BNC.jpg/320px-Strawberry_BNC.jpg"));
        metroImageView.setImagesUrls(uris);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
