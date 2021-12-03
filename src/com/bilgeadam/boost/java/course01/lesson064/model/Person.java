package com.bilgeadam.boost.java.course01.lesson064.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty            firstName;
	private StringProperty            lastName;
	private StringProperty            telephone;
	private StringProperty            street;
	private StringProperty            city;
	private IntegerProperty           zip;
	private ObjectProperty<LocalDate> birthday;

	public Person(String firstName, String lastName) {
		super();
		this.firstName.set(firstName);
		this.lastName.set(lastName);
	}

	public Person(String firstName, String lastName, String telephone, String street,
			String city, int zip, LocalDate birthday) {
		super();
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.telephone.set(telephone);
		this.street.set(street);
		this.city.set(city);
		this.zip.set(zip);
		this.birthday.set(birthday);
	}

	private Person(Builder builder) {
		this.firstName.set(builder.firstName);
		this.lastName.set(builder.lastName);
		this.telephone.set(builder.telephone);
		this.street.set(builder.street);
		this.city.set(builder.city);
		this.zip.set(builder.zip);
		this.birthday.set(builder.birthday);
	}

	public static class Builder { // inner class
		private String    firstName;
		private String    lastName;
		private String    telephone;
		private String    street;
		private String    city;
		private int       zip;
		private LocalDate birthday;

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder telephone(String telephone) {
			this.telephone = telephone;
			return this;
		}

		public Builder street(String street) {
			this.street = street;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		private Builder zip(int zip) {
			this.zip = zip;
			return this;
		}

		public Builder birthday(LocalDate birthday) {
			this.birthday = birthday;
			return this;
		}

		public Person build() {
			return new Person(this); // this bu (Builder) class'tan üretilmiþ bir nesne
		}
	}

	public String getFirstName() {
		return this.firstName.get();
	}

	public String getLastName() {
		return this.lastName.get();
	}

	public String getTelephone() {
		return this.telephone.get();
	}

	public String getStreet() {
		return this.street.get();
	}

	public String getCity() {
		return this.city.get();
	}

	public int getZip() {
		return this.zip.get();
	}

	public LocalDate getBirthday() {
		return this.birthday.get();
	}

}
