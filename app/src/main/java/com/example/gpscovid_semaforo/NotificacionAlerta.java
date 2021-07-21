package com.example.gpscovid_semaforo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificacionAlerta extends Application {
    public static final String CHANNEL_1_ID = "channel 1";

    @Override
    public void onCreate() {
        super.onCreate();
        //Llamada del metodo de notificaciones por canal
        createNotificationChannel();
    }

    //Notificaciones por canal
    public void createNotificationChannel(){

        //Si la version de API es mayor al API O es decir Oreo
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //notificacion del canal
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("Notificacion de nivel de contagio");

            //Creacion de notificaciones en el sistema (Dispositivo)
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }
}