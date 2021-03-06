package org.collectiveone.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PeriodicMethods {

	/* Services  */
	@Autowired
	DbServicesImp dbServices;
		
	@Scheduled(fixedDelay = 5000)
	public void UpdateDecisionsStatus() throws IOException {
		// System.out.print(".");
		dbServices.decisionsUpdateState();
		dbServices.bidsUpdateState();
		dbServices.goalsUpdateState();
		dbServices.cbtionsUpdateState();
		// System.out.print("-");
	}
}
