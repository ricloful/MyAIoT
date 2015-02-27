package com.ricloful.amuii.myaiot;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ScrollView;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    synchronized void imprimir(final String cad) {
        runOnUiThread(new Runnable() {
            public void run() {
                TextView ll = (TextView) findViewById(R.id.TextViewEstado);
                ll.append(cad);
                ScrollView ll1 = (ScrollView) findViewById(R.id.scrollView);
                ll1.fullScroll(View.FOCUS_DOWN);
            }});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hilo de registro
        new Thread(new Runnable() {
            public void run() {
                imprimir("Hilo de Registro");
                // inicio flowcloud
                // registro
                // obtener nombre
            }}
        ).start();

        //hilo de prueba
        new Thread(new Runnable() {
            public void run() {
                imprimirl("Hilo de Prueba");
                while (true){
                    try{
                        Thread.sleep(1000);

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                // registro
                // obtener nombre
            }}
        ).start();
    }

    void imprimirl (String cad){
        imprimir(cad+"\r\n");
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
