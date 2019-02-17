package com.ivo.pkg;

public class UserBean {
int Id;
String FirstName="";
String LastName="";
String BirthDate;
String Phone="";
String Email="";
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public  String getBirthDate() {
	return BirthDate;
}
public void setBirthDate(String birthDate) {
	BirthDate = birthDate;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
