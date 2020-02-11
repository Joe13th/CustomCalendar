package com.joe13th.joe13.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.joe13th.customcalender.View;
import com.joe13th.customcalender.DayClickListner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View custom;
    int[] DecDisableDays = new int[]{14, 20, 5, 6};
    List<Integer> offDays = new ArrayList<>();

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DayClickListner event) {
        Toast.makeText(MainActivity.this, String.valueOf(event.getDayModel().getDayValue()), Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom = (View) findViewById(R.id.custom);
        custom.getPropertySetters().setStFr(true);

        //   custom.getPropertySetters().setSunOff(true);

        custom.getPropertySetters().setSeperatorColor("#FFFFFF");
        custom.getPropertySetters().setCalendarContainerHeight(300);
        custom.getPropertySetters().setWeekColor("#EB943E");
        custom.getPropertySetters().setDaysLeftPadding(50);
        custom.getPropertySetters().setDECdays(DecDisableDays);
        custom.getPropertySetters().setSelectedDayColor("#FFFFFF");
        custom.getPropertySetters().setArabicSupport(true);
        custom.setRotationY(180);


        custom.montsViewPagerAdapter.notifyDataSetChanged();


    }


}
