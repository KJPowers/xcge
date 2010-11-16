import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.stupidiville.games.cards.Card;
import org.stupidiville.games.cards.Deck;

public class GameWindow extends JFrame
{
  private enum Action
  {
    SHOW_MAIN_MENU,
    START_NEW_GAME,
    FIND_A_GAME,
    VIEW_FRIENDS,
    START_SERVER,
    CREATE_GAME,
    
    QUIT
  }
  
  JLabel m_lblDeck;
  JLabel m_lblDeal;
  Deck m_deck;
  
  public GameWindow()
  {
    super("Ox-C-Gen: The Online eXtensible Card Game ENgine");
    
    this.setBounds(50, 50, 810, 510);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    initialize();
    addMenus();
    
    Action doThis = Action.SHOW_MAIN_MENU;
    while(doThis != Action.QUIT)
    {
      switch(doThis)
      {
        case SHOW_MAIN_MENU:
          break;
        case START_NEW_GAME:
          break;
        case FIND_A_GAME:
          break;
        case VIEW_FRIENDS:
          break;
        case START_SERVER:
          break;
        case CREATE_GAME:
          break;
        default:
          // Show error log
          break;
      }
      
      doThis = showMainMenu();
    }
    // Old shit
    /*m_lblDeck = new JLabel();
    m_lblDeck.setText("");
    m_lblDeck.setBounds(5, 5, 71, 96);
    this.getContentPane().add(m_lblDeck);
    
    m_lblDeal = new JLabel();
    m_lblDeal.setText("");
    m_lblDeal.setBounds(81, 5, 71, 96);
    this.getContentPane().add(m_lblDeal);
    
    this.setVisible(true);*/
  }
  
  private Action showMainMenu()
  {
    return Action.QUIT;
  }
  
  private void initialize()
  {}
  
  public void showCard(Card p_card)
  {
    m_lblDeck.setIcon(p_card.getIconFront());
    m_lblDeck.setText(p_card.toString());
    m_lblDeck.setVisible(true);
  }
  
  public void show2Piles()
  {
    m_deck = new Deck();
    m_deck.shuffle();
    m_lblDeck.setIcon(m_deck.getBackIcon());
    m_lblDeck.setVisible(true);
    m_lblDeal.setIcon(m_deck.getBlankIcon());
    m_lblDeal.setVisible(true);
    
    m_lblDeck.addMouseListener(new MouseListener()
    {
      public void mouseClicked(MouseEvent p_mouseEvent)
      {
        if(m_deck.hasNext())
        {
          Card card = m_deck.next();
          m_lblDeal.setIcon(card.getIconFront());
        }
        if(!m_deck.hasNext())
        {
          m_lblDeck.setIcon(m_deck.getBlankIcon());
          m_lblDeck.removeMouseListener(this);
        }
      }
      
      public void mouseEntered(MouseEvent p_mouseEvent){}
      
      public void mouseExited(MouseEvent p_mouseEvent){}
      
      public void mousePressed(MouseEvent p_mouseEvent){}
      
      public void mouseReleased(MouseEvent p_mouseEvent){}
      
    });
  }
  
  public void showCards()
  {
    File file = new File(System.getProperty("user.dir") + File.separator + "img" + File.separator + "cards.png");
    try
    {
      BufferedImage image = ImageIO.read(file);
      ImageIcon icon = new ImageIcon(image.getSubimage(0,0,50,50));
      JLabel label = new JLabel(icon, JLabel.CENTER);
      JOptionPane.showMessageDialog(null, label, "icon", -1);
    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
    }
  }
  
  public void rulesSelector()
  {
    JFileChooser chooser = new JFileChooser();
    File dir = new File(System.getProperty("user.dir") + File.separator + "rules");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "XML Files", "xml");
    chooser.setCurrentDirectory(dir);
    chooser.setFileFilter(filter);
    if(JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this))
    {
      System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
    }
  }
  
  private void addMenus()
  {
    // Menu Hierarchy
    JMenuBar menuBar = new JMenuBar();
    
     JMenu fileMenu;
      JMenuItem testItem;
      JMenuItem openItem;
      JMenuItem exitItem;
    
     JMenu helpMenu;
      JMenuItem helpItem;
      JMenuItem aboutItem;
    
    // Do the work
    this.setJMenuBar(menuBar);
    
    // [F]ile
    fileMenu = menuBar.add(new JMenu("File"));
    fileMenu.setMnemonic('F');
    
    // - [T]est
    testItem = fileMenu.add("Test");
    testItem.setMnemonic('T');
    testItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        showCards();
      }
    });
    
    // - [O]pen
    openItem = fileMenu.add("Open");
    openItem.setMnemonic('O');
    openItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        rulesSelector();
      }
    });
    
    // - _______________
    fileMenu.addSeparator();
    
    // - E[x]it
    exitItem = fileMenu.add("Exit");
    exitItem.setMnemonic('x');
    exitItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    });
    
    // [H]elp
    helpMenu = menuBar.add(new JMenu("Help"));
    helpMenu.setMnemonic('H');
    // - Help
    helpItem = helpMenu.add("Help");
    helpItem.setMnemonic('H');
    helpItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(null, "I really don't know.",
                                      "Like, whatever...", JOptionPane.INFORMATION_MESSAGE);
      }
    });
    // - _______________
    helpMenu.addSeparator();
    // - [A]bout
    aboutItem = helpMenu.add("About");
    aboutItem.setMnemonic('A');
    aboutItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String about = new String("Ox-C-Gen, the Online eXtensible Card Game ENgine.\n");
        about += "Copyright (c) Keith Powers, 2009.\n";
        about += "http://www.stupidiville.org/\n";
        about += "I like money.  Give me money if you think Ox-C-Gen is worth it.\n";
        about += "Sandwiches are good, too.\n";
        about += "So are E-Mails: K.J.Powers@gmail.com\n";
        about += "\nOx-C-Gen is free software.  Use it any which way you like except for making money, then you need permission.\n";
        about += "Enjoy!\n\n";
        JOptionPane.showMessageDialog(null, about, "About Ox-C-Gen.", JOptionPane.INFORMATION_MESSAGE);
      }
    });
  }
}