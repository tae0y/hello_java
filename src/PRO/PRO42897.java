package PRO;

public class PRO42897 {
    //참고 : https://velog.io/@imacoolgirlyo/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8F%84%EB%91%91%EC%A7%88-%ED%8C%8C%EC%9D%B4%EC%8D%AC
    //dp[i] = MAX(dp[i-1], money[i] + dp[i-2])
    //1을 무조건 선택하는 경우, n를 무조건 선택하는 경우
    public int solution(int[] money) {
        int n = money.length;
        int dp_selectFisrt[] = new int[n];
        int dp_notselectFirst[] = new int[n];
        int MAX_selectFirst = -1, MAX_notselectFirst = -2;

        dp_selectFisrt[0] = money[0];
        dp_selectFisrt[1] = Math.max(money[0], money[1]);
        for(int i=2; i<n-1; i++){ //첫번째는 무조건 선택, 마지막은 절대 안함
            dp_selectFisrt[i] = Math.max(dp_selectFisrt[i-1], money[i]+dp_selectFisrt[i-2]);
            MAX_selectFirst = Math.max(MAX_selectFirst, dp_selectFisrt[i]);
        }

        dp_notselectFirst[0] = 0;
        dp_notselectFirst[1] = money[1];
        for(int i=2; i<n; i++){ //첫번째 무조건 안함, 마지막은 할수도 있고
            dp_notselectFirst[i] = Math.max(dp_notselectFirst[i-1], money[i]+dp_notselectFirst[i-2]);
            MAX_notselectFirst = Math.max(MAX_notselectFirst, dp_notselectFirst[i]);
        }

        return Math.max(MAX_selectFirst, MAX_notselectFirst);
    }
}
