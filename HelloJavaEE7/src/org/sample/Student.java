package org.sample;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQuery(name="findAllStudents", query="select s from Student s")
public class Student implements Serializable {

	@Id
	private long id;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Student(long id) {
		this.id = id;
	}
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return "Student[" + id + "]";
	}
}
