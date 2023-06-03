
public class Persona {
	String nome;
	String cognome;
	
	Persona(String nome, String cognome){
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String toString() {
		return nome+" "+cognome;
	}
}
