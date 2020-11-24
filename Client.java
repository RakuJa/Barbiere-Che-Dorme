
public class Client extends Thread{
	
	private boolean waiting;
	private boolean hairCutted;
	private Shop s;
	private static int nClient = 0;
	
	public Client(String name,Shop s) {
		super(name);
		++nClient;
		this.s = s;
		waiting = true;
		hairCutted = false;
		start();
	}
	
	@Override
	public void run() {
		s.enterShop(getName());
		s.getSeat(this);
		while (!hairCutted) {
			
		}
	}	
	
	public boolean getCutted() {
		return hairCutted;
	}
	
	public void poke() {	
		waiting = false;	
	}
	
	public boolean getWaiting() {
		return waiting;
	}
	
	public void setCutted() {
		hairCutted = true;
	}
	
	public int getNClient() {
		return nClient;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (hairCutted != other.hairCutted)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

}
