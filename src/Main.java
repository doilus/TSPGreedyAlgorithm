
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int size = 980;

	public static void main(String[] args) {
		
		
		String[] str;
		int id;
		double long_scale;
		double lat_scale;
		
		List<City> cities = new ArrayList<City>();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:/Users/domlu/eclipse-workspace2/TSPGreedyAlgorithm/bin/txt/cities.txt"));
			String line = reader.readLine();
	
		
		while(line != null) {
			str = line.split(" ");
			line = reader.readLine();
			id = Integer.parseInt(str[0]);
			long_scale = Double.parseDouble(str[1]);
			lat_scale = Double.parseDouble(str[2]);
			//System.out.println(id + " " + long_scale + " " + lat_scale);
			
			//create objects
			cities.add(new City(id,long_scale,lat_scale));
			
		}
		
		reader.close();
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		//for(City city : cities) {
		//System.out.println(city.getId());}
		//System.out.println(cities.indexOf(1));
		//	}
			
			
			
			//spr wyświetlenie zawartości tablicy
			/*for(int i=0;i< distance.length; i++) {
				for(int j=0; j< distance.length;j++) {
					System.out.println(i + " " + j + " "+ distance[i][j]);
				}
			}*/
		
			
			//transit callback
			final long[][] distance = computeDistance(cities);
			/*
			int [][] tab = new int[980][980];
			
			for(int i = 0; i< 980;i++) {
				for(int j=0; j< 980;j++) {
					tab[i][j] = (int) distance[i][j];
					System.out.print(j);
				}
				System.out.println();
			}*/
			
			int[] shortPath = nearestCity(distance);
			
			long best = 0;
			for(int i = 0; i < size-1;i++) {
				best += distance[shortPath[i]-1][shortPath[i+1]-1];	
			}
			best += distance[shortPath[size-1]][shortPath[0]];
			
			System.out.println("Shortest path: " + best);
			
			printPath(shortPath);
			
			/*for(int i = 0; i< 20;i++) {
				for(int j=0; j< distance.length;j++) {
					System.out.print(distance[i][j]+",");
				}
				System.out.println("linia:" + i);
			}*/
			
	}
	

	public static int[] nearestCity(long[][] distance) {
		boolean[] copy = new boolean[size];
		int[] shortPath = new int[size];
		int current = 0;
		
		int bestDistance = Integer.MAX_VALUE;
		
		int town = current;
		for(int i=0; i< 980;i++) {
			Arrays.fill(copy, true);
			long shortest = 0; 
			int dist = 0;
			int[] temp = new int[size];
			int index = 0;
			temp[index++] = i+1;
			current = i;
			
			for(int j=0; j < size - 1; j++) {
				shortest = Integer.MAX_VALUE;
				
				for(int x=0; x < size; x++) {
					if(x == current) continue;
					if(copy[x] && (distance[current][x] < shortest)){
						town = x;
						shortest = distance[current][x];
					}
				}
				copy[current] = false;
				temp[index++] = town +1;
				current = town;
				dist+=shortest;
			}
			dist += distance[temp[index-1]-1][temp[0]-1];
			if(dist < bestDistance) {
				shortPath = Arrays.copyOf(temp, temp.length);
				bestDistance = dist;
			}
		}
		return shortPath;
	}
	


	//computes the distance between cities
	private static long[][] computeDistance(List cities){
		long[][] distance= new long[cities.size()][cities.size()];
		
		for(int i =0; i< cities.size(); i++ ) {
			for(int j=0; j< cities.size(); j++) {
				if(i == j) {
					distance[i][j] = 0;
				} else {
					distance[i][j] = (long) Math.hypot(((City) cities.get(i)).getLong_scale() - ((City) cities.get(j)).getLong_scale()
							, ((City) cities.get(j)).getLat_scale() - ((City) cities.get(i)).getLat_scale()) ;
				}
			}
		}
		return distance;
	}
	
	public static void printPath(int[] path) {
		for(int i=0;i<size-1;i++) {
			System.out.print(path[i]+" -> ");
		}
		System.out.println(path[size-1]);
	}
	
	/*
	void tsp_greedy(List cities) {
		
	}
	
	Double shortest_tour(Double tours){
		return min(tours, key= tour_length);
	}
*/
}
