package ArbresBinaires;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests des méthodes de la classe Arbre. On travaille sur des instances de ArbreInt càd des arbres dont les contenus
 * sont des entiers.
 */
public class ArbreTest {

	private static ArbreInt arbreVide;
	private static ArbreInt arbreFeuille;
	private static ArbreInt arbre1Fils;
	private static ArbreInt arbreQcq;
	private static ArbreInt arbreQcq2;

	@Before
	public void setUp() throws Exception {
		arbreVide = new ArbreInt();
		arbreFeuille = new ArbreInt(5);
		arbre1Fils = new ArbreInt(new ArbreInt(), 1, new ArbreInt(2));
		arbreQcq = new ArbreInt(new ArbreInt(new ArbreInt(), 2, new ArbreInt(33)), 5,
				new ArbreInt(new ArbreInt(6), 8,
						new ArbreInt(new ArbreInt(9), 10, new ArbreInt())));
		arbreQcq2 = new ArbreInt(new ArbreInt(new ArbreInt(), 2, new ArbreInt(33)), 5,
				new ArbreInt(new ArbreInt(6), 8,
						new ArbreInt(arbre1Fils, 10, new ArbreInt())));
	}

	@Test
	public void testTaille() {
		assertEquals("Taille arbre null", 0, arbreVide.taille());
		assertEquals("Taille arbre feuille", 1, arbreFeuille.taille());
		assertEquals("Taille arbre un fils", 2, arbre1Fils.taille());
		assertEquals("Taille arbre qcq", 7, arbreQcq.taille());
		assertEquals("Taille arbre qcq2", 8, arbreQcq2.taille());
	}

	@Test
	public void testEstFeuille() {
		assertFalse("estFeuille sur arbre null", arbreVide.estFeuille());
		assertTrue("estFeuille sur arbre feuille", arbreFeuille.estFeuille());
		assertFalse("estFeuille sur arbre un fils", arbre1Fils.estFeuille());
		assertFalse("estFeuille sur arbre qcq", arbreQcq.estFeuille());
	}

	@Test
	public void testNbFeuille() {
		assertEquals("Nbre feuilles arbre vide", 0, arbreVide.nbFeuilles());
		assertEquals("Nbre feuilles arbre feuille", 1, arbreFeuille.nbFeuilles());
		assertEquals("Nbre feuilles arbre un fils", 1, arbre1Fils.nbFeuilles());
		assertEquals("Nbre feuilles arbre qcq", 3, arbreQcq.nbFeuilles());
		assertEquals("Nbre feuilles arbre qcq2", 3, arbreQcq2.nbFeuilles());
	}

	@Test
	public void testHauteur() {
		assertEquals("Hauteur arbre null", -1, arbreVide.hauteur());
		assertEquals("Hauteur arbre feuille", 0, arbreFeuille.hauteur());
		assertEquals("Hauteur arbre feuille", 1, arbre1Fils.hauteur());
		assertEquals("Hauteur arbre qcq", 3, arbreQcq.hauteur());
		assertEquals("Hauteur arbre qcq2", 4, arbreQcq2.hauteur());
	}

}
