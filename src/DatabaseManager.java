import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class DatabaseManager implements ap{
	
	private Connection conn;
	public DatabaseManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatestdb", "root", "");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void create(Appuntamento a) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO appuntamenti(inizio, fine, data, oggetto, nome, cognome, importanza)" + " VALUES ('"+ a.data.ora +"', '"+ a.data.durata +"', '"+ a.data.getData() +"', '"+ a.motivo +"', '"+ a.persona.nome +"', '"+ a.persona.cognome +"', '"+ a.grado +"')");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void read(boolean messaggio) {
		appuntamento.apList.clear();
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM appuntamenti");
			int loop = 0;
			while(result.next()) {
				int id = result.getInt("id");
				
				Time inizio = result.getTime("inizio");
				Time fine = result.getTime("fine");
				
				Date data = result.getDate("data");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(data);
				int giorno = calendar.get(Calendar.DAY_OF_MONTH);
				Giorno.Mese mese = Giorno.Mese.values()[calendar.get(Calendar.MONTH)+1];
				int anno = calendar.get(Calendar.YEAR);
				
				String oggetto = result.getString("oggetto");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String importanza = result.getString("importanza");
				
				appuntamento.apList.add(new Appuntamento(new Data(new Ora(inizio.getHours(), inizio.getMinutes()), new Durata(fine.getHours(), fine.getMinutes()), new Giorno(giorno, mese, anno)), oggetto, Appuntamento.Grado.valueOf(importanza), new Persona(nome, cognome)));

				if (messaggio == true) {
					System.out.println(id + " " + appuntamento.appuntamento(loop));
				}
			
				loop++;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update() {
		try {
			Statement stmt = conn.createStatement();
			Scanner input = new Scanner(System.in);
			
			System.out.println("Inserisci l'id del appuntamento da modificare:");
			int idAppuntamento = input.nextInt();
			
			System.out.println("Cosa vuoi modificare? (1-6)");
			System.out.println("1 - Orario d'inizio");
			System.out.println("2 - Durata del Appuntamento");
			System.out.println("3 - Data del Appuntamento");
			System.out.println("4 - Motivo del Appuntamento");
			System.out.println("5 - Persona da incontrare");
			System.out.println("6 - Livello d'Importanza");
	
			int select = input.nextInt();
			switch(select) {
				case 1:
					System.out.println("Modificando l'orario d'inizio");
					System.out.println("Modifica Ora: ");
					int oraInizio = input.nextInt();
					System.out.println("Modifica Minuti: ");
					int minutiInizio = input.nextInt();
					Ora orarioInizio = new Ora(oraInizio, minutiInizio);
					
					stmt.executeUpdate("UPDATE appuntamenti SET inizio='"+ orarioInizio.toString() +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				case 2:
					System.out.println("Modificando la durata del Appuntamento");
					System.out.println("Modifica Ora: ");
					int oraFine = input.nextInt();
					System.out.println("Modifica Minuti: ");
					int minutiFine = input.nextInt();
					Ora orarioFine = new Ora(oraFine, minutiFine);
					
					stmt.executeUpdate("UPDATE appuntamenti SET fine='"+ orarioFine.toString() +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				case 3:
					System.out.println("Modificando data del Appuntamento:");
					System.out.print("Modifica Giorno: ");
					int giorno = input.nextInt();
					System.out.print("Modifica mese (1 a 12): ");
					int mese = input.nextInt(); 
					System.out.print("Modifica Anno: ");
					int anno = input.nextInt(); 
					String data = anno+"-"+mese+"-"+giorno;
					
					stmt.executeUpdate("UPDATE appuntamenti SET data='"+ data +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				case 4:
					System.out.println("Modificando il motivo del Appuntamento");
					System.out.println("Modifica Motivo:");
					input.nextLine();
					String motivo = input.nextLine();
					
					stmt.executeUpdate("UPDATE appuntamenti SET oggetto='"+ motivo +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				case 5:
					System.out.println("Modificando la persona da incontrare");
					input.nextLine();
					System.out.println("Modifica nome:");
					String nome = input.nextLine();
					System.out.println("Modifica cognome:");
					String cognome = input.nextLine();
					
					stmt.executeUpdate("UPDATE appuntamenti SET nome='"+ nome +"', cognome='"+ cognome +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				case 6:
					System.out.println("Modificando il livello d'Importanza");
					System.out.println("Quanto e importante questo appuntamento?");
					System.out.println("1 - Non Necessario");
					System.out.println("2 - Normale");
					System.out.println("3 - Importantissimo");
					System.out.println("Indica l'importanza da 1 a 3: ");
					int importanza = input.nextInt();
					Appuntamento.Grado grado = Appuntamento.Grado.values()[importanza-1];
					
					stmt.executeUpdate("UPDATE appuntamenti SET importanza='"+ grado +"' WHERE id='"+ idAppuntamento +"'");
					System.out.println("Modifica Eseguita.");
					break;
					
				default:
					System.out.println("Selezionare una delle opzioni disponibili.");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int index) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM appuntamenti WHERE id='"+ index +"'");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}