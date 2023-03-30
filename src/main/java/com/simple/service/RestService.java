package com.simple.service;

import com.simple.model.Coche;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestService {

	List<Coche> listCoche = new ArrayList<>();


		public RestService(){
			methodCreation();
		}
	private void methodCreation(){
		for(int i=1; i<5; i++){
			listCoche.add(new Coche(i,"model-"+""+i+""));
		}

	}

	public String methodGet(int j){
			return listCoche.get(j).toString();
	}
	public List<Coche> methodGetAll(){
			return listCoche;

	}
}
