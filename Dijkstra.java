import java.util.PriorityQueue;
import java.util.Arrays;

public class Dijkstra{
   // this method is used to find the shortest route from one city to another
   // using the Dijkstra algorithm
   // "source" is the starting city and "destination" is the final city
   // "cities" is an array that contains all cities (array in Graph class)
   public static void shortestPath(Node source, Node destination, Node[] cities){
      // we create a queue in order to maintain the shortest distance from the source to other cities
      // only visited cities are stored to "queue"
      PriorityQueue<Node> queue= new PriorityQueue<>(Arrays.asList(cities));
      
      // set the source distance to zero and refresh it in the queue
      // to refresh it in queue we must remove and add it again so it will sort based in new "shortestDistance"
      source.shortestDistance= 0;
      queue.remove(source);
      queue.offer(source);
      
      Node visiting;
      
      // stay in the loop until the shortest distance in the list is the destination
      // so the shortest current path must still be calculated
      while(!queue.peek().equals(destination)){
         // we get the node (city) with the shortest distance from the source (we remove it from the queue to be counted as visited)
         visiting= queue.poll();
         // visiting all the neighbors of the city "visiting" (the city we just removed from queue)
         for(Node n : visiting.adjacentNodes.keySet()){
            // take the "shortestDistance" of the city "visiting" and add the distance from him to the neighbor "n" 
            int tempoDistance= visiting.shortestDistance + visiting.adjacentNodes.get(n);
            // if the new distance is shorter than the current one in city "n"
            if(tempoDistance < n.shortestDistance){
               n.shortestDistance= tempoDistance;    // set new shortest distance 
               // refresh "n" city in queue (remove and add it again)
               queue.remove(n);                      
               queue.offer(n);
               n.previousVertice= visiting;          // set "visiting" city as the city from which we got shortest distance to "n" city
            }
         }
      }
   }
   
   // this method does not return anything because the shortest path is saved in cities
   // for example if we want to find shortest Path from city c1 to city c10
   // then we go to c10 (destination) in the "previousVertice" we have the city from we reached this path to c10 for example c9 
   // then we go to c9 in the "previousVertice" we have the city from we reached this path to c9 for example c8
   // this goes until we reach c1 (in c1 "previousVertice" will be null because we started the path from c1)
}