package com.kosta.day13;

public class Student {
	private String name;
	private String gender;
	private int score;
	
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	public Student(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", gender=").append(gender).append(", score=")
				.append(score).append("]");
		return builder.toString();
	}
	
	
}
