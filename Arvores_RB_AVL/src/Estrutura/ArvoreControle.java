package Estrutura;

public class ArvoreControle 
{
	int opcao = 0;
	private View view = new View();
	private AvlTree AvlTree = new AvlTree();
	private RbTree<Integer, Integer> arvoreRB = new RbTree<Integer, Integer>();
	Contador cont = new Contador();
	
	public void ExibeMenu()
	{
		do
		{
			view.Menu();
			opcao = view.LerOpcao();
			switch (opcao) 
			{
				case 1:
					Inserir();
					break;
				case 2:
					AvlTree.prefixa(AvlTree);
					break;
				case 3:
					AvlTree.infixa(AvlTree);
					break;
				case 4:
					AvlTree.posfixa(AvlTree);
					break;
				case 5:
					Excluir();
					break;
			}
		} 
		while (opcao != 9);
		
		view.Dispose();
	}
	
	public void Inserir()
	{
		int num = view.LerNumero(true);
		
		cont = new Contador("Arvore AVL");
		AvlTree = AvlTree.inserir(AvlTree, num, cont);
		view.Informacoes(cont.getComparacoes(), cont.getRotacoes(), cont.getArvore());
		
		cont = new Contador("Arvore RedBlack");
		arvoreRB.inserir(num, num, cont);
		view.Informacoes(cont.getComparacoes(), cont.getRotacoes(), cont.getArvore());	
	}
	
	public void Excluir()
	{
		int num = view.LerNumero(false);
		cont = new Contador("Arvore AVL");
		
		if (AvlTree.consultar(AvlTree, num, false, cont)) 
        {
			AvlTree = AvlTree.excluir(AvlTree, num);
			AvlTree = AvlTree.atualizar(AvlTree, cont);
			view.Exclusao();
			view.Informacoes(cont.getComparacoes(), cont.getRotacoes(), cont.getArvore());
			
			cont = new Contador("Arvore RedBlack");
			arvoreRB.delete(num, cont);
			view.Informacoes(cont.getComparacoes(), cont.getRotacoes(), cont.getArvore());
			
        }
		else
		{
			view.NaoAchou();
		}
	}
	
}
