package com.doctor.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Doctors_data")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	@Column
	@NotNull(message="DoctorName should not be null")
	private String doctorName;
	@Column
	@NotNull(message="DoctorDegree should not be null")
	private String doctorDegree;
	@Column
	@NotNull(message="DoctorDepartment should not be null")
	private String doctorDepartment;
	@Column
	@NotNull(message="DoctorRole should not be null")
	private String doctorRole;
	@Column
	@NotNull(message="PatientId should not be null")
	@Min(1)
	@Max(100)
	private int patientId;
	@Column
	@NotNull(message="AppointmentId should not be null")
	@Min(1)
	@Max(100)
	private int appointmentId;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDegree() {
		return doctorDegree;
	}
	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
	}
	public String getDoctorDepartment() {
		return doctorDepartment;
	}
	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}
	public String getDoctorRole() {
		return doctorRole;
	}
	public void setDoctorRole(String doctorRole) {
		this.doctorRole = doctorRole;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Doctor(int doctorId, String doctorName, String doctorDegree, String doctorDepartment, String doctorRole,
			int patientId, int appointmentId) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorDegree = doctorDegree;
		this.doctorDepartment = doctorDepartment;
		this.doctorRole = doctorRole;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public static Doctor build(int doctorId,String doctorName, String
	 * doctorDegree, String doctorDepartment, String doctorRole, int patientId, int
	 * appointmentId) { return new Doctor(doctorId,doctorName,doctorDegree,
	 * doctorDepartment, doctorRole,patientId,appointmentId); }
	 */
}
