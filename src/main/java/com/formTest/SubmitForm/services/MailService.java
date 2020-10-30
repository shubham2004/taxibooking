package com.formTest.SubmitForm.services;

import org.springframework.stereotype.Component;

import com.formTest.SubmitForm.entities.Email;

public interface MailService {
	public void sendMail(final Email email);
	public void sendMailWithAttachment(final Email email,String filePath)throws Exception;
}
