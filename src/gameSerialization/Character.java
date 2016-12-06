package gameSerialization;

import java.beans.Transient;
import java.io.Serializable;

public class Character implements Serializable {

	private String name;
	private String strength;
	
	//transient mean - variables value wouldn't be serializebled and saved
	transient private int age;
	public Character(String name, String strength, int age) {
		super();
		this.name = name;
		this.strength = strength;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", strength=" + strength + ", age="
				+ age + "]";
	}
	
	
}
