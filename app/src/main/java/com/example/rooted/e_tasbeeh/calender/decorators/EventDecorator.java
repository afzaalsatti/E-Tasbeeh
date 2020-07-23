package com.example.rooted.e_tasbeeh.calender.decorators;

;
import com.example.rooted.e_tasbeeh.calender.CalendarDay;
import com.example.rooted.e_tasbeeh.calender.DayViewDecorator;
import com.example.rooted.e_tasbeeh.calender.DayViewFacade;
import com.example.rooted.e_tasbeeh.calender.spans.DotSpan;


import java.util.HashSet;
import java.util.List;

/**
 * Decorate several days with a dot
 */
public class EventDecorator implements DayViewDecorator {

    private int color;
    private HashSet<CalendarDay> dates;

    public EventDecorator(int color, List<CalendarDay> dates) {
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, color));
    }
}
