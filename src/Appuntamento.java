import java.util.ArrayList;
import java.util.List;

public class Appuntamento {
	enum Grado {
		Non_Necessario,
		Normale,
		Importantissimo;
	}
	
	Data data;
	String motivo;
	Grado grado;
	Persona persona;
	
	Appuntamento(){
		
	}
	
	Appuntamento(Data data, String motivo, Grado grado, Persona persona){
		this.data = data;
		this.motivo = motivo;
		this.grado = grado;
		this.persona = persona;
	}
	
	public String appuntamento(int index) {
		return "Appuntamento: \n"+apList.get(index).data.toString()+" | Motivo: "+apList.get(index).motivo+" | Grado: "+apList.get(index).grado;
	}
	
	DatabaseManager db = new DatabaseManager();
	ArrayList<Appuntamento> apList = new ArrayList<>();
	public void aggiungi(Appuntamento appuntamento) {
		apList.add(appuntamento);
		db.create(appuntamento);
	}
	
	public void elimina(int index) {
		apList.remove(index);
		System.out.println(apList.size());
	}
	
	public void appuntamenti() {
		System.out.println(apList);
	}
	
	public void allAp() {
		for(int i=0; i < apList.size(); i++) {
			System.out.println(i+" "+appuntamento(i));
		}
	}
	
	public void ricerca(int annoInizio, int annoFine) {
		for(int i=0; i < apList.size(); i++) {
			if (apList.get(i).data.giorno.anno >= annoInizio && apList.get(i).data.giorno.anno <= annoFine) {
				System.out.println(i+" Appuntamento: "+apList.get(i).data+" | Motivo: "+apList.get(i).motivo+" | Grado: "+apList.get(i).grado+" | Persona: "+apList.get(i).persona);
			}
		}
	}
	
	ArrayList<Appuntamento> apListData = new ArrayList<>();
	public void ordinaPerData(boolean messaggio) {
		apListData = (ArrayList<Appuntamento>)apList.clone();
		// Selection Sort
		for(int i=0; i < apListData.size()-1; i++) {
			int minIndex = i;
            for (int j = i + 1; j < apListData.size(); j++) {
                if (apListData.get(j).data.getData().compareTo(apListData.get(minIndex).data.getData()) < 0) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                Appuntamento temporaneo = apListData.get(i);
                apListData.set(i, apListData.get(minIndex));
                apListData.set(minIndex, temporaneo);
            }
		}
		
		if(messaggio == true) {
			for(int i=0; i < apListData.size(); i++) {
				System.out.println(i+" Appuntamento: \n"+apListData.get(i).data.toString()+" | Motivo: "+apListData.get(i).motivo+" | Grado: "+apListData.get(i).grado);
			}
		}

	}
	
	public void ordinaPerImportanza(int ordine) {
		ArrayList<Appuntamento> apListImportanza = new ArrayList<>();
		apListImportanza = (ArrayList<Appuntamento>)apList.clone();
		if(ordine == 1) {
			// Bubble Sort
			boolean scambio;
			for(int i=0; i < apListImportanza.size()-1; i++) {
				scambio = false;
				for(int j = 0; j < apListImportanza.size()-1; j++) {
					if(apListImportanza.get(j).grado.ordinal() < apListImportanza.get(j+1).grado.ordinal()) {
						Appuntamento temporaneo = apListImportanza.get(j);
						apListImportanza.set(j, apListImportanza.get(j+1));
						apListImportanza.set(j+1, temporaneo);
						scambio = true;
					}
					if(!scambio) {
						break;
					}
				}
			}
		} else if (ordine == 2) {
			// Bubble Sort
			boolean scambio;
			for(int i=0; i < apListImportanza.size()-1; i++) {
				scambio = false;
				for(int j = 0; j < apListImportanza.size()-1; j++) {
					if(apListImportanza.get(j).grado.ordinal() > apListImportanza.get(j+1).grado.ordinal()) {
						Appuntamento temporaneo = apListImportanza.get(j);
						apListImportanza.set(j, apListImportanza.get(j+1));
						apListImportanza.set(j+1, temporaneo);
						scambio = true;
					}
					if(!scambio) {
						break;
					}
				}
			}
		}
		for(int i=0; i < apListImportanza.size(); i++) {
			System.out.println(i+" Appuntamento: \n"+apListImportanza.get(i).data.toString()+" | Motivo: "+apListImportanza.get(i).motivo+" | Grado: "+apListImportanza.get(i).grado);
		}
	}
	
	public Appuntamento ricercaBinaria(List<Appuntamento> lista, Giorno giornoCercato) {
	
		if (lista.size() == 0) {
			return null;
		}
		if (lista.size() == 1) {
			if (lista.get(0).data.giorno.equals(giornoCercato)) {
				return lista.get(0);
			}
			return null;
		}
		int posLastElem = lista.size()-1;
		int meta = posLastElem/2;
		Giorno giornoCorrente = lista.get(meta).data.giorno;
		
		if (giornoCorrente.equals(giornoCercato)) {
			return lista.get(meta);
		}
		if(giornoCorrente.compareTo(giornoCercato) < 0) {
			return ricercaBinaria(lista.subList(meta+1, posLastElem), giornoCercato);
		} else {
			return ricercaBinaria(lista.subList(0, meta+1), giornoCercato);
		}
	}
}


