package com.example.testflousifinale;

import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class depense {
    int id ;
    public static float total ;
    private String achat ;
    private Float prix ;
    String date ;

    public depense(String achat, Float prix) {
        this.achat = achat;
        this.prix = prix;
        String pattern = "MM/dd/yyyy HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();

        date = df.format(today);

    }

    public String getAchat() {
        return achat;
    }

    public Float getPrix() {
        return prix;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
}
