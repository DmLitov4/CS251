/**
 * Created by rasiel on 07.04.16.
 */

import org.AgentEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;


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

        AgentEntity newAgent = new AgentEntity();
        newAgent.setIdAgent(4);
        newAgent.setIdSeller(0);
        newAgent.setName("Sadam");
        newAgent.setTown("Iraq");
        newAgent.setPhone("666");
        am.add(newAgent);
        agents = am.list();

        for (Iterator iterator = agents.iterator(); iterator.hasNext();) {
                AgentEntity agent = (AgentEntity) iterator.next();
                System.out.print("ID: " + agent.getIdAgent() + "    ");
                System.out.print("Name: " + agent.getName() + "    ");
                System.out.print("Phone: " + agent.getPhone() + "    ");
                System.out.print("Town: " + agent.getTown() + "    ");
                System.out.println();
        }

        am.remove(newAgent);

        agents = am.list();


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
