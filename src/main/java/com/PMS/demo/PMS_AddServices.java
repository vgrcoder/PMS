package com.PMS.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PMS_AddServices
{
    @Autowired
    PMS_Repo repo;

    public boolean checkPizzaAlreadyAdded(String id)
    {
        Optional <PMS_Beans> pms= repo.findById(id);
        if(pms.isPresent())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
