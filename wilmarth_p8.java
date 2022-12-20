import java.io.BufferedReader;

public class wilmarth_p8 {

	private static int width = 700;
	private static int height = 350;
	private static int width2 = 350;
	
	///Added fields
	private static String sortFileName;
	private static String searchFileName;
	private static int[] sortValues;
	private static int[] searchValues;
	private static boolean searchFileRead = false;
	
	private static int[] sortedValues;
	private static java.util.TreeSet<Integer> treeSetValues = new java.util.TreeSet<>();
	private static java.util.HashSet<Integer> hashSetValues = new java.util.HashSet<>();
	private static java.util.PriorityQueue<Integer> priorityQueueValues = new java.util.PriorityQueue<>();
	private static java.util.ArrayList<Integer> arrayListValues = new java.util.ArrayList<>();
	private static java.util.ArrayList<Integer> sortedArrayListValues = new java.util.ArrayList<>();
	private static wilmarth_BinarySearchTree bst = new wilmarth_BinarySearchTree();
	private static int[] unsortedValues;
	
	///Static left button variables
	private static javax.swing.JButton sortIntsButton;
	private static javax.swing.JLabel sortIntsLabel;
	private static javax.swing.JButton addToBstButton;
	private static javax.swing.JLabel addToBstLabel;
	private static javax.swing.JButton addToTreeSetButton;
	private static javax.swing.JLabel addToTreeSetLabel;
	private static javax.swing.JButton addToPriorityQueueButton;
	private static javax.swing.JLabel addToPriorityQueueLabel;
	private static javax.swing.JButton addToHashsetButton;
	private static javax.swing.JLabel addToHashsetLabel;
	private static javax.swing.JButton addToArrayListButton;
	private static javax.swing.JLabel addToArrayListLabel;
	private static javax.swing.JButton addToSortedArrayListButton;
	private static javax.swing.JLabel addToSortedArrayListLabel;
	private static javax.swing.JButton addToArrayButton;
	private static javax.swing.JLabel addToArrayLabel;
	//Static right button variables
	private static javax.swing.JButton searchSortedIntsButton;
	private static javax.swing.JLabel searchSortedIntsLabel;
	private static javax.swing.JButton searchBstButton;
	private static javax.swing.JLabel searchBstLabel;
	private static javax.swing.JButton searchTreeSetButton;
	private static javax.swing.JLabel searchTreeSetLabel;
	private static javax.swing.JButton searchPriorityQueueButton;
	private static javax.swing.JLabel searchPriorityQueueLabel;
	private static javax.swing.JButton searchHashsetButton;
	private static javax.swing.JLabel searchHashsetLabel;
	private static javax.swing.JButton searchArrayListButton;
	private static javax.swing.JLabel searchArrayListLabel;
	private static javax.swing.JButton searchSortedArrayListButton;
	private static javax.swing.JLabel searchSortedArrayListLabel;
	private static javax.swing.JButton searchArrayButton;
	private static javax.swing.JLabel searchArrayLabel;
	
