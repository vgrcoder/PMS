package com.PMS.demo;

import java.util.List;

public interface PMS_Custom_Repo
{
     List<PMS_Beans> findAllByProdName(String prod_Name);
}
