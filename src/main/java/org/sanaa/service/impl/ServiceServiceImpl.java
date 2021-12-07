package org.sanaa.service.impl;

import java.util.List;

import org.sanaa.dao.ServiceRepository;
import org.sanaa.model.Service;
import org.sanaa.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public Service addService(Service service) {
		return serviceRepository.save(service);
	}

	@Override
	public Service updateService(Service service) {
		return serviceRepository.save(service);
	}

	@Override
	public void deleteService(Service service) {
		serviceRepository.delete(service);
		
	}

	@Override
	public Service getService(int id) {
		
		return serviceRepository.findById(id).get();
	}

	@Override
	public List<Service> getAllService() {
		
		return serviceRepository.findAll();
	}

}
