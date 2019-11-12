package com.techelevator.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Song {
	private Long id;
	@NotBlank(message="Please specify an artist")
	@Size(max=255, message="Artist name cannot be over 255 characters")
	private String artist;
	@NotBlank(message="Please specify a title")
	@Size(max=255, message="Title cannot be over 255 characters")
	private String title;
	@Size(max=255, message="Album cannot be over 255 characters")
	private String album;
	private boolean known;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public boolean isKnown() {
		return known;
	}
	public void setKnown(boolean known) {
		this.known = known;
	}
	
}
