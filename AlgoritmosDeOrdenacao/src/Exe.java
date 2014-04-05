
public class Exe {

	public static void main(String[] args) {
		int[] vet = {2,3,4,6,8,9,7,1,5,10};
		
		Bubble bolha = new Bubble(vet);
		
		Quick qs = new Quick();
		
		qs.quick_sort(vet, 0, (vet.length-1));
		
		System.out.println("Metodo Quick Short");
		for (int i = 0; i < vet.length; i++) {
            System.out.println(" "+ vet[i]);
        }
 
	}

}
