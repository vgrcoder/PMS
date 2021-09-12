package com.PMS.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PMS_AddServices
{
    @Autowired
    PMS_Repo repo1;

    public boolean checkEmpAlreadyAdded(String id)
    {
        Optional <PMS_Beans> pms= repo1.findById(id);
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
