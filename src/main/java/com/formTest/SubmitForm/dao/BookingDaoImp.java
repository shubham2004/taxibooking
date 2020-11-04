package com.formTest.SubmitForm.dao;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import com.formTest.SubmitForm.entities.Booking;
import com.formTest.SubmitForm.entities.Passangers;
import com.formTest.SubmitForm.entities.SessionEntities;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.internal.NonNull;

@Component
public class BookingDaoImp implements BookingDao
{
	@Autowired
	SessionEntities sessionEntities;
	
	public static final String COL_NAME="booking";
	 public String saveBooking(Booking booking) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(booking.getBookingId()).set(booking);
	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }
	 
	 public Booking getBooking(String name) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
	        ApiFuture<DocumentSnapshot> future = documentReference.get();

	        DocumentSnapshot document = future.get();

	        Booking booking = null;

	        if(document.exists()) {
	        	booking = document.toObject(Booking.class);
	            return booking;
	        }else {
	            return null;
	        }
	    }

	    public String updateBooking(Booking booking) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(booking.getBookingId()).set(booking);
	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }

	    public String deleteBooking(String bookingId) {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(bookingId).delete();
	        return "Document with Passangers ID "+bookingId+" has been deleted";
	    }
	    
	    
	    public ArrayList<Booking> getAllBooking()
	    {
	    	Firestore db = FirestoreClient.getFirestore();
	    	ApiFuture<QuerySnapshot> future = db.collection("booking").get();
	    	ArrayList<Booking> bookingList = new ArrayList<Booking>();
	    	List<QueryDocumentSnapshot> documents;
			try 
			{
				documents = future.get().getDocuments();
				
//				bookingList=documents.stream().filter(doc -> doc.getId().equals(sessionEntities.getPassanger().getPassangerId())).collect(Collectors.toList());;
//				
				for (QueryDocumentSnapshot document : documents) 
				{
						//if(document.toObject(Booking.class).getBookingId()==sessionEntities.getPassanger().getPassangerId())
						{
							bookingList.add(document.toObject(Booking.class));
						}
			    }
				return bookingList;
			} 
			catch (InterruptedException | ExecutionException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	

	    	return bookingList;
	    }
	    
}
