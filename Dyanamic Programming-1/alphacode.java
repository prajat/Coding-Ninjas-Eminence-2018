#include<bits/stdc++.h>
typedef long long int ll;
using namespace std;

ll m = pow(10,9) + 7;
//Now the input could also '0' as a digit!

ll Alpha_Code(string input, int len, ll *arr)
{
	if(len == 0 || len == 1)
		return 1;

	if(arr[len] > 0)
		return arr[len];

	ll output = 0;
	if(input[len-1] != '0')
		output += Alpha_Code(input,len-1,arr)%m;

	if(  ((input[len-2] - '0')*10 + (input[len-1] - '0')) <=26 )
	{
		if(input[len-2] != '0')
		{
			output += Alpha_Code(input,len-2,arr)%m;
			output %= m;
		}
	}

	arr[len] = output;

	return output;
}


int main()
{
	string input;

	while(1)
	{
		cin >> input;
		if(input[0] == '0')
			return 0;

		int len = input.length();
		ll *arr = new ll[len+1];

		for(int i=0;i<=len;i++)
			arr[i] = 0;

		cout << Alpha_Code(input,len,arr) << endl;

		delete [] arr;

	}




	return 0 ; 

}