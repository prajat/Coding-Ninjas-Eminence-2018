#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, i, x, y, pb, j;
    pair<int, int> pf[101];

    while (1)
    {
        scanf("%d%d", &pb, &n);
        if (pb == 0 && n == 0)
            break;

        for (i = 0; i < n; i++)
        {
            scanf("%d%d", &x, &y);
            pf[i] = make_pair(x, y);
        }
        int dp[n + 1][pb + 1];
        for (i = 0; i <= n; i++)
            for (j = 0; j <= pb; j++)
            {
                dp[i][j] = 0;
            }
        for (i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }
        for (i = 0; i <= pb; i++)
        {
            dp[0][i] = 0;
        }
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= pb; j++)
            {
                if (pf[i - 1].first <= j)
                {
                    dp[i][j] = max(pf[i - 1].second + dp[i - 1][j - pf[i - 1].first], dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int maxfun = dp[n][pb];
        int minmoney = 0;
        for (i = 0; i <= pb; i++)
        {
            if (dp[n][i] == maxfun)
            {
                minmoney = i;
                break;
            }
        }
        printf("%d %d\n", minmoney, maxfun);
    }
    return 0;
}