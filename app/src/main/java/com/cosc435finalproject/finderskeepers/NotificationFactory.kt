package com.cosc435finalproject.finderskeepers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationFactory(
    var context: Context,
    var title: String,
    var message: String,
) {
    val channelid = "FindersKeepersChannel"
    val channelname = "FindersKeepers"
    val notificationmanager = context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationchannel: NotificationChannel
    lateinit var notificationbuilder: NotificationCompat.Builder

    fun ShowNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationchannel = NotificationChannel(channelid, channelname, NotificationManager.IMPORTANCE_DEFAULT)
            notificationmanager.createNotificationChannel(notificationchannel)
        }

        val intent = Intent(context, MainActivity::class.java)
        val pendingintent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        notificationbuilder = NotificationCompat.Builder(context, channelid)
        notificationbuilder.setSmallIcon(R.drawable.finderskeeperslogo)
        notificationbuilder.addAction(R.drawable.finderskeeperslogo, "Continue shopping", pendingintent)
        notificationbuilder.setContentTitle(title)
        notificationbuilder.setContentText(message)
        notificationbuilder.setAutoCancel(true)
        notificationmanager.notify(100, notificationbuilder.build())
    }
}