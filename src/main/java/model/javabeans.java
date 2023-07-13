package model;

import java.io.Serializable;

public class javabeans implements Serializable {
	private double pirority, content, deadline;

	public double getpirority() {
		return pirority;
	}

	public void setpirority(double pirority) {
		this.pirority = pirority;
	}

	public double getcontent() {
		return content;
	}

	public void setcontent(double content) {
		this.content = content;
	}

	public double getdeadline() {
		return this.deadline;
	}

	public void setdeadline(double deadline) {
		this.deadline = deadline;
	}
}
