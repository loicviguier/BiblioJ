package biblioj

import java.util.Map;

import org.hibernate.Criteria
class LivreService {

	def rechercheLivre(Map params) {
	   def titreRecherche = params.champRechercheTitreLivre
	   def auteurRecherche = params.champRechercheAuteurLivre
	   def typeRecherche = params.champRechercheTypeLivre
	   if (!params.max) {
		   params.max = 0
	   }
		def livreResultantList = getLivre(params)
		println livreResultantList
		[livreInstanceList:livreResultantList, livreInstanceTotal: livreResultantList.totalCount]
    }
	
	def getLivre(Map params) {
		def titreRecherche = params.champRechercheTitreLivre
		def auteurRecherche = params.champRechercheAuteurLivre
		def typeRecherche = params.champRechercheTypeLivre
		
		int offsetP
		if (!params.offset) {
			offsetP = 0
		} else {
			offsetP = Integer.valueOf(params.offset)
		}

		int maxRes
		if (!params.max) {
			maxRes = 0
		} else {
			maxRes = Integer.valueOf(params.max)
		}
		
		def res = Livre.createCriteria()
		def resultats = res.list(offset: offsetP, max: maxRes) {
			if(titreRecherche) {
				ilike("titre",'%'+titreRecherche+'%')
			}
			
			if(auteurRecherche) {
				auteurs {
					or {
						ilike("nom",'%'+auteurRecherche+'%')
						ilike("prenom",'%'+auteurRecherche+'%')
					}
				}
			}
			
			if(typeRecherche) {
				type {
					ilike("intitul",typeRecherche)
				}
			}
		}
	}
}
