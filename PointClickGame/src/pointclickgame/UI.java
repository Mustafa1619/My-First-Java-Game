
package pointclickgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
     GameManager gm;
    JFrame window;
    public JPanel backgroundPanel[] = new JPanel[10];   
    public JLabel backgroundLabel[] = new JLabel[10];
    
    //Player UI
    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;
    
    // Game over UI
    public JLabel titleLabel;
    public JButton restartButton;
    
    
    public JTextArea messageText;
        public UI(GameManager gm){
        this.gm = gm;
        createMainField();
        createPlayerField();
        createGameOverField();
        generateScreen();
        window.setVisible(true);
    }
    
    public void createMainField(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        messageText = new JTextArea("");
        messageText.setBounds(100, 410, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.red);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }
    
    public void createBackground(int backgroundNum, String backgroundFileName){
        backgroundPanel[backgroundNum]= new JPanel();
        backgroundPanel[backgroundNum].setBounds(50, 50, 700, 350);
        backgroundPanel[backgroundNum].setBackground(Color.black);
        backgroundPanel[backgroundNum].setLayout(null);
        backgroundPanel[backgroundNum].setVisible(false);
        window.add(backgroundPanel[backgroundNum]);
        
        backgroundLabel[backgroundNum] = new JLabel();
        backgroundLabel[backgroundNum].setBounds(50, 0, 700, 350);
        
        ImageIcon backgroundIcon = new ImageIcon(getClass().getClassLoader().getResource(backgroundFileName));
        backgroundLabel[backgroundNum].setIcon(backgroundIcon);
        
    
    
    }
    
    public void createObject(int backgroundNum, int objx, int objy, int objWidth, int objHeight, String objfileName,
            String choice1Name, String choice2Name, String choice3Name,String choice1Command,String choice2Command, String choice3Command){
        
        JPopupMenu popMenu = new JPopupMenu();
        
        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.actionHandler);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);
        
        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.actionHandler);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);
        
        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.actionHandler);
        menuItem[3].setActionCommand(choice3Command);
        popMenu.add(menuItem[3]);
        
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx, objy, objWidth, objHeight);
//        objectLabel.setOpaque(true);
//        objectLabel.setBackground(Color.red);
        
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objfileName));
        objectLabel.setIcon(objectIcon);
        
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                
                if(SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}    });
            
        backgroundPanel[backgroundNum].add(objectLabel);
        
    }
    
    public void createArrowButton(int backgroundNum,int x, int y,int width,int height, String arrowFileName, String command){
    
    ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
    
        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.actionHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);
        
        backgroundPanel[backgroundNum].add(arrowButton);
    }
    
    public void createPlayerField(){
        lifePanel = new JPanel();
        lifePanel.setBounds(100, 0, 200, 50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);
        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("life.png"));
        
        //resmi yeniden boyutlandırmak için
        Image image =lifeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);
        
        int i=1;
        while(i<6){
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }
        
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(550,0,150,50);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1,3));
        window.add(inventoryPanel);
        
        //Create Items
        swordLabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
        image = swordIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        swordIcon = new ImageIcon(image);
        swordLabel.setIcon(swordIcon);
        inventoryPanel.add(swordLabel);
        
        shieldLabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("shield.png"));
        image = shieldIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        shieldIcon = new ImageIcon(image);
        shieldLabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldLabel);
        
        lanternLabel = new JLabel();
        ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lantern.png"));
        image = lanternIcon.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
        lanternIcon = new ImageIcon(image);
        lanternLabel.setIcon(lanternIcon);
        inventoryPanel.add(lanternLabel);
    }
    
    public void createGameOverField(){
        
        titleLabel = new JLabel("",JLabel.CENTER/*ortalamak için*/);
        titleLabel.setBounds(200,150,400,200);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN,70));
        titleLabel.setVisible(false);
        window.add(titleLabel);
        
        restartButton = new JButton();
        restartButton.setBounds(340,320,120,50);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.white);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.actionHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
        
    }
    
    public void generateScreen(){
        //1. sahne:
        createBackground(1,"point-click-background.png");
        createObject(1, 450, 130, 130, 140, "knight.png", "Look", "Talk", "Attack", "lookKnight", "talkKnight", "attackKnight");
        createObject(1, 100, 55, 200, 250, "cottage-160367 (1).png", "Look", "Talk", "Rest", "lookCottage", "talkCottage", "restCottage");
        createObject(1, 340, 200, 70, 70, "chest-145753_1280 (1).png", "Look", "Talk", "Open", "lookChest", "talkChest","openChest");
        createArrowButton(1, 650, 150, 50, 50, "right arrow.png", "goScene2");
        backgroundPanel[1].add(backgroundLabel[1]);

        //2. sahne:
        createBackground(2,"second-background(1).png");
        createObject(2, 370, 150, 50, 100, "blank.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
        createObject(2, 180, 240, 50, 50, "blank.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2, 0, 150, 50, 50, "left arrow.png", "goScene1");
        backgroundPanel[2].add(backgroundLabel[2]);
        
        //3. sahne:
        createBackground(3,"cave-inside.png");
	createObject(3,250,55,200,300,"werewolf.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        createArrowButton(3, 0, 150, 50, 50, "left arrow.png", "goScene2");
        backgroundPanel[3].add(backgroundLabel[3]);
        
        
    
    
    
    
    }
    
    
}









