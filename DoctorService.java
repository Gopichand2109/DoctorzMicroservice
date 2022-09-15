package com.doctor.microservice.service;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.doctor.microservice.dto.UserRequest;
//import com.doctor.microservice.exception.UserNotFoundException;
import com.doctor.microservice.model.Doctor;
import com.doctor.microservice.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorrepository;


	public List<Doctor> saveDoctors(List<Doctor> doctor) {
		return doctorrepository.saveAll(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorrepository.findAll();
	}

	public Doctor getDoctorById(int id) {
		
		return doctorrepository.findById(id).orElse(null);
	}

	public String deleteDoctor(int id) {
		doctorrepository.deleteById(id);
		return "Removed from List"+ id;
	}
	public Doctor updateDoctor(Doctor doctor) {
	
		return doctorrepository.save(doctor);
		
	}

	public List<Doctor> getDoctorByDepartment(String department) {
	
	return doctorrepository.getDoctorByDepartment(department);
	}

	public Doctor saveDoctor(Doctor doctor) {
	
		return doctorrepository.save(doctor);
	}

	public ResponseEntity <String> saveDoctor1(@Valid Doctor doctor) {

		doctorrepository.save(doctor);
		return ResponseEntity.ok("User data is valid");
	}

	
	  public Doctor getDoctorByName(String name) {
	  
	 return doctorrepository.getDoctorByName(name);
	 }
	 

/*
 * public List<Doctor> getALlUsers() { return doctorrepository.findAll(); }
 * 
 */
/*
 * public Doctor getDoctorById1(int id) throws UserNotFoundException { Doctor
 * user= doctorrepository.findByUserId(id); if(user!=null){ return user; }else{
 * throw new UserNotFoundException("user not found with id : "+id); } }
 */
 
  
/*
 * public Doctor saveDoctor1(@Valid UserRequest userRequest) {
 * 
 * Doctor user =
 * Doctor.build(0,userRequest.getDoctorName(),userRequest.getDoctorDegree(),
 * userRequest.getDoctorDepartment(),userRequest.getDoctorRole(),userRequest.
 * getPatientId(), userRequest.getAppointmentId()); return
 * doctorrepository.save(user); }
 */

 }
 

