package ClientInterface;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;
import ClientCommunication.GameClient;

public class JoinControl {
	private GameClient client;
	private JPanel container;
	private String username;
	
	public JoinControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
String command = ae.getActionCommand();
JoinPanel joinPanel = (JoinPanel)container.getComponent(2);
		
		if (command == "Join") {
			if (joinPanel.getSelectedPlayer() == null) {
				joinPanel.setError("Select a player's game to join");
			}
			else {
				String player = joinPanel.getSelectedPlayer();
				JoinData data = new JoinData(username);
			}
		}
		else if (command == "Submit") {
			// Get the username and password the user entered.
		      LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		      LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
		      
		      // Check the validity of the information locally first.
		      if (data.getUsername().equals("") || data.getPassword().equals("")) {
		    	  //displayError("You must enter a username and password.");
		          return;
		      }
		      
		      try {
				client.sendToServer(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Data not sent");
			}
		}
	}
	
	public void addNewGameStarter(String username) {
		JoinPanel joinPanel = (JoinPanel)container.getComponent(2);
		
	}

}
