import java.util.Scanner;

class Main{
	public static final int CURRENCY[] = {50, 25, 10, 5, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()){
			long n = sc.nextLong();
			long sum = waysCount(n, 0);
			if(sum <= 1){
				System.out.println("There is only 1 way to produce " + n + " cents change.");
			}else{
				System.out.println("There are " + sum + " ways to produce " + n + " cents change.");
			}
		}
	}

	public static long waysCount(long n, int currency){
		long sum = 0;
		if(n == 0){
			return 1;
		}

		if(currency == 4){
			return 1;
		}

		for(long i = n / CURRENCY[currency]; i > 0; i--){
			sum += waysCount(n - i * CURRENCY[currency], currency + 1);
		}

		return sum + waysCount(n, currency + 1);
	}
}