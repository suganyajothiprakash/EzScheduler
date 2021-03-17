package com.sailotech.testautomation.ezscheduler.readingmail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readinggmailko {
  public static void main(String[] args) {

    readinggmailko gmail = new readinggmailko();
    gmail.read();
  }

  @SuppressWarnings("unused")
  private boolean textIsHtml = false;

  private String getText(Part p) throws MessagingException, IOException {
    if (p.isMimeType("text/*")) {
      String s = (String) p.getContent();
      textIsHtml = p.isMimeType("text/html");
      return s;
    }
    if (p.isMimeType("multipart/alternative")) { // prefer html text over plain text
      Multipart mp = (Multipart) p.getContent();
      String text = null;
      for (int i = 0; i < mp.getCount(); i++) {
        Part bp = mp.getBodyPart(i);
        if (bp.isMimeType("text/plain")) {
          if (text == null) text = getText(bp);
          continue;
        } else if (bp.isMimeType("text/html")) {
          String s = getText(bp);
          if (s != null) return s;
        } else {
          return getText(bp);
        }
      }
      return text;
    } else if (p.isMimeType("multipart/*")) {
      Multipart mp = (Multipart) p.getContent();
      for (int i = 0; i < mp.getCount(); i++) {
        String s = getText(mp.getBodyPart(i));
        if (s != null) return s;
      }
    }
    return null;
  }

  public void read() {

    Properties props = new Properties();

    try {
      //   props.load(new FileInputStream(new File("C:\\smtp.properties")));

      String user_dir = System.getProperty("user.dir");
      FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/ReadingEmailKO.xlsx");
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      // props.load(new FileInputStream(new File("user_dir " +
      // "\\xls.files\\ReadingEmailKO.xlsx")));
      Session session = Session.getDefaultInstance(props, null);

      Store store = session.getStore("imaps");
      store.connect("smtp.gmail.com", "kothandaramanbalasundaram@gmail.com", "kothandam01");

      Folder inbox = store.getFolder("inbox");
      inbox.open(Folder.READ_ONLY);
      int messageCount = inbox.getMessageCount();

      System.out.println("Total Messages:- " + messageCount);

      Message[] messages = inbox.getMessages();
      //  Message message = messages[i];

      System.out.println("------------------------------");

      for (int i = 0; i < messages.length; i++) {

        // for (int i = 0; i < 10; i++) {
        Message message = messages[i];
        Address[] from = message.getFrom();
        System.out.println("Mail Subject:- " + messages[i].getSubject());
        System.out.println(
            "====================================== Mail no.: "
                + i
                + " start ======================================");
        System.out.println("Date: " + message.getSentDate());
        System.out.println("From: " + from[0]);
        System.out.println("Subject: " + message.getSubject());
        String body = org.jsoup.Jsoup.parse(getText(message).toString()).text();
        System.out.println("Body:  " + body);
      }

      inbox.close(true);
      store.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
