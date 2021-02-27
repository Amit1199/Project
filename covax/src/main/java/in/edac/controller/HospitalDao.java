package in.edac.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.edac.model.Hospital;
import in.edac.model.Patient;
import in.edac.repository.HospitalRepository;

@Controller
@RequestMapping("/hospital")
public class HospitalDao {


	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping("/login")
	  public ModelAndView Admin() {
		ModelAndView mv=new ModelAndView("HspLogin");
	  return mv;
	  }
	
	@PostMapping("/register")
	public void createPatient(Hospital hospital) {
		hospitalRepository.save(hospital);
	}
	
	@GetMapping("/AuthentHsplogin")
	public ModelAndView AuthenticateHospital(String hspUsername,String hspPassword) {	
		Hospital hospital=hospitalRepository.findByHspUsernameAndHspPassword(hspUsername, hspPassword);	
		if(hospital!=null) {
			ModelAndView mv=new ModelAndView("hospital");
			mv.addObject("hospital", hospital);
			return mv;
		}		
		else {
			ModelAndView mv=new ModelAndView("hspLogin");
			mv.addObject("HspLogFail", 0);
			return mv;
		}
	}
	
/*
	//update dr status			
	@PostMapping("/editDrStatus")
	  public ModelAndView editDrStatus(String drId,String hspId) {
		 int doctId=Integer.parseInt(drId);
		 //find doctor with given id and change its status
		 Doctor dbDr=doctorRepository.findById(doctId).get();
		 int hospId=Integer.parseInt(hspId);
		 Hospital hospital=hospitalRepository.findById(hospId).get();
		 //String hspUsername,String hspPassword
		// Hospital hospital=hospitalRepository.findByHspUsernameAndHspPassword(hspUsername, hspPassword);
		 if(dbDr.isDrStatus()==true) {
			 dbDr.setDrStatus(false);
			 doctorRepository.save(dbDr);
			 }
		 else {
			 dbDr.setDrStatus(true);
			 doctorRepository.save(dbDr);
		 }			 				 
			
		ModelAndView mv=new ModelAndView("hospital");	
		List<Doctor> drList=doctorRepository.findAll();
		mv.addObject("hospital", hospital);
		mv.addObject("drList", drList);
		mv.addObject("DRLIST", 1);
	    return mv;
	  }
			
		*/	
		
			
			
}
