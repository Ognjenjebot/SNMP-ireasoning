package rm2_project_engine;

import com.ireasoning.protocol.snmp.SnmpDataType;

public class UdpState {
	
	SnmpDataType udpLocalAddress;  //ip adr(string)
	SnmpDataType udpLocalPort;  //int
	
	public UdpState(SnmpDataType udpLocalAddress, SnmpDataType udpLocalPort) {
		super();
		this.udpLocalAddress = udpLocalAddress;
		this.udpLocalPort = udpLocalPort;
	}

	
	
	@Override
	public String toString() {
		return "UdpState [udpLocalAddress=" + udpLocalAddress.toString() + ", udpLocalPort=" + udpLocalPort.toString() + "]";
	}

	public SnmpDataType getUdpLocalAddress() {
		return udpLocalAddress;
	}

	public void setUdpLocalAddress(SnmpDataType udpLocalAddress) {
		this.udpLocalAddress = udpLocalAddress;
	}

	public SnmpDataType getUdpLocalPort() {
		return udpLocalPort;
	}

	public void setUdpLocalPort(SnmpDataType udpLocalPort) {
		this.udpLocalPort = udpLocalPort;
	}
	
}
