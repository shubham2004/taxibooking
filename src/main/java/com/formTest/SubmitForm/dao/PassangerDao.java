package com.formTest.SubmitForm.dao;

import java.util.concurrent.ExecutionException;

import com.formTest.SubmitForm.entities.Passangers;

public interface PassangerDao 
{
	public  String savePassanger(Passangers passangers) throws InterruptedException, ExecutionException ;
	 public Passangers getPassanger(String name) throws InterruptedException, ExecutionException ;
	 public String updatePassanger(Passangers passangers) throws InterruptedException, ExecutionException;
	 public String deletePassanger(String name);
}
