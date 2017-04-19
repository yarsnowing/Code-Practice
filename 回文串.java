/*
回文串

									题目描述
									
给定一个字符串，问是否能够通过添加一个字母将其变成“回文串”。 “回文串”是指正着和反着读都一样的字符串。如：”aa”,”bob”,”testset”是回文串，”alice”,”time”都不是回文串。

								
输入
一行一个有小写字母构成的字符串，字符串长度不超过10。

样例输入
coco

输出
如果输入字符串可以通过添加一个字符，则输出”YES”，否则输出”NO”。

样例输出
YES



*/

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            char[] chars = str.toCharArray();
            boolean ok = true;
            boolean first = false;
            int i = 0, j = chars.length - 1;
            while (i < chars.length / 2) {
                if(chars[i] == chars[j]) {
                    i++;
                    j--;
                } else if(first) {
                    ok = false;
                    break;
                } else {
                    i++;
                    first = true;
                }
            }
            if(ok) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}



import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.next();
			int len = str.length();
			int subLen = getSubstring(str);
			if (len - subLen <= 1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}

	}

	// 将字符串翻转
	public static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	// 求两个字符串的最长公共子串
	public static int getSubstring(String str) {
		String str2 = reverse(str);
		int i = 0;
		int j = 0;
		int len = str.length();
		int dp[][] = new int[len + 1][len + 1];
		for (i = 1; i <= len; i++) {
			for (j = 1; j <= len; j++) {
				if (str.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[len][len];
	}

}

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main()
{
	char str[12];
	int i,j,flag;

	while(scanf("%s",str) != EOF)
	{
		i = 0;
		j = strlen(str)-1;
		flag = 0;

		while(i <= j)
		{
			if(str[i] != str[j] && flag == 0)
			{
				flag = 1;
				if(str[i+1] == str[j])
				{
					++i;
					continue;
				}
				else if(str[i] == str[j-1])
				{
					j--;
					continue;
				}
			}else if(str[i] != str[j] && flag == 1)
				break;

			++i;
			--j;
		}

		if(i > j)
			printf("Yes\n");
		else
			printf("No\n");
	}
	
	return 0;
}