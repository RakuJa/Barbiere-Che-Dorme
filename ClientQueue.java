
public class ClientQueue {
	
	private Client[] chairs;
	private int peopleSitting;
	private int clientIndex;
	
	public ClientQueue (int length ) {
		peopleSitting = 0;
		clientIndex = 0;
		chairs = new Client[length];
		for (int count = 0; count < length; ++count) {
			chairs[count] = null;
		}
	}

	public synchronized boolean getSeat(Client c) {
		if (peopleSitting >= chairs.length) {
			System.out.println(c.getName() + " Negozio pieno, il cliente se ne va");
			return false;
		} else {
			chairs[clientIndex] = c;
			if (clientIndex < chairs.length-1) {
				++clientIndex;
			} else
				clientIndex = 0;
			++peopleSitting;
			return true;
		}
	}

	public synchronized void leaveSeat(Client c) throws Exception {
		System.out.println("Clienti in coda " +peopleSitting);
		--peopleSitting;
		boolean found = false;
		for (int i = 0;i<chairs.length && !found;++i) {
			if (chairs[i] != null)
				if (chairs[i].equals(c)) {
					System.out.println(c.getName()+" Lascia il posto");
					found = true;
					chairs[i] = null;
				}
		}
		if (!found)
			throw new Exception("Wot");
	}
	
	public Client firstWaiting(int index) {
		if (index<chairs.length) {
			return chairs[index];
		}else {
		if (clientIndex>0) 
			return chairs[clientIndex-1];
		else
			return chairs[chairs.length];
		}
	}
	
	public int getLength() {
		return chairs.length;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i<chairs.length;++i) {
			sb.append(chairs[i]);
		}
		return sb.toString();
	}

}
