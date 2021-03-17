package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

public class Readingoutlookmail {
  public boolean match(Message message) {
    try {
      if (message.getSubject().contains("SDIP REPORTS")) {
        System.out.println("match found");
        return true;
      }
    } catch (MessagingException ex) {
      ex.printStackTrace();
    }
    return false;
  };

  /*public static void main(String[] args) throws MessagingException {
    MultiPartEmail email = new MultiPartEmail();
    Properties props = new Properties();
    props.setProperty("mail.store.protocol", "imaps");

    // extra codes required for reading OUTLOOK mails during IMAP-start
    props.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.setProperty("mail.imaps.socketFactory.fallback", "false");
    props.setProperty("mail.imaps.port", "993");
    props.setProperty("mail.imaps.socketFactory.port", "993");
    // extra codes required for reading OUTLOOK mails during IMAP-end
    try {
      Session session = Session.getDefaultInstance(props, null);
      Store store = session.getStore("imaps");
      store.connect("outlook.office365.com", "sukkiyaeh24@outlook.com", "");
      Folder inbox = store.getFolder("INBOX");
      // inbox.open(Folder.READ_WRITE);

      inbox.open(Folder.READ_ONLY);

      SearchTerm sender = new FromTerm(new InternetAddress("sukkiyaeh24@outlook.com"));

      Message[] messages = inbox.search(sender);
      System.out.println(messages);

      for (int i = 0; i < messages.length; i++) {

        System.out.println(messages[i].getSubject());
        if (messages[i].getSubject().equals(null)) {
          System.out.println("null in subject");
          break;
        } else if (messages[i].getSubject().contains("SDIP REPORTS")) {
          System.out.println("1 match found");
        } else {
          System.out.println("no match");
        }
      }
      System.out.println("no more messages");
      store.close();

    } catch (Exception mex) {
      mex.printStackTrace();
    }
  }*/

  public static void main(String[] args) {
    Properties props = System.getProperties();
    props.setProperty("mail.store.protocol", "imaps");
    props.put("mail.imap-mail.outlook.com.ssl.enable", "false");
    props.put("mail.pop3.host", "outlook.com");
    props.put("mail.pop3.port", "995");
    props.put("mail.pop3.starttls.enable", "true");
    try {
      Session session = Session.getInstance(props, null);
      Store store = session.getStore();
      // store.connect("imap-mail.outlook.com", "suganya.sugan@sailotech.net", "G");
      store.connect("outlook.office365.com", "sukkiyaeh24@outlook.com", "sugan241");
      //store.connect("outlook.office365.com", "suganya.sugan@sailotech.net", "g");
      session.setDebug(true);
      Folder inbox = store.getFolder("INBOX");
      inbox.open(Folder.READ_ONLY);

      SearchTerm sender = new FromTerm(new InternetAddress("messer_test@sailotech.net"));

      Message[] messages = inbox.search(sender);
      System.out.println(messages);

      for (int i = 0; i < messages.length; i++) {

        System.out.println(messages[i].getSubject());
        if (messages[i].getSubject().equals(null)) {
          System.out.println("null in subject");
          break;
        } else if (messages[i].getSubject().contains("EZ Scheduler OTP for rest Password")) {
          System.out.println("Match Found");
        } else {
          System.out.println("No Match");
        }
      }
      //  System.out.println("no more messages");
      store.close();

    } catch (Exception mex) {
      mex.printStackTrace();
    }
  }
}
