package rm2_project_engine;

public class Main {

	public static void main(String[] args) {
		Router r1 = new Router("192.168.10.1");
		r1.getTable();
		
		for(int i = 0; i < r1.getTcpList().size(); i++)
			System.out.println(r1.getTcpList().get(i).toString());
		
		System.out.println();
		
		for(int i = 0; i < r1.getUdpList().size(); i++)
			System.out.println(r1.getUdpList().get(i).toString());
	}

}
