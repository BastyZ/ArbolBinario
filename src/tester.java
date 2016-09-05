import java.util.Scanner;
import java.util.Random;

public class tester {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArbolBinario arbolAVL = new AVL();
		ArbolBinario arbolRB = new RB();
		System.out.println("Ingrese numero de elementos (en miles)(del 1 al 10)");
		int n = Integer.parseInt(s.nextLine());
		System.out.println("Azar(AZAR) o ascendente(ASC)");
		String sort = s.nextLine();
		sort = sort.toUpperCase();
		// print about insert time
		if( n >= 1 && n <= 10){
			if( sort.equals("AZAR") || sort.equals("ASC")){
				// start counter 1
				long begin1 = System.nanoTime();
				for(int i=1; i <= n*1000; i++){
					if (sort.equals("AZAR") ){
						int r = randomInt(1,20000);
						arbolAVL.insertar(r);
					} else {
						arbolAVL.insertar(i);
					}
				}
				long end1 = System.nanoTime();
				// stop counter 1
				// start counter 2
				long begin2 = System.nanoTime();
				for(int i=1; i <= n*1000; i++){
					if (sort.equals("AZAR") ){
						int r = randomInt(1,20000);
						arbolRB.insertar(r);
					} else {
						arbolRB.insertar(i);
					}
				}
				long end2 = System.nanoTime();
				// stop counter 2
				// print results
				// print about search time
				//start counter 3
				long begin3 = System.nanoTime();
				for(int i = 1; i <= 1000; i++){
					int ran = randomInt( 1, 1000 );
					arbolAVL.buscar(ran);
				} // stop counter 3
				long end3 = System.nanoTime();
				//start counter 4
				long begin4 = System.nanoTime();
				for(int i = 1; i <= 1000; i++){
					int ran = randomInt( 1, 1000 );
					arbolRB.buscar(ran);
				} // stop counter 4
				long end4 = System.nanoTime();
				//print results
				System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +");
				System.out.println("|        M E A S U R E   O F   E X E C U T I O N   T I M E        |");
				System.out.println("|                  ( i n   n a n o s e c o n d s )                |");
				System.out.println("+ - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - +");
				System.out.println("|         A V L   T R E E        |    R E D B L A C K   T R E E   |");
				System.out.println("+ - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - +");
				System.out.println("|        I N S E R T I O N       |        I N S E R T I O N       |");
				System.out.println("|       total       average      |       total       average      |");
				System.out.print("|      "+(end1-begin1)+"       "+(end1-begin1)/(n*1000)+"        |");
				System.out.println("      "+(end2-begin2)+"       "+(end2-begin2)/(n*1000)+"        |");
				System.out.println("+ - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - +");
				System.out.println("|           S E A R C H          |           S E A R C H          |");
				System.out.println("|       total       average      |       total       average      |");
				System.out.print("|      "+(end3-begin3)+"       "+(end3-begin3)/(n*1000)+"        |");
				System.out.println("       "+(end4-begin4)+"        "+(end4-begin4)/(n*1000)+"        |");
				System.out.println("+ - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - +");
			} else System.out.println("wrong sorting choice");
		} else System.out.println("out of bounds");
		s.close();
	}
	
	public static int randomInt(int min, int max) {
	    Random rand = new Random();
	    // nextInt excludes the top value so we have to add 1 to include the top value
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
