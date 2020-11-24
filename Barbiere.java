
public class Barbiere extends Thread{
	
	private Shop s;
	
	public Barbiere (Shop s) {
		this.s = s;
		start();
	}
	
	@Override
	public void run () {
		while(true) {
			if (s.shopFree())
				s.noOneInTheShop();
			else {
				System.out.println("Barbiere lavora");
				s.cutHair();
			}
					
		}
	}

}
