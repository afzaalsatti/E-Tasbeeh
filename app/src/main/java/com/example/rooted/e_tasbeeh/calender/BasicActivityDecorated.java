package com.example.rooted.e_tasbeeh.calender;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rooted.e_tasbeeh.PrayerTime;
import com.example.rooted.e_tasbeeh.R;
import com.example.rooted.e_tasbeeh.SharedPrefsReader;
import com.example.rooted.e_tasbeeh.calender.decorators.EventDecorator;
import com.example.rooted.e_tasbeeh.calender.decorators.HighlightWeekendsDecorator;
import com.example.rooted.e_tasbeeh.calender.decorators.MySelectorDecorator;
import com.example.rooted.e_tasbeeh.calender.decorators.OneDayDecorator;
import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;


/**
 * Shows off the most basic usage
 */
public class BasicActivityDecorated extends AppCompatActivity implements OnDateSelectedListener {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();

ImageView back;
    MaterialHijriCalendarView widget;
    TextView textView,caldate,hijridate;
    List<CalendarDay> specialDays;
    Date date;
    SharedPreferences mySharedPreferences = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySharedPreferences = getSharedPreferences("Test PREFS", Activity.MODE_PRIVATE);
        if(new SharedPrefsReader(mySharedPreferences).enableNight())
        {
            setContentView(R.layout.activity_basic_dark);

        }else {

            setContentView(R.layout.activity_basic);
        }
        widget=findViewById(R.id.calendarView);
        textView=findViewById(R.id.textView);
         back=findViewById(R.id.back);
         caldate=findViewById(R.id.date);
         hijridate=findViewById(R.id.hijridate);

        widget.setOnDateChangedListener(this);
        widget.setShowOtherDates(MaterialHijriCalendarView.SHOW_ALL);
widget.setTitleMonths(R.array.custom_months);
widget.setWeekDayLabels(R.array.custom_weekdays);
        Calendar calendar = Calendar.getInstance();
        widget.setSelectedDate(calendar.getTime());
caldate.setText("Date : "+calendar.get(5)+"/"+(calendar.get(2)+1)+"/"+calendar.get(1));
        calendar.set(2000, Calendar.JANUARY, 1);
        widget.setMinimumDate(calendar.getTime());

        calendar.set(2050, Calendar.DECEMBER, 31);
        widget.setMaximumDate(calendar.getTime());

        widget.addDecorators(
                new MySelectorDecorator(this),
                new HighlightWeekendsDecorator(),
                oneDayDecorator
        );
       date= widget.getSelectedDate().getDate();
        String dat=widget.getSelectedDate().getDay()+"/"+widget.getCurrentDate().getMonth()+"/"+widget.getCurrentDate().getYear();

       hijridate.setText("Islamic Date : "+dat);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(), PrayerTime.class);
        startActivity(i);
    }
});
        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
    }

    @Override
    public void onDateSelected(@NonNull MaterialHijriCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
        if(this.date==date.getDate())
        oneDayDecorator.setDate(date.getDate());
        //widget.invalidateDecorators();

        String dat=date.getDay()+" - "+date.getMonth()+" - "+date.getYear();
        textView.setText("Selected Date : "+ dat);

        if(specialDays !=null && specialDays.contains(date.getDay()))
        {
            Toast.makeText(this,"Special Day",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Simulate an API call to show how to add decorators
     */
    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                UmmalquraCalendar ummalquraCalendar = new UmmalquraCalendar();
                ummalquraCalendar.setTime(calendar.getTime());
                CalendarDay day = CalendarDay.from(ummalquraCalendar);
                dates.add(day);
                calendar.add(Calendar.DATE, 5);
            }

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }
            specialDays=calendarDays;
            widget.addDecorator(new EventDecorator(Color.BLUE, calendarDays));
        }
    }
}
