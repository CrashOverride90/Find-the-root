package edu.uh.findtheroot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "localPrefs";
    private static final String TAG = "MainActivity";
    Button eqBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final SharedPreferences.Editor editor = settings.edit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eqBuilder = (Button) findViewById(R.id.button);
        eqBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("algorithm", "newton");
                editor.commit();
                launchEquationBuilder();
            }
        });

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Newton Raphson").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(1).withSelectable(true),
                        new PrimaryDrawerItem().withName("Bisection").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(2).withSelectable(true),
                        new PrimaryDrawerItem().withName("Regula Falsi").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(3).withSelectable(true),
                        new PrimaryDrawerItem().withName("Secant").withDescription("")
                                .withIcon(GoogleMaterial.Icon.gmd_code).withIdentifier(4).withSelectable(true)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Log.d(TAG, "position: " + position);
                        switch (position) {
                            case 0:
                                editor.putString("algorithm", "newton");
                            case 1:
                                editor.putString("algorithm", "bisection");
                            case 2:
                                editor.putString("algorithm", "regulaFalsi");
                            case 3:
                                editor.putString("algorithm", "secant");
                        }
                        editor.commit();
                        launchEquationBuilder();
                        return true;
                    }
                })
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    private void launchEquationBuilder() {
        Intent intent = new Intent(this, EquationBuilderUI.class);
        startActivity(intent);
    }
}
