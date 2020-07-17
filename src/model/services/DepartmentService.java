package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	public List<Department> findAll() {
		List<Department> listMock = new ArrayList<Department>();
		listMock.add(new Department(1, "Books"));
		listMock.add(new Department(2, "Computers"));
		listMock.add(new Department(3, "Electronics"));
		listMock.add(new Department(4, "Electronics"));
		listMock.add(new Department(5, "Electronics"));
		return listMock;
	}
}