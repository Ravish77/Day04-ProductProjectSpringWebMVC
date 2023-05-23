package com.telusko.SpringWebProductProject;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductService {
	
//	List<Product> products = new ArrayList<>();
	
	@Autowired
	ProductDB db;
	
	public void addProduct(Product p) {
		db.save(p);
	}
	
	public List<Product> getAllProducts(){
		return db.findAll();
	}
	
	public Product getProduct(String name) {
		return db.findByName(name);
	}
	
	public List<Product> getProductWithText(String text) {
		List<Product> allProducts=db.findAll();
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : allProducts){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;

    }
	
	
	
	
	//Return Products searched by place 
	public List<Product> getProductWithPlace(String text) {
		List<Product> allProducts=db.findAll();
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : allProducts){
            String place = p.getPlace().toLowerCase();
            if( place.contains(str))
                prods.add(p);
        }
        return prods;

    }	
	
	
	
	
	public List<Product> getProductWithExpiredWarranty(){
		List<Product> allProducts=db.findAll();
		List<Product> proudctsWIthExpiredWarranty=new ArrayList<>();

		for(Product p:allProducts)
		{
			if(p.getWarranty()<Year.now().getValue())
			{
				proudctsWIthExpiredWarranty.add(p);
		
			}
		}
		return proudctsWIthExpiredWarranty;

	}
	
}
   