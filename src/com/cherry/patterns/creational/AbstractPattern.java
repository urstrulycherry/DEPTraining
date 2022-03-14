package com.cherry.patterns.creational;

interface ITollywoodMovie {
	String movieName();
}

interface IBollywoodMovie {
	String movieName();
}

interface IMovieFactory {

	ITollywoodMovie getTollywoodMovie();

	IBollywoodMovie getBollywoodMovie();
}

class ActionMovieFactory implements IMovieFactory {
	@Override
	public ITollywoodMovie getTollywoodMovie() {
		return new TollywoodActionMovie();
	}

	@Override
	public IBollywoodMovie getBollywoodMovie() {
		return new BollywoodActionMovie();
	}
}

class ComedyMovieFactory implements IMovieFactory {
	@Override
	public ITollywoodMovie getTollywoodMovie() {
		return new TollywoodComedyMovie();
	}

	@Override
	public IBollywoodMovie getBollywoodMovie() {
		return new BollywoodComedyMovie();
	}
}

class TollywoodActionMovie implements ITollywoodMovie {
	@Override
	public String movieName() {
		return "Sarkaru Vaari Paata";
	}
}

class BollywoodActionMovie implements IBollywoodMovie {
	@Override
	public String movieName() {
		return "War";
	}
}

class TollywoodComedyMovie implements ITollywoodMovie {
	@Override
	public String movieName() {
		return "Jathi Ratnalu";
	}
}

class BollywoodComedyMovie implements IBollywoodMovie {
	@Override
	public String movieName() {
		return "Welcome";
	}
}

public class AbstractPattern {

	public static void main(String[] args) {
		System.out.println("*** Abstract Factory Pattern Demo ***");
		ActionMovieFactory actionMovies = new ActionMovieFactory();
		ITollywoodMovie telAction = actionMovies.getTollywoodMovie();
		IBollywoodMovie hinAction = actionMovies.getBollywoodMovie();
		System.out.println("\nAction movies are:");
		System.out.println(telAction.movieName() + " is a Tollywood Action Movie");
		System.out.println(hinAction.movieName() + " is a Bollywood Action Movie");

		ComedyMovieFactory comedyMovies = new ComedyMovieFactory();
		ITollywoodMovie telComedy = comedyMovies.getTollywoodMovie();
		IBollywoodMovie hinComedy = comedyMovies.getBollywoodMovie();
		System.out.println("\nComedy movies are:");
		System.out.println(telComedy.movieName() + " is a Tollywood Comedy Movie");
		System.out.println(hinComedy.movieName() + " is a Bollywood Comedy Movie");
	}
}
