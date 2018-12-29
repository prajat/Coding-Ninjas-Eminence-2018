#include <bits/stdc++.h>

using namespace std;

//This algo is also called as Kadane Algo!
bool check_all_negative(int *arr, int n)
{
    for (int i = 0; i < n; i++)
        if (arr[i] > 0)
            return false;

    return true;
}

int kadane(int *arr, int n)
{
    if (check_all_negative(arr, n) == true)
    {
        int max = INT_MIN;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    int current_sum = 0;
    int best_sum = 0;

    for (int i = 0; i < n; i++)
    {
        if (current_sum < 0)
            current_sum = 0;

        current_sum += arr[i];
        if (current_sum > best_sum)
            best_sum = current_sum;
    }

    return best_sum;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string input;
        cin >> input;
        int len = input.length();
        int *arr = new int[len];
        int count = 0;

        for (int i = 0; i < len; i++)
        {
            if (input[i] == 'R')
            {
                count++;
                arr[i] = -1;
            }

            else
                arr[i] = 1;
        }

        cout << count + kadane(arr, len) << endl;
    }

    return 0;
}