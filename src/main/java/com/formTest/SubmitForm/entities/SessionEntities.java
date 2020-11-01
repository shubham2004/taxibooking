package com.formTest.SubmitForm.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionEntities 
{
	@Autowired
	Passangers passanger;

	public Passangers getPassanger() {
		return passanger;
	}

	public void setPassanger(Passangers passanger) {
		this.passanger = passanger;
	}
	
}