	public static void main(String[] args)
	{
		///Set file names to class variables
		sortFileName = args[0];
		searchFileName = args[1];
		
		//Create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		//Create the menu bar
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		
		//Create the two menus
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
		
		//Create the menu items for the two menus
		javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");
		javax.swing.JMenuItem fileReadSortFile = new javax.swing.JMenuItem("Read sort file");
		javax.swing.JMenuItem fileReadSearchFile = new javax.swing.JMenuItem("Read search file");

		//Add the two menus to the menu bar
		menuBar.add(fileMenu);
		
		// add the two menu items to the two menus
		fileMenu.add(fileReadSortFile);
		fileMenu.add(fileReadSearchFile);
		fileMenu.add(fileExit);

		//Create left panel
		javax.swing.JPanel leftButtonPanel = new javax.swing.JPanel();
		leftButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255),2));//(0, 0, 255, 255),2))
		leftButtonPanel.setPreferredSize(new java.awt.Dimension(width2, height));
		leftButtonPanel.setMinimumSize(new java.awt.Dimension(width2, height));
		java.awt.GridBagLayout leftGridBagLayout = new java.awt.GridBagLayout();
		leftButtonPanel.setLayout(leftGridBagLayout);
		
		//Create right button panel
		javax.swing.JPanel rightButtonPanel = new javax.swing.JPanel();
		rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255),2));//(0, 255, 255, 255),2))
		rightButtonPanel.setPreferredSize(new java.awt.Dimension(width2, height));
		rightButtonPanel.setMinimumSize(new java.awt.Dimension(width2, height));
		java.awt.GridBagLayout rightGridBagLayout = new java.awt.GridBagLayout();
		rightButtonPanel.setLayout(rightGridBagLayout);
		
		///Grid constraints for left 
		java.awt.GridBagConstraints leftButtonPanelConstraints = new java.awt.GridBagConstraints();
		sortIntsButton = new javax.swing.JButton("sort ints");
		sortIntsLabel = new javax.swing.JLabel("no result");
		addToBstButton = new javax.swing.JButton("add to bst");
		addToBstLabel = new javax.swing.JLabel("no result");
		addToTreeSetButton = new javax.swing.JButton("add to treeset");
		addToTreeSetLabel = new javax.swing.JLabel("no result");
		addToPriorityQueueButton = new javax.swing.JButton("add to priority queue");
		addToPriorityQueueLabel = new javax.swing.JLabel("no result");
		addToHashsetButton = new javax.swing.JButton("add to hashset");
		addToHashsetLabel = new javax.swing.JLabel("no result");
		addToArrayListButton = new javax.swing.JButton("add to arraylist");
		addToArrayListLabel = new javax.swing.JLabel("no result");
		addToSortedArrayListButton = new javax.swing.JButton("add to sorted arraylist");
		addToSortedArrayListLabel = new javax.swing.JLabel("no result");
		addToArrayButton = new javax.swing.JButton("add to array");
		addToArrayLabel = new javax.swing.JLabel("no result");
		
		///Grid constraints for right 
		java.awt.GridBagConstraints rightButtonPanelConstraints = new java.awt.GridBagConstraints();
		searchSortedIntsButton = new javax.swing.JButton("search sorted ints");
		searchSortedIntsLabel = new javax.swing.JLabel("no result");
		searchBstButton = new javax.swing.JButton("search bst");
		searchBstLabel = new javax.swing.JLabel("no result");
		searchTreeSetButton = new javax.swing.JButton("search treeset");
		searchTreeSetLabel = new javax.swing.JLabel("no result");
		searchPriorityQueueButton = new javax.swing.JButton("search priority queue");
		searchPriorityQueueLabel = new javax.swing.JLabel("no result");
		searchHashsetButton = new javax.swing.JButton("search hashset");
		searchHashsetLabel = new javax.swing.JLabel("no result");
		searchArrayListButton = new javax.swing.JButton("search arraylist");
		searchArrayListLabel = new javax.swing.JLabel("no result");
		searchSortedArrayListButton = new javax.swing.JButton("search sorted arraylist");
		searchSortedArrayListLabel = new javax.swing.JLabel("no result");
		searchArrayButton = new javax.swing.JButton("search array");
		searchArrayLabel = new javax.swing.JLabel("no result");
		
		//Left panel buttons
		leftButtonPanelConstraints.weightx = 1;
		leftButtonPanelConstraints.weighty = 1;
		leftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		leftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		
		//Sort ints button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 0;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(sortIntsButton, leftButtonPanelConstraints);
		//Sort ints label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 0;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(sortIntsLabel, leftButtonPanelConstraints);
		
		//Add bst button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 1;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToBstButton, leftButtonPanelConstraints);
		//Add bst label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 1;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToBstLabel, leftButtonPanelConstraints);
		
		//Add treeset button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 2;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToTreeSetButton, leftButtonPanelConstraints);
		//Add treeset label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 2;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToTreeSetLabel, leftButtonPanelConstraints);
				
		//Add priority queue button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 3;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToPriorityQueueButton, leftButtonPanelConstraints);
		//Add priority queue label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 3;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToPriorityQueueLabel, leftButtonPanelConstraints);
		
		//Add hashset button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 4;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToHashsetButton, leftButtonPanelConstraints);
		//Add hashset label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 4;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToHashsetLabel, leftButtonPanelConstraints);
		
		//Add arraylist button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 5;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToArrayListButton, leftButtonPanelConstraints);
		//Add arraylist label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 5;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToArrayListLabel, leftButtonPanelConstraints);
		
		//Add sorted arraylist button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 6;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToSortedArrayListButton, leftButtonPanelConstraints);
		//Add sorted arraylist label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 6;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToSortedArrayListLabel, leftButtonPanelConstraints);
				
		//Add array button
		leftButtonPanelConstraints.gridx = 0;
		leftButtonPanelConstraints.gridy = 7;
		leftButtonPanelConstraints.gridwidth = 1;
		leftGridBagLayout.setConstraints(addToArrayButton, leftButtonPanelConstraints);
		//Add array label
		leftButtonPanelConstraints.gridx = 1;
		leftButtonPanelConstraints.gridy = 7;
		leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToArrayLabel, leftButtonPanelConstraints);
				
				
		//Add left buttons/labels to panel
		leftButtonPanel.add(sortIntsButton);
		leftButtonPanel.add(sortIntsLabel);
		leftButtonPanel.add(addToBstButton);
		leftButtonPanel.add(addToBstLabel);
		leftButtonPanel.add(addToTreeSetButton);
		leftButtonPanel.add(addToTreeSetLabel);
		leftButtonPanel.add(addToPriorityQueueButton);
		leftButtonPanel.add(addToPriorityQueueLabel);
		leftButtonPanel.add(addToHashsetButton);
		leftButtonPanel.add(addToHashsetLabel);
		leftButtonPanel.add(addToArrayListButton);
		leftButtonPanel.add(addToArrayListLabel);
		leftButtonPanel.add(addToSortedArrayListButton);
		leftButtonPanel.add(addToSortedArrayListLabel);
		leftButtonPanel.add(addToArrayButton);
		leftButtonPanel.add(addToArrayLabel);
		
		///Right panel buttons
		rightButtonPanelConstraints.weightx = 1;
		rightButtonPanelConstraints.weighty = 1;
		rightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		rightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		
		//Search sorted ints button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 0;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchSortedIntsButton, rightButtonPanelConstraints);
		//Search sorted ints label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 0;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchSortedIntsLabel, rightButtonPanelConstraints);
		
		//Search bst button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 1;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchBstButton, rightButtonPanelConstraints);
		//Search bst label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 1;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchBstLabel, rightButtonPanelConstraints);
		
		//Search treeset button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 2;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchTreeSetButton, rightButtonPanelConstraints);
		//Search treeset label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 2;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchTreeSetLabel, rightButtonPanelConstraints);
				
		//Search priority queue button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 3;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchPriorityQueueButton, rightButtonPanelConstraints);
		//Search priority queue label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 3;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchPriorityQueueLabel, rightButtonPanelConstraints);
		
		//Search hashset button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 4;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchHashsetButton, rightButtonPanelConstraints);
		//Search hashset label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 4;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchHashsetLabel, rightButtonPanelConstraints);
		
		//Search arraylist button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 5;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchArrayListButton, rightButtonPanelConstraints);
		//Search arraylist label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 5;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchArrayListLabel, rightButtonPanelConstraints);
		
		//Search sorted arraylist button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 6;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchSortedArrayListButton, rightButtonPanelConstraints);
		//Search sorted arraylist label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 6;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchSortedArrayListLabel, rightButtonPanelConstraints);
		
		//Search array button
		rightButtonPanelConstraints.gridx = 0;
		rightButtonPanelConstraints.gridy = 7;
		rightButtonPanelConstraints.gridwidth = 1;
		rightGridBagLayout.setConstraints(searchArrayButton, rightButtonPanelConstraints);
		//Search array label
		rightButtonPanelConstraints.gridx = 1;
		rightButtonPanelConstraints.gridy = 7;
		rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchArrayLabel, rightButtonPanelConstraints);
				
		//Add right buttons/labels
		rightButtonPanel.add(searchSortedIntsButton);
		rightButtonPanel.add(searchSortedIntsLabel);
		rightButtonPanel.add(searchBstButton);
		rightButtonPanel.add(searchBstLabel);
		rightButtonPanel.add(searchTreeSetButton);
		rightButtonPanel.add(searchTreeSetLabel);
		rightButtonPanel.add(searchPriorityQueueButton);
		rightButtonPanel.add(searchPriorityQueueLabel);
		rightButtonPanel.add(searchHashsetButton);
		rightButtonPanel.add(searchHashsetLabel);
		rightButtonPanel.add(searchArrayListButton);
		rightButtonPanel.add(searchArrayListLabel);
		rightButtonPanel.add(searchSortedArrayListButton);
		rightButtonPanel.add(searchSortedArrayListLabel);
		rightButtonPanel.add(searchArrayButton);
		rightButtonPanel.add(searchArrayLabel);
		
		//Create actions listeners for left buttons
		ButtonActionListener sortIntButtonActionListener = new ButtonActionListener(sortIntsButton);
		ButtonActionListener addToBstButtonActionListener = new ButtonActionListener(addToBstButton);
		ButtonActionListener addToTreeSetButtonActionListener = new ButtonActionListener(addToTreeSetButton);
		ButtonActionListener addToPriorityQueueButtonActionListener = new ButtonActionListener(addToPriorityQueueButton);
		ButtonActionListener addToHashsetButtonActionListener = new ButtonActionListener(addToHashsetButton);
		ButtonActionListener addToArrayListButtonActionListener = new ButtonActionListener(addToArrayListButton);
		ButtonActionListener addToSortedArrayListButtonActionListener = new ButtonActionListener(addToSortedArrayListButton);
		ButtonActionListener addToArrayButtonActionListener = new ButtonActionListener(addToArrayButton);

		//Add action listeners to left buttons
		sortIntsButton.addActionListener(sortIntButtonActionListener);
		addToBstButton.addActionListener(addToBstButtonActionListener);
		addToTreeSetButton.addActionListener(addToTreeSetButtonActionListener);
		addToPriorityQueueButton.addActionListener(addToPriorityQueueButtonActionListener);
		addToHashsetButton.addActionListener(addToHashsetButtonActionListener);
		addToArrayListButton.addActionListener(addToArrayListButtonActionListener);
		addToSortedArrayListButton.addActionListener(addToSortedArrayListButtonActionListener);
		addToArrayButton.addActionListener(addToArrayButtonActionListener);

		//Create action listeners for right buttons
		ButtonActionListener searchSortedIntsButtonActionListener = new ButtonActionListener(searchSortedIntsButton);
		ButtonActionListener searchBstButtonActionListener = new ButtonActionListener(searchBstButton);
		ButtonActionListener searchTreeSetButtonActionListener = new ButtonActionListener(searchTreeSetButton);
		ButtonActionListener searchPriorityQueueButtonActionListener = new ButtonActionListener(searchPriorityQueueButton);
		ButtonActionListener searchHashsetButtonActionListener = new ButtonActionListener(searchHashsetButton);
		ButtonActionListener searchArrayListButtonActionListener = new ButtonActionListener(searchArrayListButton);
		ButtonActionListener searchSortedArrayListButtonActionListener = new ButtonActionListener(searchSortedArrayListButton);
		ButtonActionListener searchArrayButtonActionListener = new ButtonActionListener(searchArrayButton);
		
		//Add action listeners to right buttons
		searchSortedIntsButton.addActionListener(searchSortedIntsButtonActionListener);
		searchBstButton.addActionListener(searchBstButtonActionListener);
		searchTreeSetButton.addActionListener(searchTreeSetButtonActionListener);
		searchPriorityQueueButton.addActionListener(searchPriorityQueueButtonActionListener);
		searchHashsetButton.addActionListener(searchHashsetButtonActionListener);
		searchArrayListButton.addActionListener(searchArrayListButtonActionListener);
		searchSortedArrayListButton.addActionListener(searchSortedArrayListButtonActionListener);
		searchArrayButton.addActionListener(searchArrayButtonActionListener);
		
		//Create main panel
		javax.swing.JPanel mainButtonPanel = new javax.swing.JPanel();
		mainButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255),2));//(0, 255, 0, 255),2));
		javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(mainButtonPanel, javax.swing.BoxLayout.X_AXIS);
		mainButtonPanel.setLayout(boxLayout);
		mainButtonPanel.add(leftButtonPanel);
		mainButtonPanel.add(rightButtonPanel);
		
		// create the panel
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255),2));//(255, 0, 0, 255),2));
		mainPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		mainPanel.add(mainButtonPanel, java.awt.BorderLayout.CENTER);
		
		// create the action listeners for the menu items
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);
		MenuItemActionListener fileReadSortFileMenuItemActionListener = new MenuItemActionListener(fileReadSortFile);
		MenuItemActionListener fileReadSearchFileMenuItemActionListener = new MenuItemActionListener(fileReadSearchFile);

		// add the action listeners to the menu items
		fileExit.addActionListener(fileExitMenuItemActionListener);
		fileReadSortFile.addActionListener(fileReadSortFileMenuItemActionListener);
		fileReadSearchFile.addActionListener(fileReadSearchFileMenuItemActionListener);

		//Sets frame's content pane to out main panel
		f.setContentPane(mainPanel);
		
		//Validate the frame and set to be visible
		f.validate();
		f.setVisible(true);
		
		///disable all buttons to start
		sortIntsButton.setEnabled(false);
		addToBstButton.setEnabled(false);
		addToTreeSetButton.setEnabled(false);
		addToPriorityQueueButton.setEnabled(false);
		addToHashsetButton.setEnabled(false);
		addToArrayListButton.setEnabled(false);
		addToSortedArrayListButton.setEnabled(false);
		addToArrayButton.setEnabled(false);
		searchSortedIntsButton.setEnabled(false);
		searchBstButton.setEnabled(false);
		searchTreeSetButton.setEnabled(false);
		searchPriorityQueueButton.setEnabled(false);
		searchHashsetButton.setEnabled(false);
		searchArrayListButton.setEnabled(false);
		searchSortedArrayListButton.setEnabled(false);
		searchArrayButton.setEnabled(false);
	}
	
	//Action listener for the buttons
	static class ButtonActionListener implements java.awt.event.ActionListener
	{
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b)
		{
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + b.getText() + " button");
						
			//If sort ints is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("sort ints"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Sort ints in input array
				selectionSort();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				sortIntsLabel.setText((t1-t0) + "ms");
				
			}
			//If search ints is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search sorted ints"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchInts();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchSortedIntsLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to bst is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to bst"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code that adds all values in sort array to bst
				addToBinarySearchTree();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToBstLabel.setText((t1-t0) + "ms");
			}
			//If search bst is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search bst"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchBinarySearchTree();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchBstLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to treeset is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to treeset"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToTreeSet();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToTreeSetLabel.setText((t1-t0) + "ms");
			}
			//If search treeset is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search treeset"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchTreeSet();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchTreeSetLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to hashset is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to hashset"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToHashSet();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToHashsetLabel.setText((t1-t0) + "ms");
			}
			//If search hashset is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search hashset"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchHashSet();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchHashsetLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to priority queue is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to priority queue"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToPriorityQueue();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToPriorityQueueLabel.setText((t1-t0) + "ms");
			}
			//If search priority queue is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search priority queue"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchPriorityQueue();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchPriorityQueueLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to arraylist is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to arraylist"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToArrayList();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToArrayListLabel.setText((t1-t0) + "ms");
			}
			//If search arraylist is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search arraylist"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchArrayList();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchArrayListLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to add to sorted arraylist is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to sorted arraylist"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToSortedArrayList();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToSortedArrayListLabel.setText((t1-t0) + "ms");
			}
			//If search sorted arraylist is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search sorted arraylist"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchSortedArrayList();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				searchSortedArrayListLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
			//If add to array is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("add to array"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				addToArray();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Output time taken
				addToArrayLabel.setText((t1-t0) + "ms");
			}
			//If search array is selected from buttons, run it and set label to time taken
			if(b.getText().toLowerCase().equals("search array"))
			{
				//Take beginning time
				long t0 = System.currentTimeMillis();
				
				//Run code
				int count = searchArray();
				
				//Take end time
				long t1 = System.currentTimeMillis();
				
				//Set label to show time taken
				searchArrayLabel.setText(count + "/" + (t1-t0) + "ms");
			}
			
		}
	}
	
	//Action listener for the menu items
	static class MenuItemActionListener implements java.awt.event.ActionListener
	{
		// the menu item associated with the action listener, so that we can
		// share this one class with multiple menu items
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m)
		{
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + m.getText() + " menu item");
			
			// if exit is selected from the file menu, exit the program
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
			// if read sort is selected from the file menu, populate int array with it
			if( m.getText().toLowerCase().equals("read sort file") )
			{
				System.out.println("read sort file");
				
				//Read data from file
				readData(sortFileName, true);
				
				//Enable left panel buttons
				sortIntsButton.setEnabled(true);
				addToBstButton.setEnabled(true);
				addToTreeSetButton.setEnabled(true);
				addToPriorityQueueButton.setEnabled(true);
				addToHashsetButton.setEnabled(true);
				addToArrayListButton.setEnabled(true);
				addToSortedArrayListButton.setEnabled(true);
				addToArrayButton.setEnabled(true);
			}
			// if read search is selected from the file menu, populate int array with it
			if( m.getText().toLowerCase().equals("read search file") )
			{
				System.out.println("read search file");
				
				//Read data from file
				readData(searchFileName, false);

				//Set boolean that file was read
				searchFileRead = true;
				
				//Set buttons to true for any left panels already read
				if(sortedValues != null)
				{
					searchSortedIntsButton.setEnabled(true);
				}
				if(!treeSetValues.isEmpty())
				{
					searchTreeSetButton.setEnabled(true);
				}
				if(!hashSetValues.isEmpty())
				{
					searchHashsetButton.setEnabled(true);
				}
				if(!priorityQueueValues.isEmpty())
				{
					searchPriorityQueueButton.setEnabled(true);
				}
				if(!arrayListValues.isEmpty())
				{
					searchArrayListButton.setEnabled(true);
				}
				if(!sortedArrayListValues.isEmpty())
				{
					searchSortedArrayListButton.setEnabled(true);
				}
				if(bst.getRoot() != null)
				{
					searchBstButton.setEnabled(true);
				}
				if(unsortedValues != null)
				{
					searchArrayButton.setEnabled(true);
				}
			}
		}
	}
	
	//Sorting the array element starting at lowerBound and ending at upperBound
	private static void selectionSort()
	{
		//Declare index variable and array to sort through selection
		int minIndex;
		sortedValues = new int[sortValues.length];

		for(int i=0; i<sortValues.length;i++)
		{
			sortedValues[i] = sortValues[i];
		}
		//For each value form lower bound to upper bound
		for(int i = 0; i < sortedValues.length; i++)
		{
			minIndex = i;

			//Search through array for the next lowest value
			for(int x = i+1; x < sortedValues.length; x++)
			{
				if (sortedValues[x] <= sortedValues[minIndex])
				{
					minIndex = x;
				}
			}
			
			if(minIndex != i)
			{
				//Swap values
				int temp = sortedValues[minIndex];
				sortedValues[minIndex] = sortedValues[i];
				sortedValues[i] = temp;
			}
		}
		
		//Enable search
		if(searchFileRead) searchSortedIntsButton.setEnabled(true);
	}
	//Search ints
	private static int searchInts()
	{
		int counter = 0;
		int bottom = 0, top = (sortedValues.length-1), middle = 0;
		
		for(int index = 0; index < searchValues.length; index++)
		{
			//Reset values
			top = (sortedValues.length-1);
			bottom = 0;
			middle = 0;
			
			while (bottom <= top)
			{
				middle = (bottom+top)/2;
				if(searchValues[index] < sortedValues[middle])
				{
					top = middle-1;
				}
				else
				{
					if(searchValues[index] > sortedValues[middle])
					{
						bottom = middle+1;
					}
					else
					{
						//Value found
						counter++;
						break;
					}
				}
			}
		}
		return counter;
	}
	
	//Array (general array)
	private static void addToArray()
	{
		unsortedValues = new int[sortValues.length];
		unsortedValues = sortValues;
		
		if(searchFileRead) searchArrayButton.setEnabled(true);
	}
	private static int searchArray()
	{
		int counter = 0;
		
		for(int j = 0; j < searchValues.length; j++)
		{
			for(int i = 0; i < unsortedValues.length; i++)
			{
				if (unsortedValues[i] == searchValues[j])
				{
					counter++;
				}
			}
		}
		return counter;
	}
	
	//Binary search tree
	private static void addToBinarySearchTree()
	{
		//If statment to create new tree when button is pressed again
		if (bst.getRoot() != null)
		{
			bst = new wilmarth_BinarySearchTree();
		}
		
		for(int i = 0; i < sortValues.length; i++)
		{
			bst.insertNode(new Node(sortValues[i]));
		}
		//Enable search
		if(searchFileRead) searchBstButton.setEnabled(true);
	}
	//Search binary search tree for each value in search array
	private static int searchBinarySearchTree()
	{
		int counter = 0;
		
		for(int i = 0; i < searchValues.length; i ++)
		{
			Node searchNode = bst.getNode(bst.getRoot(), searchValues[i]);
			
			if (searchNode != null)
			{
				if(searchNode.getKey() == searchValues[i])
				{
					counter++;
				}
			}
		}
		return counter;
	}
	
	//Treeset
	private static void addToTreeSet()
	{
		for(int i = 0; i < sortValues.length; i++)
		{
			//Add values to treeset
			treeSetValues.add(sortValues[i]);
		}
		//Enable search
		if(searchFileRead) searchTreeSetButton.setEnabled(true);
	}
	
	private static int searchTreeSet()
	{
		int counter = 0;
		
		for(int i = 0; i < searchValues.length; i++)
		{
			if(treeSetValues.contains(searchValues[i]))
			{
				counter++;
			}
		}
		return counter;
	}
	
	//Priority Queue
	private static void addToPriorityQueue()
	{
		for(int i = 0; i < sortValues.length; i++)
		{
			//Add values to priority queue
			priorityQueueValues.add(sortValues[i]);
		}
		//Enable search
		if(searchFileRead) searchPriorityQueueButton.setEnabled(true);
	}
	private static int searchPriorityQueue()
	{
		int counter = 0;
		
		for(int i = 0; i < searchValues.length; i++)
		{
			if(priorityQueueValues.contains(searchValues[i]))
			{
				counter++;
			}
		}
		return counter;
	}
	
	//Hashset
	private static void addToHashSet()
	{
		for(int i = 0; i < sortValues.length; i++)
		{
			//Add values to hashset
			hashSetValues.add(sortValues[i]);
		}
		//Enable search
		if(searchFileRead) searchHashsetButton.setEnabled(true);
	}
	private static int searchHashSet()
	{
		int counter = 0;
		
		for(int i = 0; i < searchValues.length; i++)
		{
			if(hashSetValues.contains(searchValues[i]))
			{
				counter++;
			}
		}
		return counter;
	}
	
	//ArrayList unsorted
	private static void addToArrayList()
	{
		for(int i = 0; i < sortValues.length; i++)
		{
			//Add values to array list
			arrayListValues.add(sortValues[i]);
		}
		//Enable search
		if(searchFileRead) searchArrayListButton.setEnabled(true);
	}
	private static int searchArrayList()
	{
		int counter = 0;
				
		for(int i = 0; i < searchValues.length; i++)
		{
			if(arrayListValues.contains(searchValues[i]))
			{
				counter++;
			}
		}
		return counter;
	}
	
	//ArrayList sorted
	private static void addToSortedArrayList()
	{
		for(int i = 0; i < sortValues.length; i++)
		{
			//Add values to sorted arraylist
			sortedArrayListValues.add(sortValues[i]);
		}
		//Sort arraylist
		java.util.Collections.sort(sortedArrayListValues);
		
		//Enable search
		if(searchFileRead) searchSortedArrayListButton.setEnabled(true);
	}
	private static int searchSortedArrayList()
	{
		int counter = 0;
		
		for(int i = 0; i < searchValues.length; i++)
		{
			if(java.util.Collections.binarySearch(sortedArrayListValues, searchValues[i]) >= 0)
			{
				counter++;
			}
		}
		return counter;
	}
	
	//Read data to files
	private static void readData(String filename, boolean readSortValues)
	{
		//Read file into arraylist
		java.util.ArrayList<Integer> inputArray = new java.util.ArrayList<>();
		
		try
		{
			BufferedReader input = new BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			
			while((inn = input.readLine()) != null)
			{
				inputArray.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch(Exception k)
		{
			System.out.println(k);
		}
		
		if(readSortValues)
		{
			//Set to int array
			sortValues = new int[inputArray.size()];
			sortValues = inputArray.stream().mapToInt(i -> i).toArray();
		}
		else
		{
			//Set to int array
			searchValues = new int[inputArray.size()];
			searchValues = inputArray.stream().mapToInt(i -> i).toArray();
		}
	}
	
}

