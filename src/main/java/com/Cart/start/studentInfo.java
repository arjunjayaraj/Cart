package com.Cart.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_info")
public class studentInfo {

	@Id @GeneratedValue
	private int rollNo;
	private String name;

	@Column(name="NAME")
	public final int getRollNo() {
		return rollNo;
	}
	public final void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}

}
