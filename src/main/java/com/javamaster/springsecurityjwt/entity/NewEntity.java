package com.javamaster.springsecurityjwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "new_table")
public class NewEntity extends BaseEntity {
	
	@Column(name = "title")
	private String title;

	@Column(name = "shortdescription")
	private String shortDescription;

	@Column(name = "content")
	private String Content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private CategoryEntity category;

    public NewEntity () {
    	
    }
    
    public NewEntity(String title, String shortDescription, String Content, CategoryEntity category) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.Content = Content;
        this.category = category;
    }
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	
	
	
	
	
}
