/** By: Jetmir Halili */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// this class contains all GUI part and starts app
// if you want to modify for any other country you must change only Graph class, this class and others must be the same
// in this class you must change only "imageMap" and "cordinates"
public class Window extends JPanel{
   private JFrame f;                                  // Frame of app
   private JEditorPane text;                          // the field we use to appear the cities of path and their distance from source
   private JComboBox sourceBox, destinationBox;       // boxes to choose source city and destination city
   private int[][] cordinates;                        // cordinates (x,y) in Frame of each city (are used to appear the path in map)
   private Graph graph;                               // the graph contains info of all citys
   private Image imageMap;                            // map country (in our case Kosovo map)
   private Node destination;                          // we save destination to get path from destination to source (explained in Dijkstra class)
   
   // constructor
   public Window(){
      graph= new Graph();
      setCordinates();
      imageMap= new ImageIcon(getClass().getResource("Images//map.jpg")).getImage();
      
      f= new JFrame();
      f.setSize(550,680);
      f.setLayout(null);
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      f.getContentPane().setBackground(Color.WHITE);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setComboBox();
      addText();
      addButton();
      
      this.setBounds(0,0,550,500);
      f.getContentPane().add(this);
      f.setVisible(true);
   }
   
   // this method deals with comboBoxes that serve for source and destination selection
   public void setComboBox(){
      // all cities names
      String [] citiesNames= new String[graph.nodes.length];
      for(int i=0; i<citiesNames.length; i++){
         citiesNames[i]= graph.nodes[i].name;
      }
      
      sourceBox= new JComboBox(citiesNames);
      sourceBox.setBounds(30,500,200,30);
      sourceBox.setBackground(Color.WHITE);
      sourceBox.setFont(new Font("Times new roman",0,20));
      sourceBox.addItem("Source");
      sourceBox.setSelectedItem("Source");
      f.add(sourceBox);
      
      destinationBox= new JComboBox(citiesNames);
      destinationBox.setBounds(30,540,200,30);
      destinationBox.setBackground(Color.WHITE);
      destinationBox.setFont(new Font("Times new roman",0,20));
      destinationBox.addItem("Destination");
      destinationBox.setSelectedItem("Destination");
      f.add(destinationBox);          
   }
   
   // this method deals with the field we use to appear the cities of path and their distance from source
   public void addText(){
      JScrollPane scroll = new javax.swing.JScrollPane();
      text= new JEditorPane();
      text.setEditable(false);
      text.setFocusable(false);
      text.setFont(new Font("Times new roman",0,14));
      scroll.setBounds(250,500,250,70);
      
      scroll.setViewportView(text);
      f.add(scroll);
   }
   
   // this method deals with the button which activates the algorithm
   public void addButton(){
      JButton b= new JButton("CALCULATE");
      b.setFont(new Font("Times new roman",0,18));
      b.setFocusable(false);
      b.setBounds(150,590,200,30);
      b.setForeground(Color.WHITE);
      b.setBackground(new Color(0,77,157));
      f.add(b);
      
      // button action
      b.addActionListener(
         e->{
            int s= sourceBox.getSelectedIndex();                        // index of source city
            int d= destinationBox.getSelectedIndex();                   // index of destination city
            // if the user has selected two cities (source and destination)
            if(s!=sourceBox.getItemCount()-1 && d!=destinationBox.getItemCount()-1){
               graph.reset();                                           // restet the graph
               Node source= graph.nodes[s];                             // get source
               destination= graph.nodes[d];                             // get destination
               Dijkstra.shortestPath(source, destination, graph.nodes); // use Dijkstra algorithm to find shortest path
               text.setText(getPathAndDistance());                      // set the path info in "text"
               repaint();                                               // repaint the map (including path)
            }
         });
   }
   
   // this method sets the coordinates in the Frame of each city for path painting
   public void setCordinates(){
      cordinates= new int[][]{ {350,195}, {210,355}, {322,300}, {120,205}, {145,295}, {395,270}, {265,120}, {330,135}, {285,155}, {250,310}, 
                                       {190,290}, {255,220}, {315,255}, {220,260}, {440,225}, {375,320}, {100,245}, {160,170}, {190,225}, {225,185}, 
                                       {205,425}, {295,225}, {340,350}, {290,285}, {300,200}, {240,55}, {230,105}, {290,350}, {385,230}, {200,120} };
   }
   
   // method that paints the map (Kosovo map)
   public void paintComponent(Graphics g){
      g.drawImage(imageMap,0,0,null);                 // draw the map
      
      if(destination!=null){
         paintPath((Graphics2D)g);                    // paint the path in Frame
      }
   }
   
   // this method that paints the path on the map
   public void paintPath(Graphics2D g){
      g.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));      // the thickness of the path will be 5 pixels
      g.setColor(Color.RED);                                                               // set color of the path red
      
      Node source= destination.previousVertice;                                            // starting from destination to source
                  
      GeneralPath path= new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      // move to the destination city (his cordinates)
      path.moveTo(cordinates[destination.ID][0],cordinates[destination.ID][1]);
      
      // while we do not pass the source city
      // as explained in Dijkstra's algorithm we will take cities from destination to source
      while(source!=null){
         int ID= source.ID;
         path.lineTo(cordinates[ID][0],cordinates[ID][1]);               // draws a line from previous city to this city
         source= source.previousVertice;                                 // we take the previous city
      }
      g.draw(path);                 // draw the path in the map
   }
   
   // this method returns as a result a string containing the cities names of this path as well as their distance to the source
   // this and and previous method are very similar, but the difference is because this is called only once (after user click button)
   // while the other is called every time panel is repainted (example if we minimize and maximize)
   // and they return different things
   public String getPathAndDistance(){
      // save the last city name (destination) and his distance 
      String rez= destination.name+" - "+destination.shortestDistance+" km";
      Node source= destination.previousVertice;                         // starting from destination to source
   
      // while we do not pass the source city
      // as explained in Dijkstra's algorithm we will take cities from destination to source
      while(source!=null){
         rez= source.name+" - "+source.shortestDistance+" km, "+rez;     // adds as a prefix this city name and it's distance to rez
         source= source.previousVertice;                                 // we take the previous city
      }
      
      return rez;
   }
   
   public static void main(String [] args){
      // set "nimbus" as UI
      try{                     
         javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
      }
      catch(javax.swing.UnsupportedLookAndFeelException e){}  
      
      new Window();
   }
}
