package rm2_project_engine;

import com.ireasoning.protocol.snmp.SnmpDataType;
	
public class TcpState {	
	
	private SnmpDataType tcpConnState;   //int sa odredjenim vrednostima(enum?)
	private SnmpDataType tcpConnLocalAddress;  // ip adr(string)
	private SnmpDataType tcpConnLocalPort;  //int
	private SnmpDataType tcpConnRemAddress;  //ip adr(string)
	private SnmpDataType tcpConnRemPort;   //int
	
	

	public TcpState(SnmpDataType tcpConnState, SnmpDataType tcpConnLocalAddress, SnmpDataType tcpConnLocalPort,
			SnmpDataType tcpConnRemAddress, SnmpDataType tcpConnRemPort) {
		super();
		this.tcpConnState = tcpConnState;
		this.tcpConnLocalAddress = tcpConnLocalAddress;
		this.tcpConnLocalPort = tcpConnLocalPort;
		this.tcpConnRemAddress = tcpConnRemAddress;
		this.tcpConnRemPort = tcpConnRemPort;
	}
	
	@Override
	public String toString() {
		return "TcpState [tcpConnState=" + tcpConnState.toString() + ", tcpConnLocalAddress=" + tcpConnLocalAddress.toString()
				+ ", tcpConnLocalPort=" + tcpConnLocalPort.toString() + ", tcpConnRemAddress=" + tcpConnRemAddress.toString()
				+ ", tcpConnRemPort=" + tcpConnRemPort.toString() + "]";
	}
	
	public SnmpDataType getTcpConnState() {  
		return tcpConnState;
	}

	public void setTcpConnState(SnmpDataType tcpConnState) {
		this.tcpConnState = tcpConnState;
	}

	public SnmpDataType getTcpConnLocalAddress() {
		return tcpConnLocalAddress;
	}

	public void setTcpConnLocalAddress(SnmpDataType tcpConnLocalAddress) {
		this.tcpConnLocalAddress = tcpConnLocalAddress;
	}

	public SnmpDataType getTcpConnLocalPort() {
		return tcpConnLocalPort;
	}

	public void setTcpConnLocalPort(SnmpDataType tcpConnLocalPort) {
		this.tcpConnLocalPort = tcpConnLocalPort;
	}

	public SnmpDataType getTcpConnRemAddress() {
		return tcpConnRemAddress;
	}

	public void setTcpConnRemAddress(SnmpDataType tcpConnRemAddress) {
		this.tcpConnRemAddress = tcpConnRemAddress;
	}

	public SnmpDataType getTcpConnRemPort() {
		return tcpConnRemPort;
	}

	public void setTcpConnRemPort(SnmpDataType tcpConnRemPort) {
		this.tcpConnRemPort = tcpConnRemPort;
	}	
		
}
