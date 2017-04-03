/*
分苹果
题目描述
									
果园里有堆苹果，N（1＜N＜9）只熊来分。第一只熊把这堆苹果平均分为N份，
多了一个，它把多的一个扔了，拿走了一份。第二只熊把剩下的苹果又平均分成N份，
又多了一个，它同样把多的一个扔了，拿走了一份，第三、第四直到第N只熊都是这么做的，问果园里原来最少有多少个苹果？


								
输入
输入1个整数，表示熊的个数。它的值大于1并且小于9。
样例输入
5
输出
为1个数字，表示果园里原来有的苹果个数。
样例输出
3121
*/


public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt())
		{
			int n = scanner.nextInt();
			int sum = 1;
			for(int i=0;i<n;i++)
			{
				sum = sum*n;
			}
			System.out.println(sum-n+1);
		}
	}

}


//方法二
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
	     int N=sc.nextInt();  //熊的数量
	      
	     int sum=0;
	     for(int num=1;;num++){
	    	 sum=num;
	       int i=0;
	       for(i=N;i>0;i--){
	      	if(num%N==1){
	        	num=(N-1)*(num-1)/N;
	        }else{
	        	break;
	        }
	       }
	       num=sum;
	       if(i==0){
	         break;
	       }
	       else{
	         continue;
	       }
	     }
	      System.out.println(sum);
		
	}

}

#include <iostream>
using namespace std;
int main(int argc, char *argv[])
{
	long long n,sum;//分别表示熊的个数和苹果最少个数
	cin>>n;
	
	//通过数学递推式， sum=（x+n-1）*((n/(n-1))^n) -n+1;其中x为最后一个熊分完后剩余的苹果数目
	//故x+n-1是(n-1)^n的整数倍。最小为1倍，即x+n-1=(n-1)^n.
	//故sum=n^n-n+1;
	sum=1;
	for(int i=0;i<n;i++){
		sum*=n;
	}
	sum=sum-n+1;
	cout<<sum<<endl;
	
	return 0;
}