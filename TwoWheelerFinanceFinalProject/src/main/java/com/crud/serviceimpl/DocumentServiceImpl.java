package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Document;
import com.crud.repository.DocumentRepository;
import com.crud.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	DocumentRepository dr;

	@Override
	public List<Document> savedoc(Document d) {
		// TODO Auto-generated method stub
				dr.save(d);
				List<Document>l1=dr.findAll();	
				return l1;
	}

	@Override
	public List<Document> getdoc() {
		// TODO Auto-generated method stub
		List<Document>l1=dr.findAll();	
		return l1;
	}

	@Override
	public void deletedocument(long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	
	@Override
	public void editdocument(long id, Document d) {
		// TODO Auto-generated method stub
		Optional<Document> d1=dr.findById(id);
		//dr.save(d1);
		
	}
	
	@Override
	public Optional<Document> editById(long id) {
		// TODO Auto-generated method stub
		return dr.findById(id);
	}

	
	@Override
	public Document updateData(long id, Document d) {
		
		// TODO Auto-generated method stub
		Document d1=dr.findById(id).get();
		return dr.save(d1);
	}


	


		

}
