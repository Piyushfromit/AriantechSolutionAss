package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	
	@NotNull(message = "Name should Not be Null")
	private String name;
	
	
	@Email(message="Please provide a valid email address")
	private String mailId;
	
	
	@Size(min=0,max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobNo;
	private String address;
	

}
