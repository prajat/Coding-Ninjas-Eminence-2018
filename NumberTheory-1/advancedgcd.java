#include<bits/stdc++.h>

using namespace std;

int gcd(int a, int b) // assuming a>b
{
	if(b == 0)
		return a;

	return gcd(b,a%b); //Applying Euclid's Algorithm!
}

int reduceB(int a, string b)
{
	int len = b.length();
	int result = 0;

	for(int i=0;i<len;i++)
		result = (result*10 + b[i] - '0') % a;
	return result;
}

int gcdLarge(int a, string b)
{
	int num = reduceB(a,b);

	return gcd(a,num);

}




int main()
{

	int t;
	cin >> t; 
	for(int i=0;i<t;i++)
	{
		int a;
		string b; //as the length of b is 250, hence we can't handle it with any 
				  //int data type

		cin >> a;
		cin >> b;

		if(a == 0) // if a is zero! Then gcd would be 'b' itself!
		{
			cout << b << endl;
			continue;
		}

		cout << gcdLarge(a,b) << endl;
	}


	return 0 ; 

}