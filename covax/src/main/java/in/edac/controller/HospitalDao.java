package in.edac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.edac.model.Hospital;
import in.edac.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	@PostMapping("/register")
	public void createPatient(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	@GetMapping("/login")
	public ModelAndView Admin() {
		ModelAndView mv = new ModelAndView("HspLogin");
		return mv;
	}

	@GetMapping("/view")
	public List<Hospital> getUsers() {

		return hospitalRepository.findAll(Sort.by(Direction.DESC, "hspId"));
	}

	@PutMapping("/{hspId}")
	public boolean updateUser(@PathVariable int hspId, @RequestBody Hospital hospital) {
		// userRepository.save(user);

		hospitalRepository.save(hospital);

		return true;
	}

	@DeleteMapping("/{hspId}")
	public boolean deleteUser(@PathVariable int hspId) {
		hospitalRepository.deleteById(hspId);
		return true;
	}

	@PostMapping("/AuthentHsplogin")
	public ModelAndView AuthenticateHospital(String hspUsername, String hspPassword) {
		Hospital hospital = hospitalRepository.findByHspUsernameAndHspPassword(hspUsername, hspPassword);
		if (hospital != null) {
			ModelAndView mv = new ModelAndView("hospital");
			mv.addObject("hospital", hospital);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("hspLogin");
			mv.addObject("HspLogFail", 0);
			return mv;
		}
	}

}
