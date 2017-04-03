/*
当你学一些可视化程序设计语言时，老师经常会让你设计并且编程做出一个计算器，这时也许你会仿照windows系统自带的计算器外观和功能去设计，
但是现在老师要你多做出一个有新功能的计算器，实现当输入一个数时，能够将这个数分解成一个或多个素因子乘积的形式，并按素因子的大小排列显示出来。
大家对计算器中数的表示应该很清楚的。下面显示出了0 — 9这十个数字的表示形式。每个数字都占据5 * 3大小的字符区域

你能实现这个新功能吗？试试看吧！

								
输入
输入有多组测试数据，每组包括一个正整数n（1 < n <= 1000000)。
样例输入
10
2
输出
对于每个数，将它分解成若干个素数乘积的形式，并按从小到大的顺序输出，素因子之间用“ * ”的形式连接。
样例输出
 -     -
  |   |
 -  *  -
|       |
 -     -
 
 -
  |
 -
|
 -


*/


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			List<Integer> list = new ArrayList<Integer>();
			Stack<Integer> stack = new Stack<>();
			int num = sc.nextInt();
			boolean flag = true;
			int temp = num;
			int length = 0;
			for (int i = 2; i <= temp; i++) {
				while (temp % i == 0) {
					list.add(length,i);
					length ++;
					temp = temp /i;
				}
			}
			
			for(int i=1; i<=5; i++){
				for(int j=0; j<length; j++){
					int nu = list.get(j);
					while(nu/10 > 0){
						//printNum(nu%10, i);
						stack.push(nu%10);
						nu=nu/10;
					}
					stack.push(nu);
					if(j>0){
					if(i==3)
						System.out.print("*");
					else {
						System.out.print(" ");
					}
					}
					while(!stack.isEmpty()){
						printNum(stack.pop(), i);
					}
				}
				System.out.println();
			}

		}
	}

	public static void printNum(int num, int n) {
		switch (num) {
		case 0:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("| |");
				break;
			case 3:
				System.out.print("   ");
				break;
			case 4:
				System.out.print("| |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 1:
			switch (n) {
			case 1:
				System.out.print("   ");
				break;
			case 2:
				System.out.print("  |");
				break;
			case 3:
				System.out.print("   ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print("   ");
				break;
			default:
				break;
			}

			break;
		case 2:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("  |");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("|  ");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 3:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("  |");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 4:
			switch (n) {
			case 1:
				System.out.print("   ");
				break;
			case 2:
				System.out.print("| |");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print("   ");
				break;
			default:
				break;
			}

			break;
		case 5:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("|  ");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 6:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("|  ");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("| |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 7:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("  |");
				break;
			case 3:
				System.out.print("   ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print("   ");
				break;
			default:
				break;
			}

			break;
		case 8:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("| |");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("| |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		case 9:
			switch (n) {
			case 1:
				System.out.print(" - ");
				break;
			case 2:
				System.out.print("| |");
				break;
			case 3:
				System.out.print(" - ");
				break;
			case 4:
				System.out.print("  |");
				break;
			case 5:
				System.out.print(" - ");
				break;
			default:
				break;
			}

			break;
		default:
			break;
		}
	}
}