#include<bits/stdc++.h>
typedef long long int ll;
using namespace std;


ll Princess_Farida(ll *input, ll size)
{
	ll *myArray = new ll[size];


	for(ll i=0;i<size;i++)
	{
		if(i == 0)
			myArray[i] = input[0];
		else if(i == 1)
			myArray[i] = max(input[0],input[1]);
		else
			myArray[i] = max(myArray[i-1],myArray[i-2]+input[i]);
	}

	ll best = 0;

	for(ll i=0;i<size;i++)
		if(myArray[i] > best)
			best = myArray[i];


	return best;	
}	


int main()
{
	ll t;
	cin >> t;
	for(int i=1;i<=t;i++)
	{
		ll n;
		cin >> n;

		ll *input = new ll[n];

		for(ll j=0;j<n;j++)
			cin >> input[j];
	
		cout << "Case " << i << ": "<< Princess_Farida(input,n) << endl;
	}

	return 0 ; 

}