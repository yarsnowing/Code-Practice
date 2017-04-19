
/*
题目描述
									
有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
注：规定从一级到一级有0种走法。

								
输入
输入数据首先包含一个整数n(1<=n<=100)，表示测试实例的个数，然后是n行数据，每行包含一个整数m，（1<=m<=40), 表示楼梯的级数。
样例输入
2
2
3
输出
对于每个测试实例，请输出不同走法的数量。
样例输出
1
2
*/

public class Main{
	public static void mian(String[] args){
		Scanner scanner=new Scanner(System.in);
		int total=scanner.nextInt();
		int numOffootStep=0;
		while(scanner.hasNext()){
        numOffootStep=scanner.nextInt();
        System.out.println("上"+numOffootStep+"级楼梯有"+calculateTotal(numOffootStep)+"种走法")；


		}

	}
public static int calculateTotal(int numOffootStep){
	if(numOffootStep==1)
		return 0;
	if(numOffootStep==2)
		return 2;
	else
		return calculateTotal(numOffootStep-1)+calculateTotal(numOffootStep-2);
}
}