/*187*****426的正确答案 ×
题目描述
									
头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
a＜= b＜= c
b - a＜= 10
c - b＜= 10
所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？

								
输入
输入的第一行包含一个整数n，表示目前已经出好的题目数量。
第二行给出每道题目的难度系数 d1, d2, …, dn。
样例输入
4
20 35 23 40
输出
输出只包括一行，即所求的答案。
样例输出
2
时间限制
C/C++语言：1000MS其它语言：3000MS	
内存限制
C/C++语言：65536KB其它语言：589824KB*/										
import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++){
		arr[i]=scan.nextInt();
	}
	int res=0;
	Arrays.sort(arr);
	for(int i =0;i<n;i++){
		//判断第二个数和第一个数字的差 大于20则跳过（还需要出2道题目）
		if(i+1<n && arr[i+1]-arr[i]>20){
			res+=2;
			continue;
			//如果不到与20但是大于10，则还需要出一道题
		}else if(i+1<n && arr[i+1]-arr[i]>10){
			res+=1;
			i=i+1;
			continue;
			//如果在10以内的情况
		}else if(i+1<n){
			//判断第三个数字比第二个数字大多少
			//10以内
			if(i+2<n && arr[i+2]-arr[i+1]<=10){
				i=i+2;
			//10以外
			}else if(i+2<n){
				res+=1;
				i=i+1;
			//不存在第三个数字
			}else{
				res+=1;
				i=i+1;
			}
		}else{
			//如果没有下一个了就+2
			res+=2;
		}
	}
	System.out.println(res);
}
}

//解法 二
import java.util.*;

public class Main {

	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int n = in.nextInt();
		if (n == 0) {
			return 3;
		}
		int [] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		Arrays.sort(array);
		int res = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (tmp == 0) {
				tmp = 2;
				continue;
			}
			if (array[i] - array[i - 1] <= 10) {
				tmp--;
			} else {
				res += tmp;
				tmp = 2;
			}
		}
		res += tmp;
		
		return res;
	}
	
}
//解法 三
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int a,b,c;
        for(int i=0;i<N;i++) {
            arr.add(sc.nextInt());
            if (arr.size() >= 3) {
                Collections.sort(arr);
                int j = 0;
                while (arr.size() >= 3 && j <= arr.size() - 3) {
                    a = arr.get(j);
                    b = arr.get(j + 1);
                    c = arr.get(j + 2);
                    if (a==b && b==c) {
                        arr.remove(j);
                        arr.remove(j);
                        arr.remove(j);
                    } else {
                        j++;
                    }
                }
            }
        }
        Collections.sort(arr);
        if(arr.size()==0){
            System.out.print(0);
        }
        else if(arr.size()==1){
            System.out.print(2);
        }
        else if(arr.size()==2){
            if(arr.get(1)-arr.get(0)<=20){
                System.out.print(1);
            }else{
                System.out.print(4);
            }
        }
        else{
            int re =0;
            int k =0;
            while(arr.size()>0 && k<=arr.size()-3){
                a = arr.get(k);
                b = arr.get(k+1);
                c = arr.get(k+2);
                if(b-a<=10 && c-b<=10){
                    arr.remove(k);
                    arr.remove(k);
                    arr.remove(k);
                }else if(b-a<=10 && c-b>10){
                    re += 1;
                    arr.remove(k);
                    arr.remove(k);
                }else {
                    re +=2;
                    arr.remove(k);
                }
            }
            if(arr.size()==1){
                re +=2;
            }
            else if(arr.size()==2){
                if(arr.get(1)-arr.get(0)<=20){
                    re +=1;
                }else{
                    re +=4;
                }
            }
            System.out.println(re);
        }
    }
}