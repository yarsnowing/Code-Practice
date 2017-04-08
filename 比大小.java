/*
题目描述
                  
现在有"abcdefghijkl”12个字符，将其所有的排列中按字典序排列，给出任意一种排列，说出这个排列在所有的排列中是第几小的？

                
输入
第一行有一个整数n（0＜n＜=10000）;
随后有n行，每行是一个排列；
样例输入
3
abcdefghijkl
hgebkflacdji
gfkedhjblcia
输出
输出一个整数m，占一行，m表示排列是第几位；
样例输出
1
302715242
260726926

*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      sc.nextLine();                     //另起一行的感觉
      for(int i=0;i<n;i++){
      	String s=sc.nextLine();
        char[] ch=s.toCharArray();
        System.out.println(getRank(ch));
      }
    }
  
  public static int getRank(char[] ch){
    int rank=1;
  	for(int i=0;i<ch.length;i++){
    	rank+=(ch[i]-'a')*f1(ch.length-i);
      for(int j=i;j<ch.length;j++){
      	if(ch[j]>ch[i])
          ch[j]--;
      }
    }
    return rank;
  }
  
  public static int f1(int num){
  	int a=1;
    for(int i=1;i<num;i++){
    	a*=i;
    }
    return a;
  }
}


#include <iostream>
#include <string>

using namespace std;

//idx[i] = (11-i)!
int idx[] = { 39916800, 3628800, 362880, 40320, 5040, 720, 120, 24, 6, 2, 1, 1 };

//标记用过的字符
int used[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };    

//统计当前字符之前, 已经有几个字符被用过了 (ex: 前面已经出现了'a'和'b', 则再出现'c'就不是第三个了，而是第一个)
int usedBefore(char ch){
  int ret = 0;
  for (int i = 0; i < (ch - 'a'); i++)ret += used[i];
  return ret;
}

int main(){
  int n;
  cin >> n;
  while (n--){
    int ans = 1;
    string str;
    cin >> str;
    for (int i = 0; i < 12; i++){
      ans += (str[i] - 'a' - usedBefore(str[i]))*idx[i];
      used[str[i] - 'a'] = 1;
    }
    cout << ans << endl;
    for (int i = 0; i < 12; i++)used[i] = 0;
  }

  return 0;
}

//备注 知识点
/*我排第几个
时间限制：1000 ms  |  内存限制：65535 KB
难度：3
描述
现在有"abcdefghijkl”12个字符，将其所有的排列中按字典序排列，给出任意一种排列，说出这个排列在所有的排列中是第几小的？

输入
第一行有一个整数n（0<n<=10000）;
随后有n行，每行是一个排列；
输出
输出一个整数m，占一行，m表示排列是第几位；
样例输入
3
abcdefghijkl
hgebkflacdji
gfkedhjblcia
样例输出
1
302715242
260726926
来源
[苗栋栋]原创
上传者
苗栋栋


康托展开和逆康托展开，昨天看到这两道题，以前没有接触过的内容，看了一下介绍，就着手把这两道题给a了，感觉属于简单的数学题吧，数学题主要是要对这些概念公式要熟悉，然后按照公式应该就能够很快解决了。看资料上说康托展开最大最明显的作用就是在判断状态是否重复方面了，其实属于hash的一个技巧。（感觉还没深入到这种境界，还只能算是了解吧）
简单的介绍一下康托展开吧：
X=an*(n-1)!+an-1*(n-2)!+...+ai*(i-1)!+...+a2*1!+a1*0! 其中，a为整数，并且0<=ai<i(1<=i<=n)。
公式：把一个整数X展开成如下形式：
X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[2]*1!+a[1]*0!
其中，a为整数，并且0<=a[i]<i(1<=i<=n)
x表示的就是所有序列中该序列所在的位置，其中an表示是比第一个位置的字母或数字小的个数。
举一个例子，比如问 45231是第几个排列？
第一个数是4，研究比4小的并且还没有出现过的数有3个：1，2，3。那么ans:=ans+ 3*(n-1)!=3*4！；
第二个数是5，比5小并且没有出现过的数只有3个，ans:=ans+ 3*(n-2)! =3*3！；
第三个数是2，这里就只有一个了，ans:=ans+ 1*(n-3)! =1*2！；
依次类推：最后得到的结果就是  ans:= 3*4!  +  3*3!  +  1*2!  +  1*1!  +  0*0!  +  1  =94
得出来的结果还要加1，因为这里得到的结果是在他之前的排列数

*/
解法：
#include <stdio.h>  
#include <string.h>  
long long sum[15]={1,1,2,6,24,120,720,5040,40320,362880,3628800,39916800,479001600};  
int main()  
{  
   int n;  
   //char s[12]={'a','b','c','d','e','f','g','h','i','j','k','l'};  
   char c[12];  
   scanf("%d",&n);  
   while(n--)  
   {  
       long long num=0;  
       memset(c,0,sizeof(c));   
       scanf("%s",c);  
       for(int i=0;i<12;i++)  
         {  
             long long temp=0;  
            for(int j=i+1;j<12;j++)  
            {  
                if(c[j]<c[i])temp++;//这里就是判断后面有多少个数比本身小；  
            }  
         num+=temp*sum[12-i-1];  
         }  
        printf("%lld\n",num+1);  
   }  
    return 0;  
}  

/*第几是谁？
时间限制：3000 ms  |  内存限制：65535 KB
难度：3
描述
现在有"abcdefghijkl”12个字符，将其按字典序排列，如果给出任意一种排列，我们能说出这个排列在所有的排列中是第几小的。但是现在我们给出它是第几小，需要你求出它所代表的序列.
输入
第一行有一个整数n（0<n<=10000）;
随后有n行，每行是一个整数m，它代表着序列的第几小；
输出
输出一个序列，占一行，代表着第m小的序列。
样例输入
3
1
302715242
260726926
样例输出
abcdefghijkl
hgebkflacdji
gfkedhjblcia
*/
解法：
#include <stdio.h>  
#include <string.h>  
#define N 12  
long long sum[15]={1,1,2,6,24,120,720,5040,40320,362880,3628800,39916800,479001600};  
int main()  
{  
    int n,i,j,id;  
    long int m,temp;  
    char s[N+1];//这里先前我把数组开成12，然后中间就总不对，第一组数据的k都打印不出，不知道什么情况。  
    char c[13]={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};  
    scanf("%d",&n);  
    while(n--)  
    {  
        scanf("%ld",&m);  
        memset(s,0,sizeof(s));  
        strcpy(s,c);  
        temp=m-1;  
        for(i=0;i<N;i++)  
        {  
            id=temp/sum[N-i-1];  
            printf("%c",s[id]);  
            for(j=id;j<N-i;j++)  
                s[j]=s[j+1];  
            temp-=id*sum[N-i-1];  
        }  
        printf("\n");  
    }  
    return 0;  
}  