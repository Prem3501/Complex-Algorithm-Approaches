import java.util.*;
class GrayCodes
{

static int num;
static void grayCodeUtil(Vector<Integer> res, int n)
{
	if (n == 0)
	{
		res.add(num);
		return;
	}
	grayCodeUtil(res, n - 1);
	num = num ^ (1 << (n - 1));
	grayCodeUtil(res, n - 1);
}
static Vector<Integer> grayCodes(int n)
{
	Vector<Integer> res = new Vector<Integer>();
	num = 0;
	grayCodeUtil(res, n);

	return res;
}
public static void main(String[] args)
{
	int n;
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	Vector<Integer> code = grayCodes(n);
	for (int i = 0; i < code.size(); i++)
		System.out.print(code.get(i) +" ");
}
}
