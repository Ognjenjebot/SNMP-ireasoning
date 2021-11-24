package rm2_project_engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ireasoning.protocol.snmp.SnmpDataType;
import com.ireasoning.protocol.snmp.SnmpSession;
import com.ireasoning.protocol.snmp.SnmpTableModel;
import com.ireasoning.protocol.snmp.SnmpTarget;

public class Router {
	
	private String ipAdr;
	private static final String community = "si2019";
	private static final int port = 161;
	
	private SnmpTarget target;  //agent
	private SnmpSession session;  //sesija
	private SnmpTableModel tableTcp;
	private SnmpTableModel tableUdp;
	
	private List<TcpState> tcpList = new ArrayList<>();
	private List<UdpState> udpList = new ArrayList<>();
	
	public Router(String ip) {
		ipAdr = ip;
		target = new SnmpTarget(ipAdr, port, community, community); //radi za v1 i v2c,agent rutera
		//sesija se stalno nova uspostavlja, pa se kasnije pravi		
	}
	

	@SuppressWarnings("static-access")
	public void getTable() {
		
		tcpList.clear();
		udpList.clear();
		try {
			session = new SnmpSession(target);
			session.loadMib2();   //mora da se louduje prvo da bih mogao preko imena da dovlacim
			tableTcp = session.snmpGetTable("tcpConnTable");
			tableUdp = session.snmpGetTable("udpTable");
		
			for(int i = 0; i < tableTcp.getRowCount(); i++) {
				SnmpDataType tcpConnState = tableTcp.get(i, 0).getValue(); //posle proveriti da li je active
				SnmpDataType tcpConnLocalAddress = tableTcp.get(i, 1).getValue();
				SnmpDataType tcpConnLocalPort = tableTcp.get(i, 2).getValue();
				SnmpDataType tcpConnRemAddress = tableTcp.get(i, 3).getValue();
				SnmpDataType tcpConnRemPort = tableTcp.get(i, 4).getValue();
				//proverit kako tacno treba
				TcpState tcp = new TcpState(tcpConnState, tcpConnLocalAddress, tcpConnLocalPort, tcpConnRemAddress, tcpConnRemPort);
				tcpList.add(tcp);
			}
			
			for(int i = 0; i < tableUdp.getRowCount(); i++) {
				SnmpDataType udpLocalAddress = tableUdp.get(i, 0).getValue();
				SnmpDataType udpLocalPort = tableUdp.get(i, 1).getValue();
				UdpState udp = new UdpState(udpLocalAddress, udpLocalPort);
				udpList.add(udp);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("radi");
		
	}
	
	public void closeSession() {
		if(session != null)
			session.close();
	}
	
	public SnmpTarget getTarget() {
		return target;
	}
		
	public SnmpSession getSession() {
		return session;
	}
	
	
	public List<TcpState> getTcpList() {
		return tcpList;
	}
	
	public List<UdpState> getUdpList() {
		return udpList;
	}
	
}
