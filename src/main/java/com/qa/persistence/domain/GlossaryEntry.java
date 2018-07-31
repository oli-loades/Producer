package com.qa.persistence.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "glossary_index", type = "glossary")
public class GlossaryEntry {
	@Id
	private int id;
	private String keyword;
	private String definition;
	
	public GlossaryEntry(String keyword, String definition) {
		this.keyword = keyword;
		this.definition = definition;
	}
	
	public GlossaryEntry() {
		
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
