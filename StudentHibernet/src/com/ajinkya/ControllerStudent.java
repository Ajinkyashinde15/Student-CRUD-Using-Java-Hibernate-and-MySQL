package com.ajinkya;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ControllerStudent {

	public static void main(String[] args) {
		//new ControllerStudent().AddRecords();
		// new ControllerStudent().DeleteRecord(1);

		Student s = new Student();
		s.setId(4);
		s.setName("updatedaju");
		s.setMarks(33241);
		s.setSchool("updatedUCD");
		s.setYear(503);
		
		//new ControllerStudent().UpdateRecord(s);		
		System.out.println(new ControllerStudent().getAllStudents());
		System.out.println(new ControllerStudent().getStudentById(5));
	}
	
	void AddRecords() 
	{
		Student s = new Student();
		s.setName("aju");
		s.setMarks(31);
		s.setSchool("UCD");
		s.setYear(2003);

		SessionFactory sessionFac = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFac.openSession();
		
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		session.close();
		sessionFac.close();
	}

	void DeleteRecord(int sid) {
		Transaction trns = null;
		SessionFactory sessionFac = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFac.openSession();

		try {
			trns = session.beginTransaction();
			Student s = (Student) session.load(Student.class, new Integer(sid));
			session.delete(s);
			session.getTransaction().commit();
			System.out.println("Deleted successfully..!!");
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	void UpdateRecord(Student s) {
		Transaction trns = null;
		SessionFactory sessionFac = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFac.openSession();

		try {
			trns = session.beginTransaction();
			session.update(s);
			session.getTransaction().commit();
			System.out.println("Updated successfully..!!");
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}


	public List<Student> getAllStudents() {
		List<Student> users = new ArrayList<Student>();

		Transaction trns = null;
		SessionFactory sessionFac = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFac.openSession();

		try {
			trns = session.beginTransaction();
			users = session.createQuery("from Student").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}
	
	public Student getStudentById(int userid) {
		Student student = null;
		Transaction trns = null;
		SessionFactory sessionFac = new org.hibernate.cfg.AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFac.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Student where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            student = (Student) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return student;
    }

}
