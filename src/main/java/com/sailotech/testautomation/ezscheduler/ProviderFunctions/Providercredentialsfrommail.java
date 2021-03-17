package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Providercredentialsfrommail {
		
	Properties properties = null;
    private Session session = null;
    private Store store;
    private Folder inbox;
    private String userName;
    private String password; 
    private String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";
    
    @Test()
    public void ProviderCredentialsfrommail(WebDriver driver) throws Exception {
   	    String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet s = wb.getSheetAt(3);
        Thread.sleep(1000);        

        System.out.println("\nUsername: " +s.getRow(1).getCell(0).getStringCellValue());
        System.out.println("\nPassword: " +s.getRow(1).getCell(1).getStringCellValue());           
        userName = s.getRow(1).getCell(0).getStringCellValue();
        password =  s.getRow(1).getCell(1).getStringCellValue();     
        Providercredentialsfrommail Rm= new Providercredentialsfrommail();
        Rm.readMail(userName,password);

	}       
 
    private boolean textIsHtml = false;
         private String getText(Part p) throws MessagingException,IOException {
        if (p.isMimeType("text/*")) 
        {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
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

    public void readMail(String emailId, String credt) throws IOException {
       String EmailId="" ;
    	String Name = "";
    properties = new Properties();
    properties.setProperty("mail.store.protocol", "imaps");
 
    try {
        session = Session.getDefaultInstance(properties, null);
        store = session.getStore("imaps");
        store.connect("imap.gmail.com", emailId, credt);       
        inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY); 
        Flags seen = new Flags(Flags.Flag.SEEN);
        FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
        Message messages[] = inbox.search(unseenFlagTerm);       
        String user_dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		int counter=0; 
		int rowCount = 1;
       for (int i = 0; i < messages.length; i++) { 
            Message message = messages[i];                   
            if(message.getSubject().equals("Account activated")) 
            {
            Address[] from = message.getFrom();
            System.out.println( "\n" +"<<<<<<<<<<<<<<<<<<<<< Mail No: " + i + " START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("\nDATE: " + message.getSentDate());
            System.out.println("\nFROM: " + from[0]);
            System.out.println("\nSUBJECT: " + message.getSubject());
            String body = org.jsoup.Jsoup.parse(getText(message).toString()).text();
            System.out.println("\nBODY:  "+body);
            Pattern pattern = Pattern.compile("\s[a-zA-Z]+[0-9]+");
            Matcher matcher = pattern.matcher(body);
            Pattern pattern1 = Pattern.compile("\s[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+");
            Matcher matcher1 = pattern1.matcher(body);
            Pattern pattern2 = Pattern.compile(":\s[a-zA-Z0-9]{8}");
            Matcher matcher2 = pattern2.matcher(body);
            Pattern pattern3 = Pattern.compile("Hello\s[A-Za-z\s]*,");
            Matcher matcher3 = pattern3.matcher(body);
          
            if(matcher1.find()) {
            	String EmailId1 = matcher1.group();
                EmailId = EmailId1.replaceAll(" ", "");
            	System.out.println("\nDoctor EmailId: "+EmailId);             
            }
           
            if(matcher3.find()) {
            	String Providername1 = matcher3.group();
            	String Providername2 = Providername1.replaceAll("Hello","");
                String Providername3  = Providername2.replaceAll(",", "");
                Name =Providername3.replaceAll(" ", "");
           	    System.out.println("\nDoctor Name: "+Name);
            }                        
            XSSFSheet s = wb.getSheetAt(2);
            s.getRow(1).getCell(10).setCellValue(EmailId);
            s.getRow(1).getCell(11).setCellValue(Name);       
            Object[][] ProviderCredentials = {
            		{Name,  EmailId, },            		
            };       	
            rowCount++;
            //System.out.println("\n"+rowCount);
            System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<< Mail NO:" + i + " END >>>>>>>>>>>>>>>>>>>>>>.");
       }
       }
        //System.out.println("\n" +counter);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Provider.xlsx");
    	wb.write(fout);
        inbox.close(true);
        store.close();      
        }catch (Exception e) {  
                System.out.println("\n"+e);    
            }
}
}