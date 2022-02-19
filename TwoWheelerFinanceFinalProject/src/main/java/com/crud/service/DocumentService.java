package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.Document;

public interface DocumentService {

	List<Document> savedoc(Document d);

	List<Document> getdoc();

	void deletedocument(long id);

	void editdocument(long id, Document d);

	Optional<Document> editById(long id);

	Document updateData(long id, Document d);
}
