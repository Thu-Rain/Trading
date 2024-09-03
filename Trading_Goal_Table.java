import java.util.Scanner;

public class Main {

	static float Oasset;
	static float asset;
	static float risk ;
	static float riskAmount;
	static int reward;
	static String RR ;
	static float profit;
	static float targetAsset = 0;
	
	//Request user to input data
	public static void requestData(){
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
		
		asset = Oasset;
		RR = "1 : " + (int)reward;
		
	}

	//Use two dimentional array for dailyData
	static String[][] dailyData = new String[31][6];

	//Store daily data into dailyData
	public static void setData(int dayIndex, String day, String asset, String risk, String RR, String profit, String targetAsset) {

		dailyData[dayIndex][0] = day ;
		dailyData[dayIndex][1] = asset;
		dailyData[dayIndex][2] = risk;
		dailyData[dayIndex][3] = RR;
		dailyData[dayIndex][4] = profit;
		dailyData[dayIndex][5] = targetAsset;

	}

	//Adding space to data
	public static String addSpace(int len, String Data, String st) {

		int times;
		int length = len;
		String data = Data;
		String str = st;
		String firstSpace;
		String secondSpace;
		String addingSpace;
		String dat = "|";

		times = (length - data.length()) / 2;
		firstSpace = " ".repeat(times);
		secondSpace = firstSpace + " ".repeat(((length - data.length()) % 2));

		if (str == "") {
			addingSpace = dat + firstSpace + data + secondSpace;
		} else {
			addingSpace = dat + firstSpace + data + secondSpace + dat;
		}

		return addingSpace;

	}

	//Calculate data length to display table view
	public static String calculateLength(String para1, String para2) {

		String title = para1;
		String data = para2;
		String resendData;

		if (title == "Day" || title == "R : R") {

			resendData = addSpace(12, data, "");
			return resendData;

		} else if (title == "Asset") {

			resendData = addSpace(18, data, "");
			return resendData;

		} else if (title == "target") {

			resendData = addSpace(18, data, "target");
			return resendData;

		} else {

			resendData = addSpace(18, data, "");
			return resendData;
		}

	}

	//Calculate target of daily progress for 30 days
	public static void data() {

		int dayIndex;
		String day;
		String sendAsset;
		String sendRisk;
		String sendRR;
		String sendProfit;
		String sendTargetAsset;

		for (int i = 0; i < 30; i++) {

			riskAmount = asset / 100 * risk;
			profit = riskAmount * reward;
			asset = asset + profit;
			targetAsset = asset;

			dayIndex = i + 1 ;
			day = calculateLength("Day", Integer.toString(i + 1)) ;
			sendAsset = calculateLength("Asset", String.format("%.2f", asset - profit));
			sendRisk = calculateLength("Risk", String.format("%.2f",  riskAmount));
			sendRR = calculateLength("R : R", RR);
			sendProfit = calculateLength("Profit", String.format("%.2f", profit));
			sendTargetAsset = calculateLength("target", String.format("%.2f", targetAsset));

			//Call SetData method to store daily data
			setData(dayIndex, day, sendAsset, sendRisk, sendRR, sendProfit, sendTargetAsset);


		}
	}

	//Dotted Line
	public static void dot() {

		System.out.print("	".repeat(1));
		for (int t = 0; t < 102;  t++) {
			if(t>0){
				System.out.print("–");
			}else{
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	//Display Data Table
	public static void display() {

		dot();

		for (int i = 0; i < 31; i++) {
			System.out.print("	".repeat(1));
			for (int j = 0; j < 6; j++) {
				System.out.print(dailyData[i][j]);
			}

			System.out.println();

			dot();
		}

	}

	//Store title into dailyData first
	public static void storeTitle() {
		int index = 0;
		String col1 = calculateLength("Day", "Day");
		String col2 = calculateLength("Asset", "Asset");
		String col3 = calculateLength("Risk", "Risk(" + (int)risk + "%)");
		String col4 = calculateLength("R : R", "R : R");
		String col5 = calculateLength("Profit", "Profit");
		String col6 = calculateLength("target", "Target Asset");

		//Store title by calling setData method
		setData(0, col1, col2, col3, col4, col5, col6);
	}
	
	//Main mothod
	public static void main(String[] args) {
		
		
		requestData();
		storeTitle();
		data();

		System.out.println();
		System.out.print("	".repeat(5) + "........30 Days Trading Challange........");
		System.out.println();
		System.out.println();

		System.out.print("	".repeat(1) + " Daily Target Table");
		System.out.println();

		display();
		System.out.println();
		System.out.println("	".repeat(5) + "........Program by Thu Rain Ps........");

	}

}