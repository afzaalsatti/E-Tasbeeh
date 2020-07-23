package com.example.rooted.e_tasbeeh.calender;

/**
 * The callback used to indicate the user changes the displayed month
 */
public interface OnMonthChangedListener {

    /**
     * Called upon change of the selected day
     *
     * @param widget the view associated with this listener
     * @param date   the month picked, as the first day of the month
     */
    void onMonthChanged(MaterialHijriCalendarView widget, CalendarDay date);
}
