package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Summary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="MovieID")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name="CreditID")
	private Credit credit;
	
	private Summary() {
		
	}

	public Summary(int id, Movie movie, Credit credit) {
		super();
		this.id = id;
		this.movie = movie;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	
}
