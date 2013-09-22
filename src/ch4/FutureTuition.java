public class FutureTuition {
	/** Main method */
	public static void main(String[] args) {
	// Initialize tuition, years
		double tuition = 10000;
		int years = 0;
		final double INCREASE_RATE = 1.07;

		while (tuition <= 20000) {
			tuition *= 1.07;
			years++;
		}

		System.out.println("Tutition will double after " + years + " years.");
	}
}
