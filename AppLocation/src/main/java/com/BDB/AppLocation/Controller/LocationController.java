package com.BDB.AppLocation.Controller;


import com.BDB.AppLocation.Dto.ResponseDto;
import com.BDB.AppLocation.Entity.Location;
import com.BDB.AppLocation.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
@CrossOrigin("http://localhost:4200")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/list")
    public ResponseEntity<List<Location>> list(){
        List<Location> l =locationService.listLocations();
        return new ResponseEntity(l, HttpStatus.OK);
    }

    @PostMapping("/createLocation")
    public ResponseEntity<?> createLocation(@RequestBody Location l){
        if (l.getName() == null || l.getArea_m2() <0 ||l.getName().length() == 0){
            return new ResponseEntity( new ResponseDto("DATA Invalided", false), HttpStatus.BAD_REQUEST);
        }
        Location loc = new Location(l.getId(),l.getName(),l.getArea_m2());

        locationService.createLocation(loc);

        return new ResponseEntity( new ResponseDto("Location Create Success", true), HttpStatus.CREATED);
    }

    @PutMapping("/actualizarLocation/{id}")
    public ResponseEntity<?> UdtLocation(@PathVariable("id")int id, @RequestBody Location l){

        if(!locationService.existsLocation(id)){
            return new ResponseEntity( new ResponseDto("ID NOT FOUND", false), HttpStatus.NOT_FOUND);
        }

        Location loc =  locationService.getlocation(id).get();

        loc.setId(l.getId());
        loc.setName(l.getName());
        loc.setArea_m2(l.getArea_m2());

        locationService.createLocation(loc);

        return  new ResponseEntity(new ResponseDto("Update Correct", true), HttpStatus.OK);
    }

    @DeleteMapping("/deleteLocation/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id")int id){
        if(!locationService.existsLocation(id)){
            return new ResponseEntity( new ResponseDto("ID NOT FOUND", false), HttpStatus.NOT_FOUND);
        }else{
            locationService.deleteLocation(id);
            return new ResponseEntity( new ResponseDto("Location Delete Success", true), HttpStatus.OK);
        }
    }
}
