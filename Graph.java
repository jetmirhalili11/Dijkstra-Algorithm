// this class contains all info about Kosovo map, all their cities and their distance
// if you want to modify for any other country you must change only this class and others must be the same
// of course to visualise you must change Window class too
public class Graph{
   public Node[] nodes;       // array that will contain all cities
   
   public Graph(){
      // we took 30 city in Kosovo
      nodes= new Node[30];
      
      // placing all cities in the array
      nodes[0]= new Node("Prishtine",0);
      nodes[1]= new Node("Prizren",1);
      nodes[2]= new Node("Ferizaj",2);
      nodes[3]= new Node("Peje",3);
      nodes[4]= new Node("Gjakove",4);
      nodes[5]= new Node("Gjilan",5);
      nodes[6]= new Node("Mitrovice",6);
      nodes[7]= new Node("Podujeve",7);
      nodes[8]= new Node("Vushtrri",8);
      nodes[9]= new Node("Suhareke",9);
      nodes[10]= new Node("Rahovec",10);
      nodes[11]= new Node("Gllogoc",11);
      nodes[12]= new Node("Lipjan",12);
      nodes[13]= new Node("Malisheve",13);
      nodes[14]= new Node("Kamenice",14);
      nodes[15]= new Node("Viti",15);
      nodes[16]= new Node("Deçan",16);
      nodes[17]= new Node("Istog",17);
      nodes[18]= new Node("Kline",18);
      nodes[19]= new Node("Skenderaj",19);
      nodes[20]= new Node("Dragash",20);
      nodes[21]= new Node("Fushe Kosove",21);
      nodes[22]= new Node("Kaçanik",22);
      nodes[23]= new Node("Shtime",23);
      nodes[24]= new Node("Obiliq",24);
      nodes[25]= new Node("Leposaviq",25);
      nodes[26]= new Node("Zveçan",26);
      nodes[27]= new Node("Shterpce",27);
      nodes[28]= new Node("Novoberde",28);
      nodes[29]= new Node("Zubin Potok",29);
      
      // adding neighbor cities of Prishtina
      // Prishtine - Kamenice 59, Prishtine - Podujeve 29, Prishtine - Obliq 11, Prishtine - Novo Berde 41, Prishtine - Fushe Kosove 8, Prishtine - Lipjan 17
      nodes[0].addAdjacent(nodes[14],59);
      nodes[0].addAdjacent(nodes[7],29);
      nodes[0].addAdjacent(nodes[24],11);
      nodes[0].addAdjacent(nodes[28],41);
      nodes[0].addAdjacent(nodes[21],8);
      nodes[0].addAdjacent(nodes[12],17);
      
      // adding neighbor cities of Prizren
      // Prizren - Dragash 34, Prizren - Shterpce 43, Prizren - Suhareke 18, Prizren - Rahovec 30, Prizren - Gjakove 40
      nodes[1].addAdjacent(nodes[20],34);
      nodes[1].addAdjacent(nodes[27],43);
      nodes[1].addAdjacent(nodes[9],18);
      nodes[1].addAdjacent(nodes[10],30);
      nodes[1].addAdjacent(nodes[4],40);
      
      // adding neighbor cities of Ferizaj
      // Ferizaj - Viti 22, Ferizaj - Kaqanik 23, Ferizaj - Shterpce 24, Ferizaj - Suhareke 39, Ferizaj - Shtime 12, Ferizaj - Lipjan 21, Ferizaj - Gjilan 34
      nodes[2].addAdjacent(nodes[15],22);
      nodes[2].addAdjacent(nodes[22],23);
      nodes[2].addAdjacent(nodes[27],24);
      nodes[2].addAdjacent(nodes[9],39);
      nodes[2].addAdjacent(nodes[23],12);
      nodes[2].addAdjacent(nodes[12],21);
      nodes[2].addAdjacent(nodes[5],34);
      
      // adding neighbor cities of Peje
      // Peje - Istog 24, Peje - Deqan 14, Peje - Kline 29, Peje - Gjakove 35
      nodes[3].addAdjacent(nodes[17],24);
      nodes[3].addAdjacent(nodes[16],14);
      nodes[3].addAdjacent(nodes[18],29);
      nodes[3].addAdjacent(nodes[4],35);
      
      // adding neighbor cities of Gjakove
      // Gjakove - Deqan 21,  Gjakove - Kline 35,  Gjakove - Rahovec 22
      nodes[4].addAdjacent(nodes[16],21);
      nodes[4].addAdjacent(nodes[18],35);
      nodes[4].addAdjacent(nodes[10],22);
      
      // adding neighbor cities of Gjilan
      // Gjilan - Kamenice 27, Gjilan - Novoberde 23, Gjilan - Lipjan 39, Gjilan - Viti 20
      nodes[5].addAdjacent(nodes[14],27);
      nodes[5].addAdjacent(nodes[28],23);
      nodes[5].addAdjacent(nodes[12],39);
      nodes[5].addAdjacent(nodes[15],20);
      
      // adding neighbor cities of Mitrovice
      // Mitrovice - Leposaviq 32, Mitrovice - Zveqan 3, Mitrovice - Skenderaj 22, Mitrovice - Vushtrri 13, Mitrovice - Podujeve 43, Mitrovice - Zubin Potok 19      
      nodes[6].addAdjacent(nodes[25],32);
      nodes[6].addAdjacent(nodes[26],3);
      nodes[6].addAdjacent(nodes[19],22);
      nodes[6].addAdjacent(nodes[8],13);
      nodes[6].addAdjacent(nodes[7],43);
      nodes[6].addAdjacent(nodes[29],19);
      
      // adding neighbor cities of Podujeve
      // Podujeve - Obiliq 30, Podujeve - Vushtrri 41, Podujeve - Leposaviq 75
      nodes[7].addAdjacent(nodes[24],30);
      nodes[7].addAdjacent(nodes[8],41);
      nodes[7].addAdjacent(nodes[25],75);
      
      // adding neighbor cities of Vushtrri
      // Vushtrri - Obiliq 21, Vushtrri - Gllogoc 35, Vushtrri - Skenderaj 25
      nodes[8].addAdjacent(nodes[24],21);
      nodes[8].addAdjacent(nodes[11],35);
      nodes[8].addAdjacent(nodes[19],25);
      
      // adding neighbor cities of Suhareke
      // Suhareke - Shterpce 63, Suhareke - Shtime 26, Suhareke - Malisheve 24, Suhareke - Lipjan 40, Suhareke - Rahovec 18
      nodes[9].addAdjacent(nodes[27],63);
      nodes[9].addAdjacent(nodes[23],26);
      nodes[9].addAdjacent(nodes[13],24);
      nodes[9].addAdjacent(nodes[12],40);
      nodes[9].addAdjacent(nodes[10],18);
      
      // adding neighbor cities of Rahovec
      // Rahovec - Malisheve 16, Rahovec - Kline 38
      nodes[10].addAdjacent(nodes[13],16);
      nodes[10].addAdjacent(nodes[18],38);
      
      // adding neighbor cities of Gllogoc
      // Gllogoc - Fushe Kosove 25, Gllogoc - Obiliq 25, Gllogoc - Skenderaj 18, Gllogoc - Kline 39, Gllogoc - Malisheve 24, Gllogoc - Lipjan 37
      nodes[11].addAdjacent(nodes[21],25);
      nodes[11].addAdjacent(nodes[24],25);
      nodes[11].addAdjacent(nodes[19],18);
      nodes[11].addAdjacent(nodes[18],39);
      nodes[11].addAdjacent(nodes[13],24);
      nodes[11].addAdjacent(nodes[12],37);
      
      // adding neighbor cities of Lipjan
      // Lipjan - Shtime 13, Lipjan - Malisheve 51, Lipjan - Fushe Kosove 17, Lipjan - Novoberde 44
      nodes[12].addAdjacent(nodes[23],13);
      nodes[12].addAdjacent(nodes[13],51);
      nodes[12].addAdjacent(nodes[21],17);
      nodes[12].addAdjacent(nodes[28],44);
      
      // adding neighbor cities of Malisheve
      // Malisheve - Kline 28
      nodes[13].addAdjacent(nodes[18],28);
      
      // adding neighbor cities of Kamenice
      // Kamenice - Novoberde 22
      nodes[14].addAdjacent(nodes[28],22);
      
      // adding neighbor cities of Viti
      // Viti - Kaqanik 22
      nodes[15].addAdjacent(nodes[22],22);
      
      
      // we have wiped out all the neighbors of Deqan above
      // nodes[16]

      // adding neighbor cities of Istog
      // Istog - Kline 22, Istog - Skenderaj 32, Istog - Zubin Potok 38
      nodes[17].addAdjacent(nodes[18],22);
      nodes[17].addAdjacent(nodes[19],32);
      nodes[17].addAdjacent(nodes[29],38);
      
      // adding neighbor cities of Kline
      // Kline - Skenderaj 26
      nodes[18].addAdjacent(nodes[19],26);
      
      // adding neighbor cities of Skenderaj
      // Skenderaj - Zubin Potok 33
      nodes[19].addAdjacent(nodes[29],33);
      
      // we have wiped out all the neighbors of Dragash above
      // nodes[20]
      
      // adding neighbor cities of Fushe Kosove
      // Fushe Kosove - Obiliq 9
      nodes[21].addAdjacent(nodes[24],9);
      
      // adding neighbor cities of Kaqanik
      // Kaqanik - Shterpce 25
      nodes[22].addAdjacent(nodes[27],25);
      
      // we have wiped out all the neighbors of Shtime above
      // nodes[23]
      
      // we have wiped out all the neighbors of Obiliq above
      // nodes[24]
      
      // adding neighbor cities of Leposaviq
      // Leposaviq - Zveqan 29
      nodes[25].addAdjacent(nodes[26],29);
      
      // adding neighbor cities of Zveqan
      // Zveqan - Zubin Potok 21
      nodes[26].addAdjacent(nodes[29],21);
      
      // we have wiped out all the neighbors of Shteprce above
      // nodes[27]
      
      // we have wiped out all the neighbors of Noveberde above
      // nodes[28]
      
      // we have wiped out all the neighbors of Zubin Potok above
      // nodes[29]
      
   }
   
   // this method is used every time we call Dijkstra algorithm, to reset all cities
   public void reset(){
      // for each city
      for(Node n: nodes){
         n.shortestDistance= Integer.MAX_VALUE;            // set shortest distance to infinity
         n.previousVertice= null;                          // set previus city to null
      }
   }
}