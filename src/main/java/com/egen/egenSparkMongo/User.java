package com.egen.egenSparkMongo;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateCreated;
	private String profilePic;
	private String street;
	private String state;
	private String city;
	private String country;
	private int zip;
	private String cName;
	private String cWebsite;
	private BasicDBObject address;
	private BasicDBObject company;

	public User() {
	}
	
	public User(BasicDBObject dbObject) {
		this.id = ((ObjectId) dbObject.get("_id")).toString();
		this.firstName = dbObject.getString("firstName");
		this.lastName = dbObject.getString("lastName");
		this.email = dbObject.getString("email");
		this.dateCreated = dbObject.getDate("dateCreated");
		this.profilePic = dbObject.getString("profilePic");
		this.address = (BasicDBObject) dbObject.get("address");
		this.company = (BasicDBObject) dbObject.get("company");
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcWebsite() {
		return cWebsite;
	}

	public void setcWebsite(String cWebsite) {
		this.cWebsite = cWebsite;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public String getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

}

/*
 * 
 * sample user object
 * 
 * 
 {
	"firstName":"Bhavin",
	"lastName":"Desai",
	"email":"bdesai@ghmai.com",
	"profilePic":"img/allpics/profile/pic1.jpg",
	"street":"2901 S King Drive",
	"city":"Chicago",
	"zip": 60616,
	"state":"IL",
	"country":"USA",
	"cName":"Egen",
	"cWebsite":"egen.com"
}
*/
