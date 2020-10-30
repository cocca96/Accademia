package it.bit.accademia.model.data.jdbc;

import java.util.Collection;

import bit.accademia.model.Student;
import bit.accademia.model.data.DataException;
import bit.accademia.model.data.StudentRepository;

public class StudentRepositoryJdbc implements StudentRepository {

	@Override
	public Student add(Student st) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deletE(int id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findAll() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByNameLike(String partialName) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByLastNameLike(String partialLastName) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(int id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upDate(Student student) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iscrivi(int studentId, int corsoId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Student> studentsByCourse(int corsoId) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

}
