
package com.briz.springboottransactionalexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Transactional  
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
@Modifying // this annotation is for non select query i.e update and delete 
// @Modifying must be used along with @Transactional otherwise error
// if @Modifying is not used then it will give error i.e expecting select query so it is must for update and delete 
//  ONLY FOR THE UPDATE AND DELETE OPERATIONS USE THIS ANNOTATION WITH QUERY ANNOTATION MUST IN REPOSITORY 
@Query("update Employee e set name=?1 where id=?2")// update always return int/void(for no update) i.e number of rows updated 
int updateById(String name,int id);
}
