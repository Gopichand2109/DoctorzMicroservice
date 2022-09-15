package com.doctor.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doctor.microservice.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	@Query(value="select * from doctors_data where doctor_department=:department", nativeQuery=true)
	List<Doctor> getDoctorByDepartment(@Param("department") String department);

	@Query(value="select * from doctors_data where doctor_name=:name", nativeQuery=true)
	Doctor getDoctorByName(@Param("name") String name);

	
	
}

