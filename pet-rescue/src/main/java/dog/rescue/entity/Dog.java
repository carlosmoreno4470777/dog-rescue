package dog.rescue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Dog {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dogId;
	
	//exclude from the .Equals and hash methods when lombok when is creating the tables using annotation @@EqualsAndHashCode
	
	@EqualsAndHashCode.Exclude
	private String name;
	
	@EqualsAndHashCode.Exclude
	private int age;
	
	@EqualsAndHashCode.Exclude
	private String color;
	
	//We need to point back to the Location class because of the Many to one relationship Dog is is a child of Location table
	//exclude recursive fields from the tostring 
	//Location has a set of Dogs in the Many to one which is the owned side of the relationship
	//Since we create the tables from Spring we need to specify a join column 
	//if we have a Dog we must have a Locatoin therefore nullable is not permited  
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	 //We also have a many to many relationship with class Breed
	//exclude recursive fields from the tostring 
	//JPA need the owning side annotation 
	//We don't want to delete from rows Dog table but we do want to delete from join table
	//the name of the join that we are creating is the table dog_breed
	//the join column is the dog_id
	// the inverse of that join table is teh breed_id
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "dog_breed",
			joinColumns = @JoinColumn(name = "dog_id"),
			inverseJoinColumns = @JoinColumn(name = "breed_id")
			)
	private Set<Breed> breeds = new HashSet<>();
	
	
	
}
