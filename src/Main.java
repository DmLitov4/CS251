/**
 * Created by rasiel on 07.04.16.
 */

import java.util.List;
import java.util.Iterator;

import org.AgentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//    public Integer addEmployee(String fname, String lname, int salary) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        Integer employeeID = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee = new Employee(fname, lname, salary);
//            employeeID = (Integer) session.save(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return employeeID;
//    }
//    public void listEmployees() {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            List employees = session.createQuery("FROM AgentEntity").list();
//            for (Iterator iterator =
//                 employees.iterator(); iterator.hasNext();){
//                AgentEntity agent = (AgentEntity) iterator.next();
//                System.out.print("ID: " + agent.getIdAgent() + "    ");
//                System.out.print("Name: " + agent.getName() + "    ");
//                System.out.print("Phone: " + agent.getPhone() + "    ");
//                System.out.print("Town: " + agent.getTown() + "    ");
//                System.out.println();
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//    public void updateEmployee(Integer EmployeeID, int salary ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            employee.setSalary( salary );
//            session.update(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    public void deleteEmployee(Integer EmployeeID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            session.delete(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }



public class Main {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void main(String[] args) {
        try {
            createSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        AgentManager am = new AgentManager(sessionFactory);

        List<AgentEntity> agents = am.list();

        for (Iterator iterator = agents.iterator(); iterator.hasNext();) {
                AgentEntity agent = (AgentEntity) iterator.next();
                System.out.print("ID: " + agent.getIdAgent() + "    ");
                System.out.print("Name: " + agent.getName() + "    ");
                System.out.print("Phone: " + agent.getPhone() + "    ");
                System.out.print("Town: " + agent.getTown() + "    ");
                System.out.println();
        }
//        ma.listEmployees();

//        System.out.println("Agents:");

//        JFrame frame = new JFrame("MainFrom");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.getContentPane().add(, BorderLayout.CENTER);
//        frame.pack();
//        frame.setVisible(true);
    }
}
