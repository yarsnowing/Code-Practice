/*
题目描述
									
在经济、科技日益发达的今天，人们对时间的把握越来越严格，对于一个一定影响力的公司的高管来说，他可能要将自己的行程提前安排到下个月。对于普通人来说，他也可能将几天之后的安排已经提前做好。
请设计一个程序计算出今天距离未来的某一天还剩多少天。
假设今天是2015年10月18日。

								
输入
输入一个日期格式为yyyy-MM-dd，不考虑日期是否小于今天。
样例输入
2015-10-19
输出
输出一个数字表示今天（2015年10月18日）距离该日期还剩多少天。
样例输出
1
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date date = df.parse(sc.nextLine());
		Date now =df.parse("2015-10-18");
		long l=date.getTime()-now.getTime();
		long day=l/(24*60*60*1000);
		System.out.println(day);
	}

}
//方法二 ps 
public class Demo{
	
	public static  void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int year,month,day,nowYear;
		String string=scanner.nextLine();
		String[] chars=string.split("-");
		year=Integer.parseInt(chars[0]);
		month=Integer.parseInt(chars[1]);
		day=Integer.parseInt(chars[2]);
	
		int countDays=0;
		int countDays1=calculteDayToNextYear(2015, 10, 18);
		int countDays2=calculteDayToNextYear(year, month, day);
	
		if((year/4==0&&year/100!=0)||year/400==0)
	 		
		 countDays=countDays1+366-countDays2+1;
		else {
			 countDays=countDays1+365-countDays2+1;
		}
		 for (int i=2015+1;i<year ; ++i) {
			 	countDays+=365;
			 	if((i/4==0&&i/100!=0)||i/400==0)
			 		countDays+=1;

			 }
		 System.out.println(countDays+"");
		//System.out.println(calculteDayToNextYear(year, month, day)+"");
		
	}
	
	public static int calculteDayToNextYear(int year,int month,int day){
		 Map<Integer,Integer> months=new HashMap<Integer,Integer>();
			 for (int i=1;i<=7 ;++i ) {
		 	if(i/2!=0)
		 		months.put(i,31);
		 	else
		 		months.put(i,30);
		 }
		 
		 for (int i=8;i<=12 ;++i ) {
		 	if(i/2!=0)
		 		months.put(i,30);
		 	else
		 		months.put(i,31);
		 }
		 for (int i=month+1;i<=12 ;++i ) {
		 	countDays+=months.get(i);
		 }
          countDays+=months.get(month)-day;
		return countDays;


		}
}

\\方法3
#include<iostream>
using namespace std;
int years[2]={365,366};
int months[2][12]={31,28,31,30,31,30,31,31,30,31,30,31,
                         31,29,31,30,31,30,31,31,30,31,30,31};
int leapyear(int year){
   return ((year%100)&&!(year%4))||!(year%400);
}
int inline countyear(int year){
    int days=0;
	for(int i=2015;i<year;i++)
	   days+=years[leapyear(i)];
	return days;
}
int inline countmonth(int year,int month){
   int days=0;
   for(int i=1;i<month;i++){
      days+=months[leapyear(year)][i-1];
   }
   return days;
}
int inline countdays(int days){
   return days-1;
}
int inline leftdays(int year,int month,int day){
   return countyear(year)+countmonth(year,month)+countdays(day);
}
int main(){
   int year,month,days;
   scanf("%d-%d-%d",&year,&month,&days);
   printf("%d\n",leftdays(year,month,days)-leftdays(2015,10,18));
   return 0;
}