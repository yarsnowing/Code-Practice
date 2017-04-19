
/*
题目描述(这个题目好像有些问题，待验证)
									
小赛非常喜欢玩游戏，最近喜欢上了一个接金币的游戏。在游戏中，使用帽子左右移动接金币，金币接的越多越好，但是金币掉到地上就不能再接了。为了方便问题的描述，我们把电脑屏幕分成11格，帽子每次能左右移动一格。现在给电脑屏幕如图标上坐标：

也就是说在游戏里，金币都掉落在0-10这11个位置。开始时帽子刚开始在5这个位置，因此在第一秒，帽子只能接到4,5,6这三个位置中其中一个位置上的金币。问小赛在游戏中最多可能接到多少个金币？（假设帽子可以容纳无穷多个金币）。

								
输入
输入数据有多组。每组数据的第一行为以正整数n (0＜n＜100000)，表示有n个金币掉在屏幕上上。在结下来的n行中，每行有两个整数x,T (0＜T＜100000),表示在第T秒有一个金币掉在x点上。同一秒钟在同一点上可能掉下多个金币。n=0时输入结束。输入数据以空格隔开
样例输入
7
6 3
8 2
9 3
7 1
6 2
5 1
7 2
输出
每一组输入数据对应一行输出。输出一个整数m，表示帽子最多可能接到m个金币。
样例输出
3
*/
import java.io.*;
import java.util.*;


public class Main {
   public static int[][] increaseCoin;
   public static int maxCoin=0;
   public static int maxTime=-1;
   public static void main(String[] args){
	   Scanner cin=new Scanner(System.in);
	   int n=cin.nextInt();
	   int[][] a=new int[n][2];
	   int[] coin=new int[11];
	   for(int i=0;i<11;i++){
		   coin[i]=-1;
	   }
	   coin[5]=0;//每次从上一次拥有最大金币数的位置开始找
	   for(int i=0;i<n;i++){
		   for(int j=0;j<2;j++){			   
			   a[i][j]=cin.nextInt();
			   if(a[i][1]>maxTime){
				   maxTime=a[i][1];
			   }
		   }
	   }
	   increaseCoin=new int[maxTime+1][11];
	   for(int i=0;i<n;i++){
		   increaseCoin[a[i][1]][a[i][0]]++;
	   }
	   calCoin(5,0,0);
	   System.out.println(maxCoin);  
   }
   public static void calCoin(int pos,int coin,int time){
	   if(maxCoin<coin)
		    maxCoin=coin;
	   if(time<maxTime){
		   calCoin(pos,coin+increaseCoin[time+1][pos],time+1);
		   if(pos>0)
				calCoin(pos-1,coin+increaseCoin[time+1][pos-1],time+1);
			if(pos<10)
				calCoin(pos+1,coin+increaseCoin[time+1][pos+1],time+1);
	   }
   }
}