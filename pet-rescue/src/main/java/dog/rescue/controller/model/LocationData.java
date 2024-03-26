package dog.rescue.controller.model;

import java.util.HashSet;
import java.util.Set;

import dog.rescue.entity.Breed;
import dog.rescue.entity.Dog;
import dog.rescue.entity.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationData {

	private Long locationId;
	private String buisnessName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;
	// we will defined DogData in this class
	private Set<DogData> dogs = new HashSet<>();

	// Constructor for LocationData
	public LocationData(Location location) {
		this.locationId = location.getLocationId();
		this.buisnessName = location.getBuisnessName();
		this.streetAddress = location.getStreetAddress();
		this.city = location.getCity();
		this.state = location.getState();
		this.zip = location.getZip();
		this.phone = location.getPhone();

		// I want to set the dog data. therefore, I will set does base on Dog object
		for (Dog dog : location.getDogs()) {
			this.dogs.add(new DogData(dog));
		}
	}
	
	// constructor that will take the location variables
	// we are passing all the fields except for the dogs fields
	public LocationData(Long locationId, String buisnessName, String streetAddress, String city, String state,
			String zip, String phone) {

		this.locationId = locationId;
		this.buisnessName = buisnessName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;

	}
	
	// We need to convert from LocationData Object to Location Object
	public Location toLocation() {
		Location location = new Location();
		//set all the fields
		location.setLocationId(locationId);
		location.setBuisnessName(buisnessName);
		location.setStreetAddress(streetAddress);
		location.setCity(city);
		location.setState(state);
		location.getZip();
		location.getPhone();
		
		//set teh dogs
		for (DogData dogData : dogs) {
			location.getDogs().add(dogData.toDog());
		}
		
		return location;
	}
	
	// Dog data used in the Set
	@Data
	@NoArgsConstructor
	public class DogData {

		private Long dogId;
		private String name;
		private int age;
		private String color;
		// we will be using BreedData
		private Set<BreedData> breeds = new HashSet<>();

		// Create a DogData constructor that take a Dog Object
		public DogData(Dog dog) {
			this.dogId = dog.getDogId();
			this.name = dog.getName();
			this.age = dog.getAge();
			this.color = dog.getColor();
			
			for (Breed breed : dog.getBreeds()) {
				this.breeds.add(new BreedData(breed));
			}

		}

		public Dog toDog() {
			Dog dog = new  Dog();
			dog.setDogId(dogId);
			dog.setName(name);
			dog.setAge(age);
			dog.setColor(color);
			dog.setName(name);
			
			//set Breeds
			for(BreedData breeData : breeds ) {
				dog.getBreeds().add(breeData.toBreed());
			}
			
			return dog;
		}

	}//end of DogData class

	@Data
	@NoArgsConstructor
	public class BreedData {
		private Long breedId;
		private String name;

		// BReeddata constructor that takes a breed
		public BreedData(Breed breed) {
			this.breedId = breed.getBreedId();
			this.name = breed.getName();

		}

		public Breed toBreed() {
			Breed breed = new Breed();

			// fill in instance variables
			breed.setBreedId(breedId);
			breed.setName(name);

			return breed;

		}

	}// end of BreedData class

}//end of LocationData class
