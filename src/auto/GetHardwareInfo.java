package auto;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetHardwareInfo {

   public String printComputerSystemProductInfo() {
	   String uuid = "non";
	   InetAddress ip;
	
       try {
			
   		ip = InetAddress.getLocalHost();
   		
   		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
   			
   		byte[] mac = network.getHardwareAddress();
   			
   		System.out.print("Current MAC address : ");
   			
   		StringBuilder sb = new StringBuilder();
   		for (int i = 0; i < mac.length; i++) {
   			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
   		}
   		uuid = sb.toString();
   		System.out.println(uuid);
   			
   	} catch (UnknownHostException e) {
   		
   		e.printStackTrace();
   		
   	} catch (SocketException e){
   			
   		e.printStackTrace();
   			
   	}
       
       return uuid;
   }

   public static void main(String[] args) {
	   
       GetHardwareInfo getHardwareInfo = new GetHardwareInfo();
       
       System.out.println(getHardwareInfo.printComputerSystemProductInfo());
   }
 
}