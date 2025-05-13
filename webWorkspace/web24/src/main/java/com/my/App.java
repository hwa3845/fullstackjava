package com.my;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		String cmd="cmd.exe C:\\apache-maven-3.9.9\\bin\\mvn.cmd jetty:run";
//		String cmd="/bin/sh ~mvn.sh jetty:run";
		Process process = Runtime.getRuntime().exec(cmd);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		process.destroy();
		
//		Server server=new Server(8080);
//		WebAppContext ctxt= new WebAppContext(); 
//		ctxt.setContextPath("/");
//		File f=new File("src\\main\\webapp");
//		Resource base=new FileResource(f);
//		ctxt.setBaseResource(base);
//		server.setHandler(ctxt);
//		
//		try {
//			server.start();
//		} catch (Exception e) {
//			System.out.println("서버구동실패");
//		}
	}

}
