package com.qa.persistence.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "question_index", type = "question")
public class Question {

	@Id
	private long id;

	private String question;

	@Field(type = FieldType.Nested)
	private List<Answer> answers;

	public Question(String question, List<Answer> answers) {
		this.question = question;
		this.answers = answers;
	}

	public Question() {

	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
