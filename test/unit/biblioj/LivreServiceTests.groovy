package biblioj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(LivreService)
class LivreServiceTests {

   LivreService livreService

    @Before
    void setUp() {

    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testrechercheLivreTitre() {
        def params = [titre: "hun"]
        assertEquals(1, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivreNom() {
        def params = [auteur: "col"]
 
        assertEquals(3, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivrePrenom() {
        def params = [auteur: "suz"]
 
        assertEquals(3, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivreNomPrenom() {
        def params = [auteur: "n"]
 
        assertEquals(7, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivreNomPrenomAucun() {
        def params = [auteur: "aaazzzz"]
 
        assertEquals(0, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivreType() {
        def params = [type: "Nouveauté"]
 
        assertEquals(6, livreService.rechercheLivre(params).livreInstanceTotal)
    }

    @Test
    void testrechercheLivreOffset() {
        def params = [type: "Nouveauté", offset: "5"]
 
        assertEquals(6, livreService.rechercheLivre(params).livreInstanceTotal)
		assert params.offset == 5
    }

    @Test
    void testrechercheLivreOrder() {
        def params = [order: "asc"]
 
        assertNotNull(livreService.rechercheLivre(params))
    }

    @Test
    void testrechercheLivreSort() {
        def params = [sort: "titre"]
        assertNotNull(livreService.rechercheLivre(params))
    }

    @Test
    void testrechercheLivreOrderSort() {
        def params = [sort: "titre", order: "asc"]
        assertNotNull(livreService.rechercheLivre(params))
    }
}
