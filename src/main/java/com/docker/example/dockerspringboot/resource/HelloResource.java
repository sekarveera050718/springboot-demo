package com.docker.example.dockerspringboot.resource;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;

@RestController
public class HelloResource {
	static int successCount=0;
	static int failureCount=0;
	static boolean fileFlag;
	@RequestMapping("/hello")
	public String sayHello() {
		//System.out.println("App v2: Received new request from client\n");
		
		System.out.println("Received request::"+successCount+" from client\n");
		successCount++;
		/*
		 * count++; if(count <=5) {
		 * 
		 * try { Thread.currentThread().sleep(10000); }catch(Exception e) {}
		 * 
		 * return "Hello docker:"+count+"\n"; } else throw new NullPointerException();
		 */
		
		/*try {
			File f= new File("/tmp/request.txt");
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
			pw.println("Received request::"+successCount+" from client\n");
			pw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		return "Received request::"+successCount+" from client\n";
		
	}
	@RequestMapping(value="/health",method=RequestMethod.GET)
	public String getHealth() {
		
		/*
		 * File f= new File("/tmp/data.txt"); if(!f.exists()) { try { f.createNewFile();
		 * fileFlag=true; } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		failureCount++;
		if(failureCount>=10 && failureCount<=14) {
			
			System.out.println("Application is not healthy");
			throw new NullPointerException();
		}
		
		if (failureCount==15) failureCount=0;
		
		return "This application is healthy : Hit count ::" +failureCount;
		
	}
	
		
	@RequestMapping(value="/callback",method=RequestMethod.POST)
	public void callMe(HttpEntity<String> body) {
		System.out.println("Received call back from authrorization server.....");
		System.out.println(body.toString());
	}
}

	