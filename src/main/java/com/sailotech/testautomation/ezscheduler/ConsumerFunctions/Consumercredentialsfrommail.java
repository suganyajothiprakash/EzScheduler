package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Consumercredentialsfrommail
{
	
	Properties properties = null;
    private Session session = null;  
    private Store store;
    private Folder inbox;
    private String userName;
    private String password;
     
    @Test()
    public void ReadingOTPfromConsumerMail() throws Exception 
    {
        String user_dir = System.getProperty("user.dir");
 		FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
     	@SuppressWarnings("resource")
        XSSFWorkbook wb = new XSSFWorkbook(fis);
     	XSSFSheet s = wb.getSheetAt(3);
        Thread.sleep(1000);     
        for (int i = 1; i <=s.getLastRowNum() ; i++) {
        System.out.println("\nConsumer Username:" +s.getRow(i).getCell(0).getStringCellValue());
        System.out.println("Consumer Password:" +s.getRow(i).getCell(1).getStringCellValue());
        userName = s.getRow(i).getCell(0).getStringCellValue();
        password =  s.getRow(i).getCell(1).getStringCellValue();        
    	Consumercredentialsfrommail PC = new Consumercredentialsfrommail();
        PC.readMail(userName,password);
        }	}
    
            
    @SuppressWarnings("unused")
         private boolean textIsHtml = false;
         private String getText(Part p) throws MessagingException,IOException {
        if (p.isMimeType("text/*")) 
        {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }

    public void readMail(String emailId, String credentials) throws IOException {   
        String OTP="";
    	String ConsumerName = "";
    	    properties = new Properties();
    properties.setProperty("mail.store.protocol", "imaps");
    
    try {
        session = Session.getDefaultInstance(properties, null);   
         store = session.getStore("imaps");      
         store.connect("imap.gmail.com",emailId, credentials);        
        inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY); 
        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
        Message messages[] = inbox.search(unseenFlagTerm);        
        String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
    	@SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);		
		int counter=0; 
		int rowCount = 1;
        for (int j = 0; j < messages.length; j++) {        	
           Message message = messages[j];                   
            if(message.getSubject().equals("EZ Scheduler OTP for registration")) 
            {
            Address[] from = message.getFrom();
            System.out.println("<<<<<<<<<<<<<<<<<<<<<< Mail NO: " + j + " START >>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("DATE: " + message.getSentDate());
            System.out.println("FROM: " + from[0]);
            System.out.println("SUBJECT: " + message.getSubject());
            String body = org.jsoup.Jsoup.parse(getText(message).toString()).text();
            System.out.println("BODY:  "+body);
            Pattern pattern2 = Pattern.compile("OTP:\s[0-9]{4}");
            Matcher matcher2 = pattern2.matcher(body);
            Pattern pattern3 = Pattern.compile("Dear\s[A-Za-z]+,");
            Matcher matcher3 = pattern3.matcher(body);
            if(matcher2.find()) {
            	String OTP1 = matcher2.group();
            	String OTP2 = OTP1.replaceAll("OTP:","");
                OTP = OTP2.replaceAll(" ", "");
         	    System.out.println(OTP);          	
            }
            if(matcher3.find()) {
            	String Consumername1 = matcher3.group();
            	String Consumername2 = Consumername1.replaceAll("Dear","");
                String Consumername3  = Consumername2.replaceAll(",", "");
                ConsumerName =Consumername3.replaceAll(" ", "");
            	System.out.println(ConsumerName);
            }
            XSSFSheet s = wb.getSheetAt(2);
           // for (int i = 1; i <= s.getLastRowNum() ; i++) {
           // s.getRow(1).getCell(5).setCellValue(ConsumerName);
           s.getRow(1).getCell(5).setCellValue(ConsumerName);
           s.getRow(1).getCell(6).setCellValue(OTP);
            @SuppressWarnings("unused")
       Object[][] Credentials = {
            		{ConsumerName, OTP},
            		
            };     	           	
            rowCount++;
            System.out.println(rowCount);
       System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<< Mail No: " + j + " END >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
       }
       }  
        System.out.println(counter);      
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Consumer.xlsx");
        wb.write(fout);
        inbox.close(true);
        store.close();
     
    }catch (Exception e) {  
                System.out.println(e);    
        }       
    
}
}