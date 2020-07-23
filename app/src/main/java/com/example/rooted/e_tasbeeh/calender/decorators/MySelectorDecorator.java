package com.example.rooted.e_tasbeeh.calender.decorators;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.example.rooted.e_tasbeeh.R;
import com.example.rooted.e_tasbeeh.calender.CalendarDay;
import com.example.rooted.e_tasbeeh.calender.DayViewDecorator;
import com.example.rooted.e_tasbeeh.calender.DayViewFacade;



/**
 * Use a custom selector
 */
public class MySelectorDecorator implements DayViewDecorator {

    private final Drawable drawable;

    public MySelectorDecorator(Activity context) {
        drawable = context.getResources().getDrawable(R.drawable.my_selector);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }
}
