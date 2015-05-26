package tsp;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum Algorithm {

	/**
	 * @return Held-Karp algorithm Path
	 */
	HeldKarp {
	
		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinates,
				Point initialPoint) {

			return coordinates;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Long returnTime() {
			// TODO Auto-generated method stub
			return null;
		}

	},

	/**
	 * @return Nearest neighbour Path
	 */
	Neighbour {

		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinates,
				Point initialPoint) {

			return coordinates;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Long returnTime() {
			// TODO Auto-generated method stub
			return null;
		}

	},

	/**
	 * @return Volledige Enumeratie Path
	 */
	Enumeratie {

		private ArrayList<Point> coordinates;
		private long start = 0;
		private long stop = 0;
		

		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinates,
				Point initialPoint) {
			
			//TIMER START
			
			start = System.currentTimeMillis();
			
			this.coordinates = coordinates;

			List<List<Point>> perm = new ArrayList<List<Point>>();
			HashMap<Float, List<Point>> hashmap;

			perm = generatePermutation(this.coordinates);
			hashmap = new HashMap<Float, List<Point>>();
			float lowest = -1;

			for (List<Point> pointList : perm) {

				pointList.add(initialPoint);
				pointList.add(0, initialPoint);

				int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

				float totalDist = 0;
				float dist = 0;

				for (int i = 0; i < pointList.size(); i++) {

					Point pointCalculate = pointList.get(i);

					if (x1 == -1 && y1 == -1) {

						x1 = (int) pointCalculate.getX();
						y1 = (int) pointCalculate.getY();

					} else {

						x2 = x1;
						y2 = y1;

						x1 = (int) pointCalculate.getX();
						y1 = (int) pointCalculate.getY();

						dist = (float) Math.sqrt(Math.pow(x1 - x2, 2)
								+ Math.pow(y1 - y2, 2));

					}

					totalDist = totalDist + dist;

				}
				if (lowest == -1) {
					lowest = totalDist;
				} else {
					if (lowest >= totalDist) {
						lowest = totalDist;
					}
				}

				hashmap.put(totalDist, pointList);

			}

			this.coordinates = (ArrayList<Point>) hashmap.get(lowest);
			
			// TIMER STOP 
			
			stop = System.currentTimeMillis();

			return this.coordinates;
		}

		public List<List<Point>> generatePermutation(List<Point> original) {
			int i = 0;
			if (original.size() == 0) {
				List<List<Point>> result = new ArrayList<List<Point>>();
				result.add(new ArrayList<Point>());
				return result;
			}
			Point firstElement = original.remove(0);
			List<List<Point>> returnValue;
			returnValue = new ArrayList<List<Point>>();
			List<List<Point>> permutations = generatePermutation(original);
			for (List<Point> smallerPermutated : permutations) {
				for (int index = 0; index <= smallerPermutated.size(); index++) {
					List<Point> temp = new ArrayList<Point>(smallerPermutated);

					temp.add(index, firstElement);

					returnValue.add(temp);

				}
			}

			return returnValue;
		}

		@Override
		public String toString() {
			String toReturn = "";
			if(this.coordinates == null){
				toReturn = "There is nothing to calculate.";
			}else{
				toReturn = "The shortest route is: \n\n";
				int i = 1; 
				String add = "";
				for(Point coordinate: this.coordinates){
					add = add+ i+": "+coordinate.toString()+"\n";
					i++;
				}
				toReturn = toReturn+add;
				toReturn = toReturn + "\n"+"Calculation Time is: \n"+returnTime()+"Ms";
			}
			return toReturn;
		}

		@Override
		public Long returnTime() {
			
			long toReturn;
			
			if(start != 0){
				toReturn = stop - start;
			}else{
				toReturn = 0;
			}

			return toReturn;
		}

	};

	/**
	 * @param coordinates
	 *            - Coordinates made before to calculate a path
	 * @param initialPoint
	 *            - Point where you want to Start and End
	 * @return an sorted ArrayList with points used in {@link Algorithm}
	 */
	public abstract ArrayList<Point> calculatePath(
			ArrayList<Point> coordinates, Point initialPoint);
	
	/**
	 * @return String with given Path and time of calculation {@link Algorithm}
	 */
	public abstract String toString();
	
	/**
	 * @return Time of calculation in Ms{@link Algorithm}
	 */
	public abstract Long returnTime();


}