package nutz.demo.mvc.pet;

import org.nutz.dao.entity.annotation.*;

@Table("t_pet")
public class Pet {

	@Column
	@Id
	private int id;

	@Column
	@Name
	private int name;

	@Column
	@NotNull
	private String race;

	@Column
	private int age;

	@Column("mid")
	private int masterId;

	@Column
	private String color;

	@One(target = Master.class, field = "masterId")
	private Master master;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

}
