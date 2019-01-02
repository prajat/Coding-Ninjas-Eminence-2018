#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define MOD 1000000007

int main()
{
    ll n;
    cin >> n;

    ll maxElement = 0;
    ll *input = new ll[n];
    for (ll i = 0; i < n; i++)
    {
        cin >> input[i];
        if (input[i] > maxElement)
            maxElement = input[i];
    }

    ll **dp = new ll *[n];
    for (ll i = 0; i < n; i++)
    {
        dp[i] = new ll[maxElement + 1];
        for (ll j = 0; j <= maxElement; j++)
            dp[i][j] = 0;
    }

    for (ll i = 0; i < n; i++)
    {
        ll x = input[i];
        dp[i][x] = ((dp[i][x] % MOD) + 1) % MOD;

        for (ll j = i - 1; j >= 0; j--)
        {
            if (input[j] >= input[i])
                continue;

            for (ll k = 1; k <= maxElement; k++)
            {
                if (dp[j][k] > 0)
                {
                    dp[i][__gcd(k, input[i])] = ((dp[i][__gcd(k, input[i])] % MOD) + (dp[j][k] % MOD)) % MOD;
                }
            }
        }
    }

    ll total = 0;
    for (ll i = 0; i < n; i++)
    {
        total = ((total % MOD) + (dp[i][1] % MOD)) % MOD;
    }

    cout << total << endl;
}