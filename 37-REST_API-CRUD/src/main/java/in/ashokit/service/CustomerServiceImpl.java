package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CustomerEntity;
import in.ashokit.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo repo;
	
	@Override
	public void saveCustomer(CustomerEntity entity) {
		CustomerEntity save = repo.save(entity);
		
		
	}

	@Override
	public List<CustomerEntity> retrieveCustomers() {
		List<CustomerEntity> all = repo.findAll();
		return all;
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity entity) {
		
		repo.save(entity);
		return entity;
	}

	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
		
	}

}
