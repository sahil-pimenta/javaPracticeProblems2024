package designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

public class Builder {

	public static void main(String[] args) {
		Director director = new Director(new MBAStudent());
		System.out.println(director.getStudentObj().toString());

	}
}

class Director {
	private StudentBuilder sb;

	public Director(StudentBuilder sb) {
		this.sb = sb;
	}

	public Student getStudentObj() {
		if (sb instanceof EngStudent) {
			return createEngStudent();
		} else if (sb instanceof MBAStudent) {
			return createMBAStudent();
		}

		return null;
	}

	private Student createEngStudent() {
		return sb.setAge(10).setName("Sahil").setRollNo(28).setSubjects().build();
	}

	private Student createMBAStudent() {
		return sb.setAge(22).setName("James").setRollNo(40).setSubjects().build();
	}

}

abstract class StudentBuilder {
	public String name;
	public int rollNo;
	public int age;
	public List<String> subjects;

	public StudentBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public StudentBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public StudentBuilder setRollNo(int rollNo) {
		this.rollNo = rollNo;
		return this;
	}

	public abstract StudentBuilder setSubjects();

	public Student build() {
		return new Student(this);
	}

}

class EngStudent extends StudentBuilder {
	@Override
	public StudentBuilder setSubjects() {
		List<String> subjects = new ArrayList<String>();
		subjects.add("A");
		subjects.add("B");
		subjects.add("C");
		this.subjects = subjects;
		return this;
	}

}

class MBAStudent extends StudentBuilder {
	@Override
	public StudentBuilder setSubjects() {
		List<String> subjects = new ArrayList<String>();
		subjects.add("D");
		subjects.add("E");
		subjects.add("F");
		this.subjects = subjects;
		return this;
	}
}

//Final Product Class
class Student {
	private String name;
	private int rollNo;
	private int age;
	private List<String> subjects;

	public Student(StudentBuilder sb) {
		this.name = sb.name;
		this.rollNo = sb.rollNo;
		this.age = sb.age;
		this.subjects = sb.subjects;
	}

	public String toString() {
		return "Name:" + name + "| roll no:" + rollNo + "| age:" + age + "| subjects:" + subjects.get(0) + ","
				+ subjects.get(1) + "," + subjects.get(2);
	}
}