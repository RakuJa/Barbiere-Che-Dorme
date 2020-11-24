import java.util.Random;


public class Test {

	public static void main(String[] args) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		Shop s = new Shop(10);
		new Barbiere(s);
		while(true) {
			try {
				Thread.sleep(random.nextInt(1500)+1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.setLength(0);
			for (int i = 0; i < 5; i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			new Client(sb.toString(),s);
		}

	}

}
