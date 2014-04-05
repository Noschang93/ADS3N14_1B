
public class Quick {
	
	 public void quick_sort(int[] vet, int inicio, int fim)
	 {	
		 int meio;
		 
	        if (inicio < fim)
	        {
	            meio = particionaArray(vet, inicio, fim);
	            quick_sort(vet, inicio, meio);
	           
	        }
	
		 }
	 
	 public int particionaArray(int[] vet, int inicio, int fim)
	 {		 
		  int pivo, topo, i;
	        pivo = vet[inicio];
	        topo = inicio;
	 
	        for (i = inicio + 1; i <= fim; i++) 
	        {
	            if (vet[i] < pivo)
	            {
	                vet[topo] = vet[i];
	                vet[i] = vet[topo + 1];
	                topo++;
	            }
	        }
	        vet[topo] = pivo;
		 	return topo;	 
	 }
}
