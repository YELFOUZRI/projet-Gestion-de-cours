package com.doranco.projet;


import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.doranco.projet.model.Admin;
import com.doranco.projet.model.ClassRoom;
import com.doranco.projet.model.Establishment;
import com.doranco.projet.model.Instructor;
import com.doranco.projet.repositories.IAdminRepository;
import com.doranco.projet.repositories.IClassRoomRepository;
import com.doranco.projet.repositories.IEstablishmentRepository;
import com.doranco.projet.repositories.IInstructorRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{ 
	


	 @Autowired
	 private IAdminRepository ar;
	 @Autowired
	 private IEstablishmentRepository er;
	 @Autowired
	 private IClassRoomRepository crr; 
	 @Autowired
	 private IInstructorRepository ir;
	

	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args); 
	}

	@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("1234");

		
		ar.save(new Admin(null, "admin", "admin", null, "admin", "admin", "admin", "admin", hashedPassword, "admin", true));
		
		 
		Establishment estab1 = new Establishment(null, "DIDEROT1", "1 Rue Dombasle", "93100", "MONTREUIL", "COLLEGE", null, null, null);
		Establishment estab2 = new Establishment(null, "DIDEROT2", "1 Rue Dombasle", "93100", "MONTREUIL", "LYCEE", null, null, null);
		Establishment estab3 = new Establishment(null, "DIDEROT3", "1 Rue Dombasle", "93100", "MONTREUIL", "FACULTE", null, null, null);
		
		er.save(estab1);
		er.save(estab2);
		er.save(estab3);
				
		crr.save(new ClassRoom(null, "001", "25", estab1 , null));
		crr.save(new ClassRoom(null, "002", "30", estab2 , null));
		crr.save(new ClassRoom(null, "003", "35", estab3 , null));
			
		
		ir.save(new Instructor(null, "RAZOUI", "WALID", LocalDate.of(1988, 01, 01), "44 avenue de Clichy", "75018", "Paris", "walid@gmail.com", passwordEncoder.encode("1234"), "0000000000", true, "Mathématique", null, null, null, null, estab1)); 		
		ir.save(new Instructor(null, "ALI", "Mohammed", LocalDate.of(1985, 01, 01), "5 Rue des ROCHES", "93100", "Montreuil", "mohammed@gmail.com", passwordEncoder.encode("1234"), "0000000000",true, "Francais", null, null, null, null, estab2)); 
		ir.save(new Instructor(null, "HAMDI", "Sonia", LocalDate.of(1992, 01, 01), "43 avenue de la République", "92120", "Montrouge", "sonia@gmail.com", passwordEncoder.encode("1234"), "0000000000",true, "Anglais", null, null, null, null, estab3)); 
		
		
	}
 
}
