package edu.uh.findtheroot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Newton Raphson").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName("Bissection").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName("Regula Falsi").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName("Secant").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(1).withSelectable(false)
                )
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }
}
