package com.idc.hes.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idc.hes.model.Student;

@Repository
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAO() {}

	public StudentDAO (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Transactional
	public void saveOrUpdate(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Transactional
	public void delete(int id) {
		Student studentToDelete = new Student();
		studentToDelete.setId(new Long(id));
		sessionFactory.getCurrentSession().delete(studentToDelete);
	}

	@Transactional
	public Student get (String userName) {
		String hql = "from Student where userName='" + userName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> listStudent = (List<Student>) query.list();
		
		if (listStudent != null && ! listStudent.isEmpty()) {
			return listStudent.get(0);
		}
		return null;
	}

	@Transactional
	public List<Student> list() {
		@SuppressWarnings("unchecked")
		List<Student> listStudent = (List<Student>) sessionFactory.getCurrentSession()
				.createCriteria(Student.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listStudent;
	}

	@Transactional
	public List<Student> getAll() {
		String hql = "from Student order by userName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> listStudent = (List<Student>) query.list();
		return listStudent;
	}

	@Transactional
	public boolean findByUserName (String userName) {
		String hql = "from Student where userName='" + userName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> listStudent = (List<Student>) query.list();
		if (listStudent != null && ! listStudent.isEmpty()) return true;
		return false;
	}

	@Transactional
	public boolean findByLogin(String userName, String password) {
		String hql = "from Student where userName='" + userName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> listStudent = (List<Student>) query.list();
		if (listStudent == null) return false;
		if (listStudent.isEmpty()) return false;
		if (listStudent.get(0) != null && listStudent.get(0).getPassword().equals(password)) return true;
		return false;		
	}
}
