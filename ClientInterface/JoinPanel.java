package ClientInterface;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ServerCommunicationAndData.User;

public class JoinPanel extends JPanel {
	
	private ArrayList<User> startedGames = new ArrayList<User>();
	private ArrayList<String> startedNames = new ArrayList<String>();
	private JList<String> playerNames;
	private DefaultListModel<String> list = new DefaultListModel<String>();
	private JLabel errorLabel;
	private String selected_player;
	
	
	public JoinPanel() {
		this.setLayout(new GridLayout(5,1, 2, 2));
		JLabel joinLabel = new JLabel("Choose a game to join");
		this.add(joinLabel);
		
		errorLabel = new JLabel(" ");
		this.add(errorLabel);
		
		JList playerNames = new JList<String>(list);
		playerNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playerNames.setLayoutOrientation(JList.VERTICAL);
		playerNames.setVisibleRowCount(10);
		JScrollPane scrollPane = new JScrollPane(playerNames);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel playerListBuffer = new JPanel();
		playerListBuffer.add(scrollPane);
		this.add(playerListBuffer, BorderLayout.EAST);
		
		JPanel joinCancelButtons = new JPanel();
		JButton join = new JButton("Join");
		JButton cancel = new JButton("Cancel");
		joinCancelButtons.add(join);
		joinCancelButtons.add(cancel);
		this.add(joinCancelButtons);
		
		JButton logout = new JButton("Logout");
		this.add(logout);
		
		playerNames.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					setSelectedPlayer((String) playerNames.getSelectedValue());
				}
			}
		});
		
	}
	
	 public void setError(String error) {
		  System.out.println(error);
		  errorLabel.setText(error);
	  }
	 
	 public void setSelectedPlayer(String selected_player) {
		 this.selected_player = selected_player;
	 }
	 
	 public String getSelectedPlayer() {
		 return selected_player;
	 }
	 
	 public void addStartingPlayer(User user) {
		 startedGames.add(user);
		 String started_name = user.getUsername();
		 startedNames.add(started_name);
		 list.addElement(started_name);
	 }

}
