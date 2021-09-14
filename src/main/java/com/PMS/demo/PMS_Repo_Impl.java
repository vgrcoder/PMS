package com.PMS.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PMS_Repo_Impl implements PMS_Custom_Repo
{
    @Autowired
    PMS_Repo repo;

    @Override
    public List<PMS_Beans> findAllByProdName (String prod_Name)
    {
        List<PMS_Beans> pms_beansList = new ArrayList<PMS_Beans>();
        List<PMS_Beans> pms_beans=repo.findAll();

        for (PMS_Beans items:pms_beans)
        {
            if (items.getProductName().equalsIgnoreCase(prod_Name))
            {
                pms_beansList.add(items);
            }
        }
        return pms_beansList;
    }
}
