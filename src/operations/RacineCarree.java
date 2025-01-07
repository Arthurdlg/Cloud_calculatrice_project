package operations;

public class RacineCarree {
    public static double calculer(double nombre) {
        if (nombre < 0) {
            throw new IllegalArgumentException("Le nombre doit être positif pour calculer la racine carrée.");
        }
        return Math.sqrt(nombre);
    }
}
