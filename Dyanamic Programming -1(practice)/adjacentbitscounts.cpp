#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007
typedef pair<long long, long long> pll;

int main()
{
    ll p;
    cin >> p;
    while (p--)
    {
        ll number, n, k;
        cin >> number >> n >> k;

        pll **dp = new pll *[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = new pll[k + 1];

        dp[1][0].first = 1;
        dp[1][0].second = 1;
        for (ll j = 1; j <= k; j++)
        {
            dp[1][k].first = 0;
            dp[1][k].second = 0;
        }

        for (ll i = 2; i <= n; i++)
        {
            dp[i][0].first = ((dp[i - 1][0].first % MOD) + (dp[i - 1][0].second % MOD)) % MOD;
            dp[i][0].second = dp[i - 1][0].first % MOD;
        }

        for (ll i = 2; i <= n; i++)
        {
            for (ll j = 1; j <= k; j++)
            {
                dp[i][j].first = ((dp[i - 1][j].first % MOD) + (dp[i - 1][j].second % MOD)) % MOD;
                dp[i][j].second = ((dp[i - 1][j].first % MOD) + (dp[i - 1][j - 1].second % MOD)) % MOD;
            }
        }

        cout << number << " " << ((dp[n][k].first % MOD) + (dp[n][k].second % MOD)) % MOD << endl;
    }
}