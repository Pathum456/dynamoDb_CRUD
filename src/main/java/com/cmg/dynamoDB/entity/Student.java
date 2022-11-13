package com.cmg.dynamoDB.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Student")
public class Student {
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	
	@DynamoDBAttribute
	private String name;
	
	@DynamoDBAttribute
	private String address;

	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String mobile;


	public Student(String id, String name, String address, String email, String mobile) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	
	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
