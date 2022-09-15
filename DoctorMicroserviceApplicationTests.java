package com.doctor.microservice.DoctorMicroservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import com.doctor.microservice.model.Doctor;
import com.doctor.microservice.repository.DoctorRepository;

@SpringBootTest
class DoctorMicroserviceApplicationTests {

	@Autowired
	DoctorRepository doctorrepository;

	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateDoctor() {
		Doctor d = doctorrepository.save(
				new Doctor(15,"M Gopichand","MBBS","General Medicine","Physician",10,10));
		assertThat(d.getDoctorId()).isGreaterThan(0);
	}

		@Test
		@Order(2)
	 public void testReadAllDoctor() { 
		 List<Doctor> d = doctorrepository.findAll(); 
		 assertThat(d).size().isGreaterThan(0); 
		 }
		@Test
		@Order(4)
		public void testUpdateDoctor() {
			Doctor d = doctorrepository.getDoctorByName("M Gopichand");
			d.setDoctorRole("Consultant");
			doctorrepository.save(d);
			
			Doctor ud = doctorrepository.getDoctorByName("M Gopichand");
			assertThat(ud.getDoctorRole()).isEqualTo("Consultant");
		}
		@Test
		@Rollback(false)
		@Order(6)
		public void testDeleteDoctor() {
			Doctor d = doctorrepository.getDoctorByName("M Gopichand");
			doctorrepository.deleteById(d.getDoctorId());
			Doctor ud = doctorrepository.getDoctorByName("M Gopichand");
			assertThat(ud).isNull();
		}
}
