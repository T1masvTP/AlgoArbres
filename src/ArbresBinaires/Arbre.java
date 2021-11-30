package ArbresBinaires;

import java.util.LinkedList;

/**
 * Cette classe est dite générique car le contenu du noeud de l'arbre peut être de tout type
 */
public class Arbre<E> {

	protected E contenu; // contenu du noeud
	protected Arbre<E> filsG, filsD; // les sous-arbres

	/**
	 * Constructeur
	 * 
	 * @param g
	 *            sous-arbre gauche
	 * @param c
	 *            contenu du noeud
	 * @param d
	 *            sous-arbre droit
	 */
	public Arbre(Arbre<E> g, E c, Arbre<E> d) {
		this.filsG = g;
		this.contenu = c;
		this.filsD = d;
	}

	/**
	 * Constructeur d'arbre vide
	 */
	public Arbre() {
		this(null, null, null);
	}

	/**
	 * Constructeur de feuille càd un contenu et deux sous-arbres vides
	 */
	public Arbre(E contenu) {
		this(new Arbre<E>(), contenu, new Arbre<E>());
	}

	/**
	 * Teste si l'arbre courant est vide
	 */
	public boolean estVide() {
		return this.filsG == null && this.filsD == null && this.contenu == null;
	}

	/**
	 * Retourne la taille de l'arbre courant
	 */
	public int taille() {
		if(this.estVide()){
			return 0;
		}
		return 1+this.filsD.taille()+this.filsG.taille();
	}

	/**
	 * Retourne vrai si l'arbre courant est une feuille
	 */
	public boolean estFeuille() {
		return (this.contenu != null && this.filsD.estVide() && this.filsG.estVide());
	}

	/**
	 * Retourne le nombre de feuilles de l'arbre courant
	 */
	public int nbFeuilles() {
		if(this.estVide())return 0;
    	else{
			if(estFeuille()) return 1;
			else return this.filsG.nbFeuilles() + this.filsD.nbFeuilles();
		}
	}

	/**
	 * Retourne la hauteur de l'arbre courant (0 si feuille)
	 */
	public int hauteur() {
		if (this.estVide()) return -1;
		else return max( this.filsD.hauteur(), this.filsG.hauteur()) + 1;
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours préfixe
	 */
	public void parcoursPrefixe() {
		if(this.estVide())return;
		System.out.println(this.contenu);
		this.filsG.parcoursPrefixe();
		this.filsD.parcoursPrefixe();
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours infixe
	 */
	public void parcoursInfixe() {
		if(this.estVide())return;
		this.filsG.parcoursInfixe();
		System.out.println(this.contenu);
		this.filsD.parcoursInfixe();
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours postfixe
	 */
	public void parcoursPostfixe() {

		if(this.estVide())return;
		this.filsG.parcoursPostfixe();
		this.filsD.parcoursPostfixe();
		System.out.println(this.contenu);
	}

	/**
	 * Affiche les contenus de l'arbre courant en effectuant un parcours en largeur
	 */
	public void parcoursLargeur() {
		if (this.estVide()) return;
		LinkedList<Arbre<E>> queue = new LinkedList<>();
		queue.add(this);
		while(!queue.isEmpty()){
			System.out.println(queue.getLast().getContenu());
			if(!queue.getLast().getFilsG().estVide()) queue.addFirst(queue.getLast().getFilsG());
			if(!queue.getLast().getFilsD().estVide()) queue.addFirst(queue.getLast().getFilsD());
			queue.removeLast();
		}


	}

	public int max(int a, int b){
		return a>b ? a:b;
	}

	/**************************
	 * Getters et utilitaires *
	 **************************/

	public Arbre<E> getFilsG() {
		return this.filsG;
	}

	public Arbre<E> getFilsD() {
		return this.filsD;
	}

	public E getContenu() {
		return this.contenu;
	}

	public boolean estIdentiqueA(Arbre<E> b) {
		if (this.estVide() && b.estVide())
			return true;
		if (!this.estVide() && !b.estVide() && this.contenu.equals(b.contenu))
			return this.filsG.estIdentiqueA(b.filsG) && this.filsD.estIdentiqueA(b.filsD);
		else
			return false;
	}

	@Override
	public String toString() {
		if (this.estVide())
			return "vide";
		return "[filsG=" + filsG + ", contenu=" + contenu + ", filsD=" + filsD + "]";
	}

}
