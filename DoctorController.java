package com.doctor.microservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;*/
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.doctor.microservice.dto.UserRequest;
import com.doctor.microservice.model.Doctor;
import com.doctor.microservice.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService service;
	
	@PostMapping("/addDoctor1")
	public ResponseEntity <String> addUser(@RequestBody @Valid Doctor doctor){
		return service.saveDoctor1(doctor);
	}
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor){
		return service.saveDoctor(doctor);
	}
	@PostMapping("/addDoctors")
	public List<Doctor> addDoctors(@RequestBody List<Doctor> doctor){
		return service.saveDoctors(doctor);
		
	}
	@GetMapping("/doctorlist")
	public List<Doctor> getAllDocotrs(){
		return service.getAllDoctors();
	}
	@GetMapping("/doctorbyid/{id}")
	public Doctor findDoctorById(@PathVariable int id) {
        return service.getDoctorById(id);
    }
	@GetMapping("/doctorbydepartment/{department}")
	public List<Doctor> findDoctorByDepartemnt(@PathVariable String department)
	{
		return service.getDoctorByDepartment(department);
	}
	
	
	 @GetMapping("/doctorbyname/{name}") 
	 public Doctor findDoctorByName(@PathVariable String name) { return
	 service.getDoctorByName(name);
	 }
	 
	
	@PutMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return service.updateDoctor(doctor);
    }
	 @DeleteMapping("/delete/{id}")
	  public String deleteDoctor(@PathVariable int id) {
	        return service.deleteDoctor(id);
	   }
		/*
		 * @PostMapping("/signup") public ResponseEntity<Doctor>
		 * saveDoctor1(@RequestBody @Valid UserRequest userRequest){ return new
		 * ResponseEntity<>(service.saveDoctor1(userRequest), HttpStatus.CREATED); }
		 */
		
		 /* @GetMapping("/fetchAll") public ResponseEntity<List<Doctor>> getAllDoctors(){
		 * return ResponseEntity.ok(service.getAllDoctors()); }
		 * 
		 * @GetMapping("/{id}") public ResponseEntity<Doctor> getUser(@PathVariable int
		 * id) throws UserNotFoundException { return
		 * ResponseEntity.ok(service.getDoctorById(id)); }
		 */
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
			Map<String, String> errors = new HashMap<>();

			ex.getBindingResult().getFieldErrors().forEach(error -> 
				errors.put(error.getField(), error.getDefaultMessage()));
			
			return errors;
		}
}
