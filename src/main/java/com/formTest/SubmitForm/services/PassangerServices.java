package com.formTest.SubmitForm.services;

import java.util.concurrent.ExecutionException;

import com.formTest.SubmitForm.entities.Passangers;

public interface PassangerServices 
{
	public String savePassangerDetails(Passangers passangers) throws InterruptedException, ExecutionException;
	public Passangers getPassangerDetails(String name) throws InterruptedException, ExecutionException;
	public String updatePassangerDetails(Passangers passangers) throws InterruptedException, ExecutionException;
	public String deletePassanger(String name);
}
