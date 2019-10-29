package Notifi.com;

import android.app.Notification;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NotificationListener extends NotificationListenerService {
    NotiData notidata;
    public final static String TAG = "=====";
    ArrayList<NotiData> dataArrayList = new ArrayList<>();
    MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataArrayList);

    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate():: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy():: ");
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        Log.e(TAG, "onListenerConnected():: ");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        // 새로운 알림이 생성되었을 때
        super.onNotificationPosted(sbn);
        Log.e(TAG, "onNotificationPosted()");

        Notification notification = sbn.getNotification();
        Bundle extras = sbn.getNotification().extras;






        String contentTitle = extras.getString(Notification.EXTRA_TITLE);
        CharSequence contentText = extras.getCharSequence(Notification.EXTRA_TEXT);
        CharSequence subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);
        CharSequence bigText = extras.getCharSequence(Notification.EXTRA_BIG_TEXT);
        CharSequence bigContentTitle = extras.getCharSequence(Notification.EXTRA_TITLE_BIG);



        Icon smallIcon = notification.getSmallIcon();
        Icon largeIcon = notification.getLargeIcon();

        Log.e(TAG, "NotiPosted::  " +
                " / id : " + sbn.getId() +
                " / bigContentTitle : " + bigContentTitle +
                " / bigText : " + bigText +
                " / contentText : " + contentText +
                " / subText : " + subText +
                " / contentTitle : " + contentTitle +
                " / icon : " + smallIcon.getResId() +
                " / packageName : " + sbn.getPackageName()
        );


        NotiData data = new NotiData();
        data.setApp_name(sbn.getPackageName());
        data.setTitle_of(contentTitle);
        data.setContent_of(contentText.toString());
        data.setTime_of("now");
        //data.setResId(listResId.get(i));
        // 각 값이 들어간 data를 adapter에 추가
        adapter.addItem(data);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

        // 알림이 지워졌을 때
        super.onNotificationRemoved(sbn);
        Log.e(TAG, "onNotificationRemoved():: ");

        Log.e(TAG, "NotiIRemoved:: " +
                " packageName: " + sbn.getPackageName() +
                " id: " + sbn.getId());
    }
}
