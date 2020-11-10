package _4_lop_va_doi_tuong.bai_tap.thoi_gian;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch(){
        startTime = LocalTime.now();
    }
    public StopWatch(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public void start(){
        startTime = LocalTime.now();
    }
    public void end(){
        endTime = LocalTime.now();
    }
    public int getElapsedTime(){
        int miliSecond = ((endTime.getHour()-startTime.getHour())*3600 + (endTime.getMinute()-startTime.getMinute())*60 + (endTime.getSecond()-startTime.getSecond())*1000);
        return miliSecond;
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        System.out.println(watch.getEndTime());
    }
}
