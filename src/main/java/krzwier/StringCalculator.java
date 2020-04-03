package krzwier;

/**
 * Hello world!
 *
 */
public class StringCalculator {

	public int Add(String inputString) throws Exception {
		// initialize default delimiters
		String delimiters = "[,\n]";

		// check for comment
		String splitInput[] = CheckForComment(inputString);
		String comment = splitInput[0];
		String realInput = splitInput[1];
		if (!comment.isEmpty()){
			delimiters = comment;
		}

		String[] args = realInput.split(delimiters);
		int sum = 0;
		String negNumList = "";
		boolean exceptionFlag = false;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].isEmpty()){
				int temp = Integer.parseInt(args[i]);
				if (temp < 0) {
					exceptionFlag = true;
					negNumList = negNumList + temp;
				} else if (temp <= 1000){
					sum += temp;
				}
			}
		}
		if (exceptionFlag) {
			throw new Exception("Negatives not allowed! (" + negNumList + ")");
		}
		return sum;
	}

	/** 
	 * This method takes input string and checks for a beginning comment
	 * returns a String array of comment and input
	 * 
	*/

	private String[] CheckForComment(String inputString) {
		// index 0 is used for comment
		// index 1 is used for real input string
		String[] returnStrings = {"", ""};
		if (inputString.indexOf("//") == 0) {
			int end = inputString.indexOf('\n');
			returnStrings[0] = inputString.substring(2,end);
			returnStrings[1] = inputString.substring(end+1);
		} else {
			returnStrings[0] = "";
			returnStrings[1] = inputString;
		}
		return returnStrings;
	}

}
