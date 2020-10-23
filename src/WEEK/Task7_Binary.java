package WEEK;

public class Task7_Binary {
    /**
     * 2020-07-16 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43237
     * https://www.acmicpc.net/problem/2512
     * */

    public void _test(){
        System.out.println(solution(new int[]{120,110,140,150}, 485));
        System.out.println(solution(new int[]{100,120,100,120,150}, 400));
    }

    /*public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] budgets = new int[tc];
        for(int i=0; i<tc; i++) budgets[i] = sc.nextInt();
        int M = sc.nextInt();*/

    public int solution(int[] budgets, int M){
        int largest_in_budgets = Integer.MIN_VALUE;
        for(int budget : budgets) if(largest_in_budgets < budget) largest_in_budgets = budget;

        long sum = 0;
        int low = 0, high = largest_in_budgets, mid = 0;
        int answer = -1;
        while(low<=high){
            sum = 0;
            mid = (low+high)/2;
            for(int budget : budgets){
                if(budget >= mid) sum += mid;
                else sum += budget;
            }
            System.out.println("sum="+sum+", mid="+mid+", low="+low+", high="+high);
            if(sum == M){
                answer = mid;
                break;
            }
            else if(sum < M){
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        //System.out.println(answer);
        return answer;
    }
}