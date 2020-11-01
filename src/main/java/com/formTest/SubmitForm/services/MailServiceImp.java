/**
 * 
 */
package com.formTest.SubmitForm.services;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.formTest.SubmitForm.entities.Email;

/**
 * @author Shubham
 *
 */
@Service
public class MailServiceImp implements MailService
{
	   private JavaMailSender javaMailSender;
	   public void sendMail( Email email){
	      SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	      simpleMailMessage.setSubject(email.getSubject());
	      simpleMailMessage.setFrom(email.getFrom());
	      simpleMailMessage.setTo(email.getTo());
	      simpleMailMessage.setText(email.getMessageText());
	      System.out.println(simpleMailMessage);
	      javaMailSender.send(simpleMailMessage);
	   }
	   public void sendMailWithAttachment(final Email email,
	         String filePath) throws Exception{
	      MimeMessage mimeMessage=javaMailSender.createMimeMessage();
	      MimeMessageHelper mimeMessageHelper=new
	         MimeMessageHelper(mimeMessage,true);
	      mimeMessageHelper.setSubject(email.getSubject());
	      mimeMessageHelper.setFrom(email.getFrom());
	      mimeMessageHelper.setTo(email.getTo());
	      mimeMessageHelper.setText(email.getMessageText());
	      FileSystemResource file=new FileSystemResource(new
	         File(filePath));
	      mimeMessageHelper.addAttachment("Sample File",file);
	      javaMailSender.send(mimeMessage);
	   }
	}
