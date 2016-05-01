/**
 * Created by rasiel on 07.04.16.
 */

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.AgentEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Main {
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    public static AgentManager am;
    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
    
    public static ArrayList<String> get_agents()
    {
    	
        List<AgentEntity> agents = am.list();
        ArrayList<String> result = new ArrayList<String>();
        for (Iterator iterator = agents.iterator(); iterator.hasNext();)
        {
            AgentEntity agent = (AgentEntity) iterator.next();
            result.add("ID: " + agent.getIdAgent() + "  " + "Name: " + agent.getName() + "  " + "Phone: " + agent.getPhone() + "  " + "Town: " + agent.getTown() + "\n");
         }
        return result;
    }
    
    public static void add_agent(int id_ag, int id_sell, String name, String town, String phone)
    {
    	for (int i = 0; i < am.list().size(); ++i)
    	  if (am.list().get(i).getIdAgent() == id_ag)
    	    JOptionPane.showMessageDialog(null, "Уже есть агент с таким ID!");
		AgentEntity newAgent = new AgentEntity();
         newAgent.setIdAgent(id_ag);
         newAgent.setIdSeller(id_sell);
         newAgent.setName(name);
        newAgent.setTown(town);
        newAgent.setPhone(phone);
         am.add(newAgent);
    }
    
    public static void delete_agent(String name)
    {
    	
    	for (int i = 0; i < am.list().size(); i++)
    	{
    		if (am.list().get(i).getName().startsWith(name))
    		{
    			am.remove(am.list().get(i));
    			break;
    		}
    	}
    }
    
    
    
    public static void init()
    {
    	 try {
             createSessionFactory();
             am = new AgentManager(sessionFactory);
         } catch (Throwable ex) {
             System.err.println("Failed to create sessionFactory object." + ex);
             throw new ExceptionInInitializerError(ex);
             
         }

         

         //AgentEntity newAgent = new AgentEntity();
         //newAgent.setIdAgent(4);
         //newAgent.setIdSeller(0);
         //newAgent.setName("Sadam");
        // newAgent.setTown("Iraq");
        // newAgent.setPhone("666");
         //am.add(newAgent);
         //agents = am.list();
    }

    public static void main(String[] args) {
    	

      MainForm mf = new MainForm();
     mf.setVisible(true);

        //am.remove(newAgent);

       // agents = am.list();


      
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
