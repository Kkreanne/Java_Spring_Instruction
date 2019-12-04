package com.customer.service.CS;

import javax.persistence.*;

@Entity
@Table
public class CS {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30, nullable=false)
	private String name;
	@Column(columnDefinition="decimal(10,2) NOT NULL DEFAULT 0.0")
	private double sales;
	@Column(name="isActive")
	private boolean Active;

	public CS() {
		
	}

	public CS(int id, String name, double sales, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.sales = sales;
		Active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	@Override
	public String toString() {
		return "CS [id=" + id + ", name=" + name + ", sales=" + sales + ", Active=" + Active + "]";
	}
}
