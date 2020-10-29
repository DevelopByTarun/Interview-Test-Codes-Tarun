package com.interview.app.HttpProxySettingInJava;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class App {
	
	public static void main( String[] args ) {
		
		App.createProxyConnection();
		App.showHttpProxySetting();	
		
	}
	
	public static void createProxyConnection() {
		
		try {
			 Properties systemSettings = System.getProperties();
	         systemSettings.put("ProxySet", "true");
	         systemSettings.put("http.proxyHost", "Proxy.Tarun.Local");
	         systemSettings.put("http.proxyPort", "80");
	         
	         URL u = new URL("http://www.google.com");
	         HttpURLConnection con = (HttpURLConnection)u.openConnection();
	         System.out.println(con.getResponseCode() + " : " + con.getResponseMessage());
	         System.out.println(con.getResponseCode() == HttpURLConnection.HTTP_OK);
		}
		catch(Exception ex) {
    		ex.printStackTrace();
    		System.out.println(false);
    	}
	}
	
	public static void showHttpProxySetting() {
		
		System.setProperty("java.net.useSystemProxies", "true");
    	List<Proxy> list = null;
    	
    	try {
    		list = ProxySelector.getDefault().select(new URI("http://www.google.com/"));
    		
    		if(list != null) {
    			
    	        for (Iterator<Proxy> iter = list.iterator(); iter.hasNext();) {
    	            Proxy proxy = iter.next();
    	            System.out.println("Proxy Type Is => " + proxy.type());
    	            InetSocketAddress addr = (InetSocketAddress) proxy.address();
    	            
    	            if (addr == null) {
    	               System.out.println("No Proxy");
    	            } else {
    	               System.out.println("Proxy Hostname Is => " + addr.getHostName());
    	               System.out.println("Proxy Port Is => " + addr.getPort());
    	            } 
    	         }	
    		}	
    	}
    	catch(URISyntaxException e) {
    		e.printStackTrace();
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
	}
}
