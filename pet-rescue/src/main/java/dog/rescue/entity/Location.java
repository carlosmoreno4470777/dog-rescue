package dog.rescue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


//lombok annotation to create getters and setters plus to string, equals and hash code 
@Entity
@Data
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	
	private String buisnessName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;


	//Because of the one to Many relationship with Dogs. we have to use a set of dogs
	//We are going to defined the owning side of the one to many relationship with annotation OneToMany
	//If we delete a location all dogs data will be remove. using orphan removal 
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<Dog> dogs = new HashSet<>();
		
	
}
