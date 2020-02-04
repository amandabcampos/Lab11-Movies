import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * @author amandabcampos
 *
 */

public class MovieCatalog {

	private List<Movie> movies = new ArrayList<>();

	public MovieCatalog() {
		for (int i = 1; i < 101; i++) {
			movies.add(MovieIO.getMovie(i));
		}
	}

	public List<String> getMoviesTitlesInCategory(String category) {
		if (isInt(category)) {
			try {
				category = getCategories().get(Integer.parseInt(category) - 1);
			} catch (IndexOutOfBoundsException e) {
				category = generateRandomCategory();
				System.out.println("No such category. How about " + category + "?");
			}
		}
		System.out.println("*******");
		System.out.println(category.toUpperCase());
		System.out.println("*******");
		List<String> moviesInCategory = new ArrayList<>();

		for (Movie movie : movies) {
			if (movie.getCategory().equalsIgnoreCase(category)) {
				moviesInCategory.add(movie.getTitle());
			}
		}
		Collections.sort(moviesInCategory);
		return moviesInCategory;
	}

	public int getQuantityMovies() {
		return movies.size();
	}

	public List<String> getCategories() {
		List<String> categories = new ArrayList<>();
		for (Movie movie : movies) {
			if (!categories.contains(movie.getCategory())) {
				categories.add(movie.getCategory());
			}
		}
		Collections.sort(categories);
		return categories;
	}

	public int getCategoriesAmount() {
		return getCategories().size();
	}

	public boolean isInt(String category) {
		return category.matches("[-]*[\\d]+");
	}

	public String generateRandomCategory() {
		return getCategories().get((int) Math.ceil(Math.random() * getCategoriesAmount() - 1));
	}

}
