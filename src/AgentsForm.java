import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.AgentEntity;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JTextField;

public class AgentsForm extends javax.swing.JFrame {
	private JTextField idag_field;
	private JTextField name_field;
	private JTextField idsell_field;
	private JTextField town_field;
	private JTextField phone_field;
	public AgentsForm() {
		setTitle("Агенты");
		setLocationRelativeTo(null);
		this.setSize(600, 400);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList list = new JList();
		
		JLabel label = new JLabel("Агенты:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		DefaultListModel listModel = new DefaultListModel();
		JList list_1 = new JList(listModel);
		
		JButton button = new JButton("Обновить");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				ArrayList<String> res = Main.get_agents();
				String[] res2 = res.toArray(new String[res.size()]);
				for (int i = 0; i < res.size(); i++)
					listModel.addElement(res2[i]);
				res.clear();
				
			}
		});
		
		JButton button_1 = new JButton("Удалить");
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] spl = list_1.getSelectedValue().toString().split(" ");
				//System.out.print(spl[4]);
				Main.delete_agent(spl[4]);
				int selectedIndex = list_1.getSelectedIndex();
				if (selectedIndex != - 1)
					listModel.remove(selectedIndex);
			}
		});
		
		JButton button_2 = new JButton("Добавить");
		
		
		idag_field = new JTextField();
		idag_field.setColumns(10);
		
		name_field = new JTextField();
		name_field.setColumns(10);
		
		idsell_field = new JTextField();
		idsell_field.setColumns(10);
		
		town_field = new JTextField();
		town_field.setColumns(10);
		
		phone_field = new JTextField();
		phone_field.setColumns(10);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.add_agent(Integer.parseInt(idag_field.getText()), Integer.parseInt(idsell_field.getText()), name_field.getText(), town_field.getText(), phone_field.getText());
				listModel.addElement("ID: " + idag_field.getText() + " Name: " + name_field.getText() + " Town: " + town_field.getText()+ " Phone: " + phone_field.getText());
			}
		});
		
		JLabel lblId = new JLabel("ID агента:");
		
		JLabel lblId_1 = new JLabel("ID прод:");
		
		JLabel label_1 = new JLabel("Имя:");
		
		JLabel label_2 = new JLabel("Город:");
		
		JLabel label_3 = new JLabel("Телефон:");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(188)
							.addComponent(list)
							.addGap(5)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addComponent(button))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(idag_field, 0, 0, Short.MAX_VALUE)
								.addComponent(lblId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId_1)
								.addComponent(idsell_field, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(town_field, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(phone_field, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_2, 0, 0, Short.MAX_VALUE))
							.addGap(56))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(153))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(list))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(label)))
					.addGap(18)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblId_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(idag_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idsell_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phone_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(town_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		getContentPane().add(panel);
		
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		this.pack();
		this.setVisible(true);
	}
}
