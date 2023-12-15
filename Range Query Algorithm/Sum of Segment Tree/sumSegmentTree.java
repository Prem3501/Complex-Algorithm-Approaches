import java.util.*;
class Main
{ 
    int st[]; 
    Main(int arr[], int n) 
    { 
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
  
        st = new int[max_size]; 
        constructSTUtil(arr, 0, n - 1, 0); 
    } 
    int getMid(int s, int e) { 
        return s + (e - s) / 2; 
    } 
    int getSumUtil(int ss, int se, int qs, int qe, int si) 
    { 
        if (qs <= ss && qe >= se) 
            return st[si]; 
        if (se < qs || ss > qe) 
            return 0; 
        int mid = getMid(ss, se); 
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + 
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2); 
    } 
    void updateValueUtil(int ss, int se, int i, int diff, int si) 
    { 
        if (i < ss || i > se) 
            return; 
        st[si] = st[si] + diff; 
        if (se != ss) { 
            int mid = getMid(ss, se); 
            updateValueUtil(ss, mid, i, diff, 2 * si + 1); 
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2); 
        } 
    } 
    void updateValue(int arr[], int n, int i, int new_val) 
    { 
        if (i < 0 || i > n - 1) { 
            System.out.println("Invalid Input"); 
            return; 
        } 
  
        int diff = new_val - arr[i]; 
        arr[i] = new_val; 
        updateValueUtil(0, n - 1, i, diff, 0); 
    } 
    int getSum(int n, int qs, int qe) 
    { 
        if (qs < 0 || qe > n - 1 || qs > qe) { 
            System.out.println("Invalid Input"); 
            return -1; 
        } 
        return getSumUtil(0, n - 1, qs, qe, 0); 
    } 
    int constructSTUtil(int arr[], int ss, int se, int si) 
    { 
        if (ss == se) { 
            st[si] = arr[ss]; 
            return arr[ss]; 
        } 
        int mid = getMid(ss, se); 
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + 
                 constructSTUtil(arr, mid + 1, se, si * 2 + 2); 
        return st[si]; 
    }  
    public static void main(String args[]) 
    { 
        int n,i,l,r,pos,newval;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n]; 
        for(i = 0;i < n;i++)
        arr[i] = sc.nextInt();
        Main  tree = new Main(arr, n); 
        l = sc.nextInt();
        r = sc.nextInt();
        pos = sc.nextInt();
        newval = sc.nextInt();
        System.out.println("Sum of values in given range = " + 
                           tree.getSum(n, l, r)); 
        tree.updateValue(arr, n, pos, newval); 
        System.out.println("Updated sum of values in given range = " + 
                tree.getSum(n, 1, 3)); 
    } 
} 