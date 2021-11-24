package rm2_project_gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import rm2_project_engine.Router;
import rm2_project_engine.TcpState;

public class Gui extends JFrame{
		
	private Router routers[] = 
		{new Router("192.168.10.1"), new Router("192.168.20.1"), new Router("192.168.30.1")};
	private int selected;
	
	private JTable tcpTable;
	private JTable udpTable;	
	String dataTcp[][];
	String dataUdp[][];
	private JPanel containerCenter;
	String columnsTcp[] = {
			"tcpConnState", "tcpConnLocalAddress", "tcpConnLocalPort", "tcpConnRemAddress", "tcpConnRemPort"
	};	
	String columnsUdp[] = {"udpLocalAddress", "udpLocalPort"};
	JScrollPane jp1;
	JScrollPane jp2;
	
	private JToolBar topBar;
	private JComboBox list;
	private JButton showButton;
	
	
	public Gui() {
		setTitle("SNMP");
		setSize(900, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		populate();
		this.repaint();
		this.revalidate();
		startSession();
	}
	
	public void populate() {
		
		this.setLayout(new BorderLayout());
	
		topBar = new JToolBar();
		topBar.setRollover(true);
		showButton = new JButton("Show");
		topBar.add(showButton);
		topBar.addSeparator();
		String routers[] = {
				"192.168.10.1", "192.168.20.1", "192.168.30.1" 
		};
		list = new JComboBox(routers);
		topBar.add(list);
		this.add(topBar, BorderLayout.NORTH);
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selected = list.getSelectedIndex();
				startSession();
			}
		});
		

				
		String data1[][] = {{"", "", "", "", ""}};
		String data2[][] = {{"", ""}};
		tcpTable = new JTable(data1, columnsTcp);
		udpTable = new JTable(data2, columnsUdp);	
		
		jp1 = new JScrollPane(tcpTable);
		jp2 = new JScrollPane(udpTable);
		
		containerCenter = new JPanel();			
		this.add(containerCenter, BorderLayout.CENTER);		
		containerCenter.setLayout(new GridLayout(1, 2));
		containerCenter.add(jp1);   containerCenter.add(jp2);
		selected = 0;
		this.startSession();
	}
	
	private void startSession() {
		while(true) {
			try {		
				
				routers[selected].closeSession();
				routers[selected].getTable();
				parseData();
				tcpTable = new JTable(dataTcp, columnsTcp);
				udpTable = new JTable(dataUdp, columnsUdp);
				jp1.getViewport().removeAll();
				jp1.getViewport().add(tcpTable);
				jp2.getViewport().removeAll();
				jp2.getViewport().add(udpTable);
				
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void parseData() {
		
		dataTcp = new String[routers[selected].getTcpList().size()][5];
		for(int i = 0; i < routers[selected].getTcpList().size(); i++) {
				dataTcp[i][0] = routers[selected].getTcpList().get(i).getTcpConnState().toString();
				dataTcp[i][1] = routers[selected].getTcpList().get(i).getTcpConnLocalAddress().toString();
				dataTcp[i][2] = routers[selected].getTcpList().get(i).getTcpConnLocalPort().toString();
				dataTcp[i][3] = routers[selected].getTcpList().get(i).getTcpConnRemAddress().toString();
				dataTcp[i][4] = routers[selected].getTcpList().get(i).getTcpConnRemPort().toString();
		}
		
		dataUdp = new String[routers[selected].getUdpList().size()][2];
		for(int i = 0; i < routers[selected].getUdpList().size(); i++) {
			//	System.out.println(routers[selected].getUdpList().size());
				dataUdp[i][0] = routers[selected].getUdpList().get(i).getUdpLocalAddress().toString();
				dataUdp[i][1] = routers[selected].getUdpList().get(i).getUdpLocalPort().toString();
		}
	}

	public static void main(String[] args) {
		new Gui();
	}
	
}
