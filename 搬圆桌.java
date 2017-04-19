
/*
搬圆桌

                  题目描述
                  
小A有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1, y1)。每次移动一步，小A都得在圆桌边界上固定一个点，然后将圆桌绕这个点旋转。 问最少需要几步才能把圆桌移到目标位置？


                
输入
一行五个整数r,x,y,x1,y1( 1 ≤ r ≤ 100000,  - 100000 ≤ x, y, x1, y1 ≤ 100000)。
样例输入
2 0 0 0 4

输出
一个整数，表示最少需要移动的步数。

样例输出
1


*/
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
      long r=sc.nextInt();
      long x=sc.nextInt();
      long y=sc.nextInt();
      long x1=sc.nextInt();
      long y1=sc.nextInt();
      
      double distance=Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
      long result=(long)distance/(2*r);
      if(distance%r==0)
        result=result;
      else
        result++;
      System.out.println(result);
    }
}