package krzwier;

/**
 * Hello world!
 *
 */
public class StringCalculator {

	public int Add(String inputString) {
		String[] args = inputString.split(",");
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].isEmpty()){
				int temp = Integer.parseInt(args[i]);
				sum += temp;
			}
		}
		return sum;
	}

}
