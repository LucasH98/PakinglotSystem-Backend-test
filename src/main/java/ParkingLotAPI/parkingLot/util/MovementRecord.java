package ParkingLotAPI.parkingLot.util;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ParkingLotAPI.parkingLot.model.Vehicle;

@Document
public class MovementRecord implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	private String id;
	
	@DBRef
	@JsonIgnore
	private Vehicle vehicle;
	
	@Field("entryTime")
	private LocalDateTime entryTime;
	
	@Field("exitTime")
	private LocalDateTime exitTime;
	
	//@Transient 
	private boolean isParking;
	

	public MovementRecord() {
		
	}
	
	public MovementRecord(Vehicle vehicle) {
		this.vehicle = vehicle;	
		this.isParking = false ;
	    this.entryTime = null;
		this.exitTime = null;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	
	public boolean isParking() {
		return isParking;
	}

	public void setParking(boolean isParking) {
		this.isParking = isParking;
	}
	
	
	
	


	public void entrou() {
		
        if (entryTime == null) {
        	entryTime = LocalDateTime.now(ZoneId.systemDefault());
			System.out.println("Entrada validada "+entryTime);
            isParking = true;              
        }
    }
	
	public void saiu() {

	    if (exitTime == null && entryTime != null) {
	        exitTime = LocalDateTime.now(ZoneId.systemDefault());
	        isParking = false;
	        System.out.println("Saída validada " + exitTime);	       

	    }
	}


	@Override
	public String toString() {
		return "MovementRecord [id=" + id + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", vehicle="
				+ vehicle + "]";
	}


}
