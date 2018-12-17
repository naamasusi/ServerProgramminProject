package com.sportevent.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    //private String title;
	    private String location;
	    private String date;
	    private String time;
	    
	    @ManyToOne
	    @JsonIgnore
	    @JoinColumn(name = "categoryId")
	    private Category category;

	    public Event() {}

		public Event(String location, String date, String time, Category category) {
			super();
			this.location = location;
			this.date = date;
			this.time = time;
			this.category = category;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getLocation() {
			return location;
		}

		public void setlocation(String location) {
			this.location = location;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
		
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			if (this.category != null)
				return "Book [id=" + id + ", location=" + location + ", date=" + date + ", time=" + time + " category =" + this.getCategory() + "]";		
			else
				return "Book [id=" + id + ", location=" + location + ", date=" + date + ", time=" + time + "]";
		}
	}