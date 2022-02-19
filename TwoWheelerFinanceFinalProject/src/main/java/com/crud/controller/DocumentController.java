package com.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.model.Document;
import com.crud.service.DocumentService;
import com.google.gson.Gson;

@CrossOrigin("*")
@RestController
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	DocumentService ds;
	
	 @RequestMapping(value="/adddoc" ,method=RequestMethod.POST ,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)//http://localhost:9027/document/adddoc
		public List<Document> m1( @RequestPart(required=true, value="aadharCard")MultipartFile files1,
				                  @RequestPart(required=true, value="pancard")MultipartFile files2,
				                  @RequestPart(required=true, value="addressProof")MultipartFile files3,
				                  @RequestPart(required=true, value="incomeProof")MultipartFile files4,
				                  @RequestPart(required=true, value="cancledCheque")MultipartFile files5,
				                  @RequestPart(required=true, value="photo")MultipartFile files6,
				                  @RequestPart("doc")String doc
				                  
				       		)throws IOException{ 
	    	
	    	System.out.println(files1.getOriginalFilename());
	    	System.out.println(files1.getSize());
	    		System.out.println(files1.getBytes());
	    		System.out.println(files1.getContentType());
	    		//System.out.println(doc);
	    		Document d=new Document();
	    		d.setAadharCard(files1.getBytes());
	    		d.setPancard(files2.getBytes());
	    		d.setAddressProof(files3.getBytes());
	    		d.setIncomeProof(files4.getBytes());
	    		d.setCancledCheque(files5.getBytes());
	    		d.setPhoto(files6.getBytes());
	    		
	    		//Gson gson =new Gson();
	    		//Document d1=gson.fromJson(doc, Document.class);
	    				//System.out.println(d1.getDoc_id());
	    		//d.setDoc_id(d1.getDoc_id());
	    		
	    		
	    		Gson gson =new Gson();
	    	    Document d1=gson.fromJson(doc, Document.class);
	    				System.out.println(d1.getCust_primary_id());
	    		d.setCust_primary_id(d1.getCust_primary_id());
	    		System.out.println(d);
	    		
	    		//Document d2=ds.savedocument(d);
	    		//return d1;
	    		List<Document> list=ds.savedoc(d);
	    		return list;
	    	}
	 
	 @GetMapping("/files")
		public List<Document> getfiles(){
			return ds.getdoc();
		}

	 	@DeleteMapping("/deletefile/{doc_id}")
	 	public String deleteDoc(@PathVariable("doc_id")long id) {
		 	ds.deletedocument(id);
		 	return "document deleted successfully";
	 	}
	 
	 	@PutMapping("/updatedocuments/{doc_id}")
	 	public String updateDoc(@PathVariable("doc_id")long id,@RequestBody Document d)
	 	{
		 ds.editdocument(id, d);
		 return "updated successfully";
	 	} 	
	 	
	 	
	 	@PutMapping("/updateDocById/{doc_id}")
	 	public String updateDocById(@PathVariable ("doc_id") long id, @RequestBody Document d) 
	 	{
	 		Optional<Document> up=ds.editById(id);	
	 		Document dt=ds.updateData(id, d);
	 		
	 		
	 		return "updated Successfully";
	 	}

}