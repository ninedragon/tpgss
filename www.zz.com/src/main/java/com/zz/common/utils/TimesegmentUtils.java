package com.zz.common.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimesegmentUtils {
//	
	public static void main(String[] args) {
//        Date date = new Date();
//        long thisTime = date.getTime();
//        List<Date> ds = test(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date last = null;
//        for (int i = 0; i <ds.size(); i++) {
//        	if(i == 0){
//        		last = ds.get(i);
//        	}else{
//        		last = ds.get(i-1);
//        	}
//        	long time1 = last.getTime();
//        	long time2 = ds.get(i).getTime();
//        	if(thisTime >= time1 && thisTime <= time2){
//        		System.out.println(sdf.format(thisTime)+"当前时间所处时间段位数:"+i);
//        	}
////        	System.out.println(sdf.format(last)+"===="+i+"===="+sdf.format(ds.get(i)));
//		}
		System.out.println(getTimesegment(new Date()));
    }
	
	public static int getTimesegment(Date date){
		int result = 0;
		 long thisTime = date.getTime();
	        List<Date> ds = test(date);
	        Date last = null;
	        for (int i = 0; i <ds.size(); i++) {
	        	if(i == 0){
	        		last = ds.get(i);
	        	}else{
	        		last = ds.get(i-1);
	        	}
	        	long time1 = last.getTime();
	        	long time2 = ds.get(i).getTime();
	        	if(thisTime >= time1 && thisTime <= time2){
	        		result = i;
	        		break;
	        	}
			}
		return result;
	}
	
    static List<Date> test(Date date) {
        Date start = dayStartDate(date);//转换为天的起始date
        Date nextDayDate = nextDay(start);//下一天的date
         
        List<Date> result = new ArrayList<Date>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (start.compareTo(nextDayDate) < 0) {
            result.add(start);
            //日期加5分钟
//            System.out.println(sdf.format(start));
            start = addFiveMin(start, 5);
        }
         
        return result;
    }
 
    private static Date addFiveMin(Date start, int offset) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.MINUTE, offset);
        return c.getTime();
    }
 
    private static Date nextDay(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
 
    private static Date dayStartDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
//    
//    public static void main(String[] args) {
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<Date> list = getTimeSegment(2014, 7, 1);
//        for (int j = 0; j < list.size(); j++) {
//        	 System.out.println(fmt.format(list.get(j))+"=="+j);
//		}
//    }
//     
//    public static List<Date> getTimeSegment(int year, int month, int day){
//        Calendar cal = Calendar.getInstance();
//        cal.set(year, month-1, day, 0, 0, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        long startTime = cal.getTimeInMillis();
//        cal.set(year, month-1, day, 23, 59, 59);
//        long endTime = cal.getTimeInMillis();
//        final int seg = 5*60*1000;//五分钟
//        ArrayList<Date> result = new ArrayList<Date>((int)((endTime-startTime)/seg+1));
//        for(long time = startTime;time<=endTime;time+=seg){
//            result.add(new Date(time));
//        }
//        return result;
//    }
}
