#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main()
{
    ll n, k;
    cin >> n >> k;

    ll *input = new ll[n];
    for (ll i = 0; i < n; i++)
        cin >> input[i];

    sort(input, input + n);

    ll *sum = new ll[n];
    sum[0] = input[0];
    for (int i = 1; i < n; i++)
        sum[i] = sum[i - 1] + input[i];

    ll minUnfairness = 0;
    int i = 0;
    int j = k - 1;
    for (int a = 1; a <= j; a++)
    {
        minUnfairness += a * input[a] - sum[a - 1];
    }

    ll currUnfairness = minUnfairness;
    i++;
    j++;
    while (j < n)
    {
        currUnfairness += (j - i) * input[j] - sum[j - 1] + sum[i - 1];
        currUnfairness -= sum[j - 1] - sum[i - 1] - (j - i) * input[i - 1];

        if (currUnfairness < minUnfairness)
        {
            minUnfairness = currUnfairness;
        }

        i++;
        j++;
    }

    cout << minUnfairness << endl;
}