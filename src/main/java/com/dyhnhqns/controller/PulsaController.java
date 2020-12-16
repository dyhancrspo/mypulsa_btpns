package com.dyhnhqns.controller;

import com.dyhnhqns.model.PulsaIndosat;
import com.dyhnhqns.model.PulsaTelkomsel;
import com.dyhnhqns.model.PulsaXL;
import com.dyhnhqns.repository.PulsaIndosatRepository;
import com.dyhnhqns.repository.PulsaTelkomselRepository;
import com.dyhnhqns.repository.PulsaXLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PulsaController {

//    public static final Logger logger = LoggerFactory.getLogger(PulsaController.class);

    @Autowired
    PulsaTelkomselRepository pulsaTelkomselRepository;

    @Autowired
    PulsaIndosatRepository pulsaIndosatRepository;

    @Autowired
    PulsaXLRepository pulsaXLRepository;


//-------------------------------- Pulsa Telkomsel --------------------------------------
    @GetMapping("pulsa/telkomsel")
    public ResponseEntity<List<PulsaTelkomsel>> getTelkomsel(@RequestParam(required = false) String args) {
        try {
            List<PulsaTelkomsel> pulsaTelkomsels = new ArrayList<>();
            pulsaTelkomselRepository.findAll().forEach(pulsaTelkomsels::add);
            if (pulsaTelkomsels.isEmpty()) {
                return new ResponseEntity<>(pulsaTelkomsels, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pulsaTelkomsels, HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR! on get -telkomsel : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pulsa/telkomsel/{phoneNumber}")
    public ResponseEntity<PulsaTelkomsel> getTelkomselById(@PathVariable("phoneNumber") String phoneNumber) {
        try {
            Optional<PulsaTelkomsel> dataTelkomsel = pulsaTelkomselRepository.findById(phoneNumber);
//            logger.info("Fetching telkomsel bills with phoneNumber {}", dataTelkomsel.toString());
            if (dataTelkomsel.isPresent()) {
                return new ResponseEntity<>(dataTelkomsel.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("ERROR! on getById -telkomsel : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pulsa/telkomsel")
    public ResponseEntity<PulsaTelkomsel> createTelkomsel(@RequestBody PulsaTelkomsel pulsaTelkomsel) {
        try {
            PulsaTelkomsel dataTelkomsel = pulsaTelkomselRepository.save(pulsaTelkomsel);
//            logger.info("Create telkomsel bills with phoneNumber {}", dataTelkomsel.toString());
            return new ResponseEntity<>(dataTelkomsel,HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("ERROR! on post -telkomsel : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pulsa/telkomsel/{phoneNumber}")
    public ResponseEntity<PulsaTelkomsel> updateTelkomsel (@PathVariable("phoneNumber") String phoneNumber, @RequestBody PulsaTelkomsel pulsaTelkomsel) {
        try {
            Optional<PulsaTelkomsel> telkomselData = pulsaTelkomselRepository.findById(phoneNumber);
            if(telkomselData.isPresent()) {
                PulsaTelkomsel data = telkomselData.get();
                data.setPhoneNumber(pulsaTelkomsel.getPhoneNumber());
                data.setMobileBilling(pulsaTelkomsel.getMobileBilling());
                data.setStatus(pulsaTelkomsel.getStatus());
//                logger.info("Updating telkomsel bills with phoneNumber {}", data.toString());
                return new ResponseEntity<>(pulsaTelkomselRepository.save(data),HttpStatus.OK);
            } else  {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("ERROR! on put -telkomsel : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pulsa/telkomsel/{phoneNumber}")
    public ResponseEntity<HttpStatus> deleteTelkomsel(@PathVariable("phoneNumber") String phoneNumber) {
        try{
            pulsaTelkomselRepository.deleteById(phoneNumber);
//            logger.info("Deleting telkomsel bills with phoneNumber {}", phoneNumber.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("Error! on delete -telkomsel : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//--------------------------------- Pulsa Indosat -------------------------------------------
    @GetMapping("pulsa/indosat")
    public ResponseEntity<List<PulsaIndosat>> getIndosat(@RequestParam(required = false) String args) {
      try {
          List<PulsaIndosat> pulsaIndosats = new ArrayList<>();
          pulsaIndosatRepository.findAll().forEach(pulsaIndosats::add);
          if (pulsaIndosats.isEmpty()) {
              return new ResponseEntity<>(pulsaIndosats, HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(pulsaIndosats, HttpStatus.OK);
      } catch (Exception e) {
          System.out.println("ERROR! on getAll -indosat :  " + e);
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/pulsa/indosat/{phoneNumber}")
    public ResponseEntity<PulsaIndosat> getIndosatById(@PathVariable("phoneNumber") String phoneNumber) {
        try {
            Optional<PulsaIndosat> dataIndosat = pulsaIndosatRepository.findById(phoneNumber);
//            logger.info("Fetching indosat bills with phoneNumber {}", dataIndosat.toString());
            if (dataIndosat.isPresent()) {
                return new ResponseEntity<>(dataIndosat.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("ERROR! on getById -indosat : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pulsa/indosat")
    public ResponseEntity<PulsaIndosat> createIndosat(@RequestBody PulsaIndosat pulsaIndosat) {
        try {
          PulsaIndosat data = pulsaIndosatRepository.save(pulsaIndosat);
//            logger.info("Create indosat bills with phoneNumber {}", data.toString());
            return new ResponseEntity<>(data, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error on PulsaController post -Indosat : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pulsa/indosat/{phoneNumber}")
    public ResponseEntity<PulsaIndosat> updateIndosat(@PathVariable("phoneNumber") String phoneNumber, @RequestBody PulsaIndosat pulsaIndosat ) {
           try {
                Optional<PulsaIndosat> dataIndosat = pulsaIndosatRepository.findById(phoneNumber);
                if(dataIndosat.isPresent()) {
                    PulsaIndosat data = dataIndosat.get();
                    data.setPhoneNumber(pulsaIndosat.getPhoneNumber());
                    data.setMobileBilling(pulsaIndosat.getMobileBilling());
                    data.setStatus(pulsaIndosat.getStatus());
//                    logger.info("Updating indosat bills with phoneNumber {}", data.toString());
                    return new ResponseEntity<>(pulsaIndosatRepository.save(data), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
           } catch (Exception e) {
               System.out.println("ERROR! on put Indosat : "  + e);
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }

    @DeleteMapping("/pulsa/indosat/{phoneNumber}")
    public ResponseEntity<PulsaIndosat> deleteIndosat(@PathVariable("phoneNumber") String phoneNumber) {
        try {
            pulsaIndosatRepository.deleteById(phoneNumber);
//            logger.info("Deleting indosat bills with phoneNumber {}", phoneNumber.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("ERROR! on delete -indosat : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//-------------------------------------- Pulsa XL -----------------------------------------------
    @GetMapping("pulsa/xl")
    public ResponseEntity<List<PulsaXL>> getXL(@RequestParam(required = false) String args) {
        try {
            List<PulsaXL> data = new ArrayList<>();
            pulsaXLRepository.findAll().forEach(data::add);
            if (data.isEmpty()) {
                return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("ERROR! on get -XL : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pulsa/xl/{phoneNumber}")
    public ResponseEntity<PulsaXL> getXLById(@PathVariable("phoneNumber") String phoneNumber) {
        try {
            Optional<PulsaXL> dataXl = pulsaXLRepository.findById(phoneNumber);
//            logger.info("Fetching xl bills with phoneNumber {}", dataXl.toString());
            if (dataXl.isPresent()) {
                return new ResponseEntity<>(dataXl.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("ERROR! on getById -XL : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pulsa/xl")
    public ResponseEntity<PulsaXL> createXL(@RequestBody PulsaXL pulsaXL) {
        try {
            PulsaXL data = pulsaXLRepository.save(pulsaXL);
//            logger.info("Create XL bills with phoneNumber {}", data.toString());
            return new ResponseEntity<>(data, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error on PulsaController post -xl : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pulsa/xl/{phoneNumber}")
    public ResponseEntity<PulsaXL> updateXl(@PathVariable("phoneNumber") String phoneNumber, @RequestBody PulsaXL pulsaXL ) {
        try {
            Optional<PulsaXL> dataXL = pulsaXLRepository.findById(phoneNumber);
            if(dataXL.isPresent()) {
                PulsaXL data = dataXL.get();
                data.setPhoneNumber(pulsaXL.getPhoneNumber());
                data.setMobileBilling(pulsaXL.getMobileBilling());
                data.setStatus(pulsaXL.getStatus());
//                logger.info("Updating xl bills with phoneNumber {}", data.toString());
                return new ResponseEntity<>(pulsaXLRepository.save(data), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("ERROR! on put Xl : "  + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pulsa/xl/{phoneNumber}")
    public ResponseEntity<PulsaXL> deleteXL(@PathVariable("phoneNumber") String phoneNumber) {
        try {
            pulsaXLRepository.deleteById(phoneNumber);
//            logger.info("Deleting xl bills with phoneNumber {}", phoneNumber.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("ERROR! on delete -xl : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
