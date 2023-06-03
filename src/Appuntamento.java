import java.util.ArrayList;

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
	public void ordinaPerData() {
		apListData = (ArrayList)apList.clone();
		// Selection Sort
		for(int i=0; i < apListData.size() - 1; i++) {
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
		for(int i=0; i < apListData.size(); i++) {
			System.out.println(i+" Appuntamento: \n"+apListData.get(i).data.toString()+" | Motivo: "+apListData.get(i).motivo+" | Grado: "+apListData.get(i).grado);
		}
	}
	
	public void ordinaPerImportanza(int ordine) {
		ArrayList<Appuntamento> apListImportanza = new ArrayList<>();
		apListImportanza = (ArrayList)apList.clone();
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
	
	public Appuntamento ricercaBinaria(String data) {
		ordinaPerData();
		
		int i = 0;
		int fine = apListData.size()-1;
		while(i <= fine) {
			int indiceMedio = (i + fine) / 2;
			Appuntamento appuntamentoMedio = apListData.get(indiceMedio);
			int confronto = appuntamentoMedio.data.getData().compareTo(data);
			
			if (confronto == 0) {
				return appuntamentoMedio;
			} else if (confronto < 0) {
				i = indiceMedio+1;
			} else {
				fine = indiceMedio-1;
			}
		}
		return null;
	}
}


