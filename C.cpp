#include <iostream>
using namespace std;

static const int CURRENCY[] = {50, 25, 10, 5, 1};

long waysCount(long n, int currency);

int main(){
	long n;
	while(cin >> n){
		long sum = waysCount(n, 0);
		if(sum < 2){
			cout << "There is only 1 way to produce " << n << " cents change." << endl;
		}else{
			cout << "There are " << sum << " ways to produce " << n << " cents change." << endl;
		}
	}

	return 0;
}

long waysCount(long n, int currency){
	long sum = 0;
	if(n == 0 || currency == 4){
		return 1;
	}

	for(long i = n / CURRENCY[currency]; i > 0; i--){
		sum += waysCount(n - i * CURRENCY[currency], currency + 1);
	}

	return sum + waysCount(n, currency + 1);
}