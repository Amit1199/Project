package in.edac.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import in.edac.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Hospital findByHspUsernameAndHspPassword(String hspUsername,String hspPassword);	
}
