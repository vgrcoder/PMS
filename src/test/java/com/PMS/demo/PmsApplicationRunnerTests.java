package com.PMS.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PmsApplicationRunnerTests {

	@Test
	void contextLoads() {
	}
	@MockBean
	PMS_AddServices PMS_Service;

	@MockBean
	PMS_Repo pms_repo;

	@Autowired
	PMS_App_Controller Ctrl;

	AtomicInteger counter = new AtomicInteger();


	public void AddEmployeeNoMockito() //Without mockito
	{
		ResponseEntity response = Ctrl.addPizza(PMS_Payload());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
	}
	@Test
	public void AddEmployeeWithMockito()
	{
		//when(PMS_Service.checkPizzaAlreadyAdded(PMS_Payload().getProductName()+ counter.getAndIncrement())).thenReturn(false);
		when(PMS_Service.checkPizzaAlreadyAdded(PMS_Payload().getProductName()+ counter.getAndIncrement())).thenReturn(true);
		ResponseEntity response = Ctrl.addPizza(PMS_Payload());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
	}


	public PMS_Beans PMS_Payload(){
		PMS_Beans pms_beans = new PMS_Beans();
		pms_beans.setProductName("ChickenPizza");
		pms_beans.setProductPrice("750");
		return pms_beans;
	}
}
