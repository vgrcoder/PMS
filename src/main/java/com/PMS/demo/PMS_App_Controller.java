package com.PMS.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PMS_App_Controller {

    AtomicInteger counter = new AtomicInteger();

    @Autowired
    PMS_Repo repo;

    @Autowired
    PMS_AddServices pms_addServices;

    @PostMapping ("/addPizza")
    public ResponseEntity<AddResponse> addPizza (@RequestBody PMS_Beans pms)
    {
        HttpHeaders headers = new HttpHeaders(); //For Adding Headers in the response
        AddResponse add = new AddResponse();
        String id = pms.getProductName() + counter.getAndIncrement(); //

        if(!pms_addServices.checkEmpAlreadyAdded(id))
        {
            pms.setProdId(id);
            repo.save(pms);
            //In order to get response body we need to create one bean class for add response

            headers.add("Unique", id);
            add.setId(id);
            add.setResponse_msg("Success: New Pizza Added");
            return new ResponseEntity<AddResponse>(add, headers, HttpStatus.CREATED);
        }
        else
        {
            add.setId(id);
            add.setResponse_msg("Pizza Already Added");
        }
        return new ResponseEntity<AddResponse>(add,headers,HttpStatus.ACCEPTED);
    }

    @GetMapping ("/getPizza/{prodId}")
    public PMS_Beans getProdId (@PathVariable(value = "prodId")String id)
    {
        try
        {
            PMS_Beans pms = repo.findById(id).get();
            return pms;
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping ("/getPizza")
    public List<PMS_Beans> getPizzaByName (@RequestParam(value = "productName")String prod_Name)
    {
        return repo.findAllByProdName(prod_Name);
    }



}
