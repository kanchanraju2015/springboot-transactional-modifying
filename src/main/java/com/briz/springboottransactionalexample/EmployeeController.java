package com.briz.springboottransactionalexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/")
public String test()
{
	return "this is transactional test";
}
@RequestMapping("/save")
public Employee save(@RequestBody Employee employee)
{
	return erepo.save(employee);
}
@RequestMapping("/all")
public List<Employee> alldata()
{
	return erepo.findAll();
}
@RequestMapping("/{name}/{id}")
public String upd(@PathVariable int id,@PathVariable String name)// here order does not matter 
{
int k=erepo.updateById(name,id);
return k+" Records Updated";
}
}
