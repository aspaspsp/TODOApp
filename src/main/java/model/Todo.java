package model;

import java.io.Serializable;

public class Todo implements Serializable {

	private String rank;
	private String content;
	private String deadline;

	public Todo(String rank2, String content2, String deadline2) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String text) {
		this.content = text;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}