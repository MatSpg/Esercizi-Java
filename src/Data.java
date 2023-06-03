
public class Data {
	Ora ora;
	Durata durata;
	Giorno giorno;
	
	Data(Ora ora, Durata durata, Giorno giorno){
		this.ora = ora;
		this.durata = durata;
		this.giorno = giorno;
	}
	
	public String toString() {
		return "Ora: "+this.ora+" | Durata: "+this.durata+" | "+this.giorno;
	}
	
	public String getData() {
		return this.giorno.anno+"-"+this.giorno.mese.ordinal()+"-"+this.giorno.giorno;
	}
}

class Ora {
	int ora;
	int minuti;
	
	Ora(int ora, int minuti){
		this.ora = ora;
		this.minuti = minuti;
	}
	
	public String toString(){
		return String.format("%02d:%02d", this.ora, this.minuti);
	}
}

class Durata {
	int ora;
	int minuti;
	
	Durata(int ora, int minuti) {
		this.ora = ora;
		this.minuti = minuti;
	}
	
	public String toString() {
		return String.format("%02d:%02d", this.ora, this.minuti);
	}
}

class Giorno {
	public enum Mese {
		Non_Specificato,
		Gennaio,
		Febbraio,
		Marzo,
		Aprile,
		Maggio,
		Giugno,
		Luglio,
		Agosto,
		Settembre,
		Ottobre,
		Novembre,
		Dicembre
	}
	
	int giorno;
	Mese mese;
	int anno;
	
	Giorno(int giorno, Mese mese, int anno){
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
	}
	
	public String toString() {
		return "Giorno: "+this.giorno+" | Mese: "+this.mese+" | Anno: "+this.anno;
	}
}
