package dog.rescue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dog.rescue.controller.model.LocationData;
import dog.rescue.dao.LocationDao;
import dog.rescue.entity.Location;

@Service
public class RescueService {
	
	@Autowired
	private LocationDao locationDao;

	@Transactional(readOnly = false)
	public LocationData saveLocation(LocationData locationData) {
		//from location data to location entity
		Location location = locationData.toLocation();
		Location dbLocation = locationDao.save(location);

		//Constructor that will use the location and convert to locationData 
		return new LocationData(dbLocation);
	}

}
