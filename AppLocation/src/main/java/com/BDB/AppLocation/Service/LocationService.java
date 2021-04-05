package com.BDB.AppLocation.Service;

import com.BDB.AppLocation.Entity.Location;
import com.BDB.AppLocation.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> listLocations(){
        return locationRepository.findAll();
    }

    public void createLocation(Location l){
        locationRepository.save(l);
    }

    public Optional<Location> getlocation(int id){
        return locationRepository.findById(id);
    }

    public boolean existsLocation(int id){
        return locationRepository.existsById(id);
    }

    public void deleteLocation(int id){
        locationRepository.deleteById(id);
    }
}
