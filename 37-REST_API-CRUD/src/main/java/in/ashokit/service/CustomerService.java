package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CustomerEntity;

public interface CustomerService {
	
	public void saveCustomer(CustomerEntity c);
	public List<CustomerEntity> retrieveCustomers();
	public CustomerEntity updateCustomer(CustomerEntity entity);
	public void deleteCustomer(Integer id);
	

}
