
public class Shop {
	
	private ClientQueue cq;
	private int nClient;
	private int next;
	
	public Shop(int chairsNumber) {
		nClient = 0;
		next = 0;
		cq = new ClientQueue(chairsNumber);
	}

	public synchronized void enterShop(String name) {
		System.out.println(name + " Entered the shop");
		notify();
	}

	public void getSeat(Client c) {
		if (cq.getSeat(c)) {
			++nClient;
			youWait(c);
		}
	}
	
	public synchronized void youWait(Client c) {
		while (c.getWaiting()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean shopFree () {
		return nClient == 0;
	}
	
	public synchronized void noOneInTheShop() {
		System.out.println("Barbiere dorme");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void cutHair() {
		Client c = cq.firstWaiting(next);
		if (c != null) {
			try {
				c.poke();
				cq.leaveSeat(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(c.getName() + " capelli tagliati");
			--nClient;
		}
		if (next!=cq.getLength()-1) {
			++next;
		}else
			next = 0;
	}

}
