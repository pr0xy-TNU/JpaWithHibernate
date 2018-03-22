package com.javawebtutor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTest {

    private static EntityManager em;

    public static void main(String[] args) {
        em = PersistenceManager.INSTANCE.getEntityManager();
        Employee employee = new Employee();
        employee.setDept("343434");
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        em.getTransaction().begin();
        {
            em.persist(employee);
            em.getTransaction().commit();
        }
        List<Employee> list;

        List list1 = em.createQuery("from Employee").getResultList();

        list1.forEach(item -> {
            Employee temp = (Employee) item;
            System.out.printf(temp.toString());
        });

        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
