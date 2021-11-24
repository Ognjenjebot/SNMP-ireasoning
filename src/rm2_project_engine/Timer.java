package rm2_project_engine;

import javax.swing.JLabel;

public class Timer extends Thread{

	private int timeS = 0;
	private JLabel refLabel;
	private int selected = 0;
	
	public Timer(JLabel l) {
		refLabel = l;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				refLabel.setText("R" + (selected + 1) + " updated before: " + timeS + "s");
				Thread.sleep(1000);
				timeS++;				
			}
		}catch(InterruptedException e) {}		
	}
	
	public synchronized int getTimeS() {
		return timeS;
	}
	public synchronized void resetTime() {
		timeS = 0;
	}
	
	public synchronized void setSelected(int s) {
		selected = s;
	}
	
}
