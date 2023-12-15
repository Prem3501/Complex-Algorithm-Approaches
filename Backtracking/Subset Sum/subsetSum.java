import java.util.Scanner;
class subset_sum_backtrack
{
    static int subset_count = 0; 
   
    static void subset_sum(int list[], int sum, int starting_index, int target_sum) 
    { 
        if( target_sum == sum ) 
        { 
            subset_count++;
            if(starting_index < list.length)
                subset_sum(list, sum - list[starting_index-1], starting_index, target_sum); 
        } 
        else
        { 
            for( int i = starting_index; i < list.length; i++ ) 
            { 
                subset_sum(list, sum + list[i], i + 1, target_sum); 
            } 
        } 
    } 
    
    public static void main(String args[])
    {
        int i,n,sum;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [] list = new int[n];
        for(i=0;i<n;i++) {
            list[i] = sc.nextInt();
        }
        sum = sc.nextInt();
        subset_sum(list, 0, 0, sum);
        System.out.println(subset_count);
    }
}