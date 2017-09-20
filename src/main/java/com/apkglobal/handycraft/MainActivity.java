package com.apkglobal.handycraft;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    Button btn_access, btn_about, btn_cloth, btn_decor, btn_call, btn_web, btn_mail, btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar;
       // toolbar = (Toolbar) findViewById(toolbar);
      //  setSupportActionBar(toolbar);

        //typecast
        btn_about = (Button) findViewById(R.id.btn_about);
        btn_access = (Button) findViewById(R.id.btn_access);
        btn_decor = (Button) findViewById(R.id.btn_decor);
        btn_cloth = (Button) findViewById(R.id.btn_cloth);
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_share = (Button) findViewById(R.id.btn_share);
        btn_mail = (Button) findViewById(R.id.btn_mail);


        //to click on button
        btn_about.setOnClickListener(this);
        btn_access.setOnClickListener(this);
        btn_decor.setOnClickListener(this);
        btn_cloth.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_mail.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/




   /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
}


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_about:
                Intent home = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(home);
                break;

            case R.id.btn_access:
                Intent about = new Intent(MainActivity.this, AccessoriesActivity.class);
                startActivity(about);
                break;

            case R.id.btn_decor:
                Intent career = new Intent(MainActivity.this, DecorActivity.class);
                startActivity(career);
                break;

            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:9165771646"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);
                /*to use runtime permissions for calling

                 */


                break;

            case R.id.btn_share:
                Intent share=new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Try the first android app of Anshika Jain" +
                        ":Crafterina"+"https://play.google.com/store/apps/details?id=com.apkglobal.crafterina");
                share.setType("text/plain");

                startActivity(Intent.createChooser(share,"share app via:"));
                break;

            case R.id.btn_cloth:
                Intent web=new Intent(MainActivity.this,ClothingActivity.class);
                startActivity(web);
                break;

            case R.id.btn_mail:
                Intent mail=new Intent(Intent.ACTION_SEND);
                //  mail.setData(Uri.parse("mailTo:"));
                //mail.setType("text/plain");

                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{"anshikajainj@gmail.com","jainanshika083@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT,"Amazing crafterina app");
                mail.putExtra(Intent.EXTRA_TEXT,"Your app is very nice .I want to sell my craft items on your App.Do have a look on their images attached with this mail.");
                mail.setType("email/rfc822");

                startActivity(Intent.createChooser(mail,"Email to send"));

                //startActivity(mail);
                break;

        }

    }
    }

