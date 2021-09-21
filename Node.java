import java.util.HashMap;

// this is a model clss for a city
public class Node implements Comparable{
   public String name;                              // city name
   public int ID;                                   // city ID
   public int shortestDistance;                     // shortest distance from source to this city
   public Node previousVertice;                     // prior city from which we have shortest distance
   public HashMap<Node, Integer> adjacentNodes;     // neighbor cities and their distances
   
   // the constructor takes as parameters the name and ID of the city
   public Node(String n, int ID){
      name= n;
      this.ID= ID;
      adjacentNodes= new HashMap<>();
   }
   
   // this method adds "node" city in HashMap with "weight" as distance and adds this city to "node" HashMap 
   public void addAdjacent(Node node, int weight){
      adjacentNodes.put(node, weight);
      node.adjacentNodes.put(this, weight);
   }
   
   // this method compares this city with another city 
   // it compares their shortest distance
   // it's used in Djiksra algorithm to sort citys in PriorityQueue
   public int compareTo(Object n){
      return shortestDistance - ((Node)n).shortestDistance;
   }
}