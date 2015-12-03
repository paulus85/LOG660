package controller;

import java.util.HashMap;

public class Execut {

	public static void main(String[] args) {
		FilmDataRequester fdr = new FilmDataRequester();
		HashMap f = fdr.getRecommendations(17136, 21592);

	}

}
