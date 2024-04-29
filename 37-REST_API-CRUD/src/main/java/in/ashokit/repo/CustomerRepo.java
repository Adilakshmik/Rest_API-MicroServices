package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer>{

}
