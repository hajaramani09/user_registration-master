package codingtechniques.model;

public enum Service {
        restaurant("Restaurant"),
        piscine("Piscine"),
        salle_de_Fete("Salle de Fête"),
        activites_et_Detent("Activités et détent"),
        cuisine_Marocaine("Cuisine Marocaine"),
        traiteur("Traiteur"),
        neggafa("Neggafa"),
        bungalows("Bungalows");

        String value;

        Service(String value) {
            this.value =value;
        }
}