
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
		String giornoFormat = String.format("%02d", this.giorno.giorno);
		String meseFormat = String.format("%02d", this.giorno.mese.ordinal());
		
		return this.giorno.anno+"-"+meseFormat+"-"+giornoFormat;
	}
	
	public boolean equals(Data data) {
		if (this.giorno.giorno == data.giorno.giorno && 
				this.giorno.anno == data.giorno.anno &&
				this.giorno.mese == data.giorno.mese) {
			return true;
		} else {
			return false;
		}
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
	
	public boolean equals(Giorno g) {
		return this.giorno == g.giorno && this.mese == g.mese && this.anno == g.anno;
	}
	
	public int compareTo(Giorno g) {
		if(this.anno > g.anno) {
			return 1;
		}
		if(this.anno < g.anno) {
			return -1;
		}
		
		if(this.mese.ordinal() > g.mese.ordinal()) {
			return 1;
		}
		if(this.mese.ordinal() < g.mese.ordinal()) {
			return -1;
		}
		
		if(this.giorno > g.giorno) {
			return 1;
		}
		if(this.giorno < g.giorno) {
			return -1;
		}
		return 0;
	}
}
