/*
翻转数组

									题目描述
									
给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
将片段[l,r]反序后的数组是
a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。

								
输入
第一行数据是一个整数：n (1≤n≤105)，表示数组长度。
第二行数据是n个整数a[1], a[2], ..., a[n] (1≤a[i]≤109)。
样例输入
4
2 1 3 4
输出
输出“yes”，如果存在；否则输出“no”，不用输出引号。
样例输出
yes
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt())
		{
			int len = scanner.nextInt();
			int[] array = new int[len];
			int[] copy = new int[len];
			for(int i=0;i<len;i++)
			{
				array[i] = scanner.nextInt();
				copy[i] = array[i];
			}
			Arrays.sort(copy);
			int left = 0,right = len-1;
			while(left<len && copy[left]==array[left]) left++;
			while(right>=0 && copy[right]==array[right]) right--;
			
				
			int i;
			for(i=0;i<=right-left;i++)
			{
				if(copy[left+i]!=array[right-i])
					break;
			}
			if(i>right-left)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}