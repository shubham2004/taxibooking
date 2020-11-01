package com.formTest.SubmitForm.services;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formTest.SubmitForm.dao.PassangerDao;
import com.formTest.SubmitForm.entities.Passangers;


@Service
public class PassangerServiceImp implements PassangerServices {

	@Autowired
	private PassangerDao passangerDao;
	public static final String COL_NAME="customers";
	 public String savePassangerDetails(Passangers passangers) throws InterruptedException, ExecutionException {
	        return passangerDao.savePassanger(passangers);
	    }
	 
	 public Passangers getPassangerDetails(String name) throws InterruptedException, ExecutionException {
	       return passangerDao.getPassanger(name);
	    }

	    public String updatePassangerDetails(Passangers passangers) throws InterruptedException, ExecutionException {
	        return passangerDao.updatePassanger(passangers);
	    }

	    public String deletePassanger(String name) {
	        return passangerDao.deletePassanger(name);
	    }
}
