package entity;

import java.util.List;

public class Member {
	
	private String name;
	private String occupation;
	private List<String> favoriteLessons;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public List<String> getFavoriteLessons() {
		return favoriteLessons;
	}
	public void setFavoriteLessons(List<String> favoriteLessons) {
		this.favoriteLessons = favoriteLessons;
	}

}
