package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Execut {

	public static void main(String[] args) {
		FilmDataRequester fdr = new FilmDataRequester();
		ArrayList<String> f = fdr.getRecommendations(17136, 21592);
		System.out.println("Size " + f.size());
		for(String felem : f) {
			System.out.println(felem);
		}

	}

}
