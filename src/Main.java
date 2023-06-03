import java.util.Scanner;

public class Main implements ap{

	public static void main(String[] args) {
		DatabaseManager db = new DatabaseManager();
		db.read(false);
		// Appuntamenti Per Test
		//appuntamento.aggiungi(new Appuntamento(new Data(new Ora(20, 30), new Durata(21, 30), new Giorno(26, Giorno.Mese.Aprile, 2005)), "asd", Appuntamento.Grado.Importantissimo, new Persona("Mattia", "Spagnuolo")));
		//appuntamento.aggiungi(new Appuntamento(new Data(new Ora(20, 30), new Durata(21, 30), new Giorno(20, Giorno.Mese.Gennaio, 2004)), "asd", Appuntamento.Grado.Non_Necessario, new Persona("Mattia", "Spagnuolo")));
		//appuntamento.aggiungi(new Appuntamento(new Data(new Ora(20, 30), new Durata(21, 30), new Giorno(14, Giorno.Mese.Agosto, 2005)), "asd", Appuntamento.Grado.Normale, new Persona("Mattia", "Spagnuolo")));
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("Seleziona una delle seguenti opzioni (1-6):");
			System.out.println("1 - Aggiungi Appuntamento");
			System.out.println("2 - Vedi tutti gli Appuntamenti");
			System.out.println("3 - Ricerca attraverso l'anno");
			System.out.println("4 - Ricerca ordinata per Importanza");
			System.out.println("5 - Ricerca ordinata per Data");
			System.out.println("6 - Ricerca secondo una Data");
			System.out.println("7 - Modifica un Appuntamento");
			System.out.println("8 - Elimina un Appuntamento");
			
			int select = input.nextInt();
			
			switch(select) {
			case 1:
				System.out.println("Aggiungendo un nuovo appuntamento");
				
				System.out.println("Orario del Appuntamento:");
				System.out.print("Ora: ");
				int oraAp = input.nextInt();
				System.out.print("Minuti: ");
				int minutiAp = input.nextInt();
				
				System.out.println("Durata del Appuntamento:");
				System.out.print("Ora: ");
				int oraDurata = input.nextInt();
				System.out.print("Minuti: ");
				int minutiDurata = input.nextInt();
				
				System.out.println("Data del Appuntamento:");
				System.out.print("Giorno: ");
				int giorno = input.nextInt();
				System.out.print("Seleziona mese (1 a 12): ");
				int mese = input.nextInt(); 
				System.out.print("Anno: ");
				int anno = input.nextInt(); 
				Data data = new Data(new Ora(oraAp, minutiAp), new Durata(oraDurata, minutiDurata), new Giorno(giorno, Giorno.Mese.values()[mese], anno));
				
				System.out.println("Motivo del Appuntamento: ");
				input.nextLine();
				String motivoAp = input.nextLine();
				
				System.out.println("Quanto e importante questo appuntamento?");
				System.out.println("1 - Non Necessario");
				System.out.println("2 - Normale");
				System.out.println("3 - Importantissimo");
				System.out.println("Indica l'importanza da 1 a 3: ");
				int importanza = input.nextInt();
				
				System.out.println("Chi devi incontrare?");
				input.nextLine();
				System.out.println("Nome: ");
				String nome = input.nextLine();
				System.out.println("Cognome: ");
				String cognome = input.nextLine();
				Persona persona = new Persona(nome, cognome);
				
				appuntamento.aggiungi(new Appuntamento(data, motivoAp, Appuntamento.Grado.values()[importanza-1], persona));
				System.out.println("Appuntamento Aggiunto.");
				break;
				
			case 2:
				db.read(true);
				break;
				
			case 3:
				System.out.println("Ricerca un appuntamento attreverso l'anno");
				System.out.print("da Anno: ");
				int daAnno = input.nextInt();
				System.out.print("ad Anno: ");
				int aAnno = input.nextInt();
				appuntamento.ricerca(daAnno, aAnno);
				break;
				
			case 4:
				System.out.println("Ricerca ordinata per Importanza");
				System.out.println("Selezione modalità di ordinamento:");
				System.out.println("1 - Dal più importante");
				System.out.println("2 - Dal meno importante");
				int ordine = input.nextInt();
				appuntamento.ordinaPerImportanza(ordine);
				break;
				
			case 5:
				System.out.println("Ricerca ordinata per Data");
				appuntamento.ordinaPerData();
				break;
				
			case 6:
				System.out.println("Ricerca secondo una data");
				System.out.println("Data del Appuntamento:");
				System.out.print("Giorno: ");
				int numGiorno = input.nextInt();
				System.out.print("Seleziona mese (1 a 12): ");
				int numMese = input.nextInt(); 
				System.out.print("Anno: ");
				int numAnno = input.nextInt(); 
				
				String stringa = numAnno+"-"+numMese+"-"+numGiorno;
				Appuntamento risultatoRicerca = appuntamento.ricercaBinaria(stringa);
				
				if (risultatoRicerca != null) {
					System.out.println("Risultato: " + risultatoRicerca);
				} else {
					System.out.println("Nessun risultato.");
				}
				break;
				
			case 7:
				db.update();
				break;
			
			case 8:
				System.out.println("Cancella un Appuntamento");
				System.out.print("Numero del Appuntamento: ");
				int numeroAp = input.nextInt();
				db.delete(numeroAp);
				System.out.println("Appuntamento cancellato.");
				break;
				
			default:
				System.out.println("Seleziona una delle opzioni disponibili");
			}
		}
		
		// Rimuvore un appuntamento attraverso l'index
		//appuntamento.elimina(0); 
		
		// Vedere tutti gli Appuntamenti | Array
		//appuntamento.appuntamenti();
		
		// Vedere tutti gli Appuntamenti | Stringa
		//appuntamento.allAp();
		
		// Ricerca attraverso l'anno
		//appuntamento.ricerca(2001, 2005);
		
	}

}
