package bit.accademia.model.data;

import java.util.Collection;

import bit.accademia.model.Student;

public interface  StudentRepository {
	Student add(Student st) throws DataException;
	//cancella lo studente e lo ritorna
	Student deletE(int id)throws DataException;
	//metodo che ritorna tutti gli studenti
	Collection<Student> findAll()throws DataException;
	//metodo che trova tutti gli studenti che hanno una certa
	//stringa nel loro nome 
	Collection<Student> findByNameLike(String partialName)throws DataException;
	//metodo che trova tutti gli studenti che hanno una certa
		//stringa nel loro cognome
	Collection<Student> findByLastNameLike(String partialLastName)throws DataException;
	Student findById(int id)throws DataException;
	//metodo per l'update
	void upDate(Student student)throws DataException;
	//metodo iscrivi studente
	void iscrivi(int studentId, int corsoId)throws LogicException;
	Collection<Student> studentsByCourse(int corsoId)throws DataException;
	//throws DataException rappresenta tutti gli errori che potrebbero essere presentati; poi tipo in s
}
