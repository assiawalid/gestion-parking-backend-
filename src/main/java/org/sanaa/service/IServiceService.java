package org.sanaa.service;

import java.util.List;

import org.sanaa.model.Service;

public interface IServiceService {
	public Service addService(Service service);
	public Service updateService(Service service);
	public void deleteService(Service service);
	public Service getService(int id);
	public List<Service> getAllService();
	

}
