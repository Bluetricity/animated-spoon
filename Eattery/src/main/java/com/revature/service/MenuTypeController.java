package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.revature.beans.Menu_Type;
import com.revature.data.hibernate.MenuTypeOracle;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/Menu_Type")
public class MenuTypeController {
	@Autowired
	private MenuTypeOracle CO;
	
	@GetMapping
	public Set<Menu_Type> getMenuTypes(){
		return CO.getMenuTypes();
	}
	
	@GetMapping(value="{id}")
	public Menu_Type getMenuType(@PathVariable Integer id) {
		return CO.getMenuType(id);
	}
	
	@PostMapping
	public Menu_Type addMenuType (@RequestBody Menu_Type mt) {
		System.out.println(mt);
		CO.addMenuType(mt);
		return mt;
	}
	
	@PostMapping(value="/string")
	public String addMenuType(@RequestBody String mt) {
		System.out.println(mt);
		
		return mt;
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Menu_Type> deleteMenuType(@PathVariable Integer id){
		if(CO.getMenuType(id)==null) {
			return ResponseEntity.status(405).build();
		}
		CO.deleteMenuType(CO.getMenuType(id));
		return ResponseEntity.noContent().build();
	}
}
