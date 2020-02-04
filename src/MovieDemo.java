import java.util.List;
import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 *
 */

public class MovieDemo {

	private static MovieCatalog movieCatalog = new MovieCatalog();
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		greeting();

		boolean looping = true;
		while (looping) {

			displayMenu();
			displayMoviesInCategory(Validator.getString(scnr, "What category are you interested in? "));

			if (Validator.getString(scnr, "Continue? (y/n): ").toLowerCase().startsWith("n")) {
				looping = false;
			}
		}

		System.out.print("Don't forget the popcorn!");
		scnr.close();

	}

	public static void greeting() {
		System.out.println("Welcome to the Movie List Application!");
		System.out.println("There are " + movieCatalog.getQuantityMovies() + " movies in this list\n");
	}

	public static void displayMenu() {
		System.out.println("Categories available: ");
		for (int i = 0; i < movieCatalog.getCategories().size(); i++) {
			System.out.print(i + 1 + ". " + movieCatalog.getCategories().get(i) + "\t");
		}
		System.out.println();
	}

	public static void displayMoviesInCategory(String category) {
		List<String> moviesInCategory = movieCatalog.getMoviesTitlesInCategory(category);

		System.out.println();
		for (String movieTitle : moviesInCategory) {
			System.out.println(movieTitle);
		}
		System.out.println();
	}

}
