package HTML;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HtmlMain {

	public static void main(String[] args) {

		Scanner kyb = new Scanner(System.in);
		Queue<String> tagsQ = new LinkedList<String>();
		LinkedList<String> tagsCheck = new LinkedList<String>();

		int tags = 0;
		String input = "";
		boolean isOK = true;

		tags = kyb.nextInt();
		kyb.nextLine();

		for (int i = 0; i < tags; i++) {
			input = kyb.nextLine();
			tagsQ.add(input);
		}
		while (!tagsQ.isEmpty()) {
			String toCheck = tagsQ.poll();
			if (toCheck.charAt(0) == '<') {
				
				if (toCheck.charAt(toCheck.length()-1) == '>') {
					
					//ESTA BIEN ABIERTO Y CERRADO AHORA HAY QUE COMPROBAR SI ES UNA ABERTURA O CIERRE
					if (toCheck.charAt(1) == '/') {
						
						//TAG PARA CERRAR
						if (!tagsCheck.isEmpty()) { //SI NO ESTA VACIA
							
							if (tagsCheck.contains(toCheck.substring(2, toCheck.length()-1))) { //COMPRUEBO QUE EXISTA EN LA PILA UN TAG RELACIONADO A EL
								//EXISTE, SI EXISTE QUE HAGO??
								if (tagsCheck.peekFirst().substring(2, tagsCheck.peekFirst().length()-1) == toCheck.substring(2, toCheck.length()-1)) {
									//BIEN, EL ULTIMO QUE HE PUESTO ES EL QUE DEBERIA
									tagsCheck.removeFirst();
								}else if (tagsCheck.peekLast().substring(2, tagsCheck.peekLast().length()-1) == toCheck.substring(2, toCheck.length()-1)) {
									//BIEN, EL PRIMERO QUE HAS PUESTO ES EL QUE DEBERIA
									tagsCheck.removeLast();
								}
							}else {
								//NO HAY TAG, ESTA MAL
								isOK = false;
								break;
							}
						}else {
							//ESTA MAL PORQUE LA PILA DONDE HAS DE COMPROBAR EL TAG ESTA VACIA
							isOK = false;
							break;
						}
					}else if (toCheck.charAt(toCheck.length()-2) == '/') {
						isOK = false;
						break;
						
					}else {
						//TAG PARA ABRIR SE GUARDA A LA LISTA PARA COMPROBAR
						tagsCheck.push(toCheck.substring(1, toCheck.length()-1)); //SOLO ME INTERESA EL NOMBRE DEL TAG
					}
				}else {
					//TAG MAL CERRADO
					isOK = false;
					break;
				}
			}else {
				//TAG MAL ABIERTO
				isOK = false;
				break;
			}
		}
		
		if (!isOK) {
			System.out.println("Etiquetes mal tancades");
		}else {
			System.out.println("Etiquetes ben tancades");
		}
	}
}