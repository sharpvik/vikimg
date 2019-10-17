public class VikImg {

	public static void main(String[] args) {
		byte[] bytes = {10, 10, 10, 'h', 'e', 'l', 'l', 'o'};
		boolean ok = Writer.write("myfile.txt", bytes);
		if (!ok) System.out.println("Something went wrong.");
	}

}
