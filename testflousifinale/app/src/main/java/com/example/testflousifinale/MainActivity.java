package com.example.testflousifinale;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
 ListView list;


  public static adapter depada;
  public static DBadapter dbadap;
  public static ArrayList<depense> base ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbadap = new DBadapter(this);
        base=new ArrayList<depense>();
        base= dbadap.afficher();
       list =findViewById(R.id.liste);
        depada =new adapter(this,R.layout.depense_item,base);

       list.setAdapter(depada);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Supprimer")
                        .setMessage("Voullez vous supprimer ce depences  de la liste  ? ")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dbadap.remove(base.get(position).getId());
                                base= dbadap.afficher();

                                depada =new adapter(MainActivity.this,R.layout.depense_item,base);

                                list.setAdapter(depada);
                                Toast.makeText(MainActivity.this, "depence supprimé ", Toast.LENGTH_SHORT).show(); }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }

        }     );


    }
    public static long getAppFirstInstallTime(Context ctx){
        PackageInfo packageInfo;
        try {
            if(Build.VERSION.SDK_INT>8/*Build.VERSION_CODES.FROYO*/ ){
                packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
                return packageInfo.firstInstallTime;
            }else{
                //firstinstalltime unsupported return last update time not first install time
                ApplicationInfo appInfo = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return new File(sAppFile).lastModified();
            }
        } catch (PackageManager.NameNotFoundException e) {
            //should never happen
            return 0;
        }
    }
    public static String getDate(long milliSeconds, String df) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(df);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true ;
    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        base= dbadap.afficher();
        depada =new adapter(this,R.layout.depense_item,base);

        list.setAdapter(depada);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId()==R.id.ajouter)
        {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class); startActivity(intent);
        }

        if( item.getItemId()==R.id.total)
        {
            Intent intent = new Intent(MainActivity.this, Main3Activity.class); startActivity(intent);
        }
        return true ;
    }





}
