import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		float Oasset =0;
		float balance = Oasset;
		float risk ;
		float riskAmount;
		float reward;
		String RR;
		float profit;
		float targetBalance =0;
		
		
		//Request user input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How much your asset or balance is?");
		Oasset = scanner.nextFloat();
		System.out.println();
		
		System.out.println("How many percent(%) will you take risk?");
		risk = scanner.nextFloat();
		System.out.println();
		
		System.out.println("What is you Risk/Raward ratio 1 : _ ?");
		reward = scanner.nextInt();
		System.out.println();
		
		balance = Oasset;
		RR = "1 : " + (int)reward;
		

		for (int i = 1; i <= 30; i++) {

			System.out.println("Day " + i);
			System.out.println("Asset	 = " + balance);

			riskAmount = balance / 100 * risk;
			profit = riskAmount * reward;
			balance = balance + profit;
			targetBalance = balance;

			System.out.println("Risk (" + (int)risk + "%) = " + riskAmount);
			System.out.println("R : R ratio = 1 : " + reward);
			System.out.println("Profit = " + profit);
			System.out.println("Target Asset = " + targetBalance);
			System.out.println();
		}

		System.out.println("Total Asset	....." + targetBalance);
		System.out.println("Oringinal Asset ..... " + Oasset);
		System.out.println("Total Net Profit ..... " + (balance - Oasset));
		System.out.println((balance / Oasset) + " times in 30 days.....");
		System.out.println("Hope This Challenge Success..........");
	}
	
}