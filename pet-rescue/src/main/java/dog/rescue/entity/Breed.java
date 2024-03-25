package dog.rescue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Breed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long breedId;
	
	private String name;
	
	//Recursive attribute that points to Dog that Spring is going to utilize to build the tables.
	//This is a Many to Many relationship therefore we have to specify the name of the java fields in the java class Dog fields breeds
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "breeds" )
	private Set<Dog> dogs = new HashSet<>();


}
