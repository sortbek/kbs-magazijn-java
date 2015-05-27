package tsp;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public enum Algorithm {

	/**
	 * @return 3rd algorithm Path
	 */
	third {

		private ArrayList<Point> coordinates;

		private long start;
		private long stop;
		private float totalDist;
		private Point initialPoint;

		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinates,
				Point initialPoint) {

			start = 0;
			stop = 0;
			totalDist = 0;

			start = System.currentTimeMillis();

			this.coordinates = coordinates;
			this.initialPoint = initialPoint;

			Collections.sort(coordinates, new Comparator<Point>() {

				public int compare(final Point a, final Point b) {
					if (a.x < b.x) {
						if (a.y > b.y) {
							return -2;
						} else {
							return -1;
						}

					} else if (a.x > b.x) {
						if (a.y > b.y) {
							return 2;
						} else {
							return 1;
						}
					} else {
						return 0;
					}

				}

			});
			
			double highestX = 0;
					
			if(coordinates.size() > 10){
				
				for (int i = 0; i < coordinates.size(); i++) {

					double x = coordinates.get(i).getX();
					if (highestX < x) {
						highestX = x;
					}
				}
				ArrayList<Point> coordinatesHighestX = new ArrayList<Point>();

				for (Point point : coordinates) {
					double x1 = point.getX();
					if (highestX == x1) {
						coordinatesHighestX.add(point);
					}
				}

				for (Point point : coordinatesHighestX) {
					if (coordinates.contains(point)) {
						coordinates.remove(point);
					}
				}

				Collections.sort(coordinatesHighestX, new Comparator<Point>() {

					public int compare(final Point a, final Point b) {
						if (a.y < b.y) {
							return -1;
						} else if (a.y > b.y) {
							return 1;
						} else {
							return 0;
						}
					}

				});

				coordinates.addAll(coordinatesHighestX);

				
			}

			double highestY = 0;
			if (coordinates.size() > 10) {

				for (int i = 0; i < coordinates.size(); i++) {

					double y = coordinates.get(i).getY();
					if (highestY < y) {
						highestY = y;
					}
				}
				ArrayList<Point> coordinatesHighestY = new ArrayList<Point>();

				for (Point point : coordinates) {
					double y1 = point.getY();
					if (highestY == y1) {
						coordinatesHighestY.add(point);
					}
				}

				for (Point point : coordinatesHighestY) {
					if (coordinates.contains(point)) {
						coordinates.remove(point);
					}
				}

				Collections.sort(coordinatesHighestY, new Comparator<Point>() {

					public int compare(final Point a, final Point b) {
						if (a.x > b.x) {
							return -1;
						} else if (a.x < b.x) {
							return 1;
						} else {
							return 0;
						}
					}

				});

				coordinates.addAll(coordinatesHighestY);

			}

			coordinates.add(0, initialPoint);
			coordinates.add(initialPoint);

			float dist = 0;

			int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

			for (int i = 0; i < this.coordinates.size(); i++) {

				if (x1 == -1 && y1 == -1) {
					x1 = initialPoint.x;
					y1 = initialPoint.y;
				} else {
					x2 = (int) coordinates.get(i).getX();
					y2 = (int) coordinates.get(i).getY();

					dist = (float) Math.sqrt(Math.pow(x1 - x2, 2)
							+ Math.pow(y1 - y2, 2));

					x1 = x2;
					y1 = y2;

					totalDist = totalDist + dist;

				}

			}

			stop = System.currentTimeMillis();
			return coordinates;
		}

		@Override
		public String toString() {
			String toReturn = "";
			if (this.coordinates == null) {
				toReturn = "There is nothing to calculate.";
			} else {
				toReturn = "The shortest Neighbour route is: \n";
				int i = 1;
				String add = "";
				for (Point coordinate : this.coordinates) {
					add = add + i + ": " + coordinate.toString() + "\n";
					i++;
				}
				toReturn = toReturn + add;
				toReturn = toReturn + "\n" + "Calculation Time is: \n"
						+ returnTime() + "Ms";
				toReturn = toReturn + "\n" + "The Distance is: \n"
						+ returnDistance();
			}
			return toReturn;
		}

		@Override
		public Long returnTime() {
			long toReturn;

			if (start != 0) {
				toReturn = stop - start;
			} else {
				toReturn = 0;
			}

			return toReturn;

		}

		@Override
		public float returnDistance() {
			float toReturn = totalDist;
			return toReturn;
		}

	},

	/**
	 * @return Nearest neighbour Path
	 */
	Neighbour {

		private ArrayList<Point> coordinatesNeighInit;
		private ArrayList<Point> coordinatesNew;
		private long start;
		private long stop;
		private float totalDist;
		private Point initialPoint;

		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinatesNeig,
				Point initialPoint) {
			// System.out.println("Neighbour");
			// TIMER START
			start = 0;
			stop = 0;
			totalDist = 0;

			start = System.currentTimeMillis();

			this.coordinatesNeighInit = coordinatesNeig;
			this.initialPoint = initialPoint;

			coordinatesNew = new ArrayList<Point>();

			coordinatesNew.add(initialPoint);

			boolean first = true;

			int x1 = -1, x2 = -1, y1 = -1, y2 = -1;

			int remove = 0;

			while (!this.coordinatesNeighInit.isEmpty()) {

				float dist = 0;
				float currentDist = 9999999;

				if (x1 == -1 && y1 == -1) {

					x1 = (int) initialPoint.getX();
					y1 = (int) initialPoint.getY();

				}

				// System.out.println();
				// System.out.println("Distance check: ");

				for (int i = 0; i < this.coordinatesNeighInit.size(); i++) {

					x2 = (int) coordinatesNeig.get(i).getX();
					y2 = (int) coordinatesNeig.get(i).getY();

					dist = (float) Math.sqrt(Math.pow(x1 - x2, 2)
							+ Math.pow(y1 - y2, 2));

					// System.out.println("x1: "+x1+" y1: "+y1+" x2: "+x2+" y2: "+y2+" Distance: "+dist);

					// System.out.println("Distance: "+dist+" CurrentDist: "+currentDist);

					if (dist < currentDist) {
						currentDist = dist;
						remove = i;
					}

				}

				x1 = (int) coordinatesNeig.get(remove).getX();
				y1 = (int) coordinatesNeig.get(remove).getY();

				coordinatesNew.add(coordinatesNeig.get(remove));
				// System.out.println(coordinatesNew);

				coordinatesNeig.remove(remove);
				// System.out.println(coordinates);

			}

			coordinatesNew.add(this.initialPoint);

			// TIMER END

			float dist = 0;

			int x11 = -1, x22 = -1, y11 = -1, y22 = -1;

			for (int i = 0; i < this.coordinatesNew.size(); i++) {

				if (x11 == -1 && y11 == -1) {
					x11 = coordinatesNew.get(i).x;
					y11 = coordinatesNew.get(i).y;
				} else {
					x22 = (int) coordinatesNew.get(i).getX();
					y22 = (int) coordinatesNew.get(i).getY();
					dist = (float) Math.sqrt(Math.pow(x11 - x22, 2)
							+ Math.pow(y11 - y22, 2));
					x11 = x22;
					y11 = y22;
					totalDist = totalDist + dist;
				}
			}

			stop = System.currentTimeMillis();

			return coordinatesNew;
		}

		@Override
		public String toString() {
			String toReturn = "";
			if (this.coordinatesNeighInit == null) {
				toReturn = "There is nothing to calculate.";
			} else {
				toReturn = "The shortest Neighbour route is: \n";
				int i = 1;
				String add = "";
				for (Point coordinate : this.coordinatesNew) {
					add = add + i + ": " + coordinate.toString() + "\n";
					i++;
				}
				toReturn = toReturn + add;
				toReturn = toReturn + "\n" + "Calculation Time is: \n"
						+ returnTime() + "Ms";
				toReturn = toReturn + "\n" + "The Distance is: \n"
						+ returnDistance();
			}
			return toReturn;
		}

		@Override
		public Long returnTime() {

			long toReturn;

			if (start != 0) {
				toReturn = stop - start;
			} else {
				toReturn = 0;
			}

			return toReturn;

		}

		@Override
		public float returnDistance() {
			float toReturn = totalDist;
			return toReturn;
		}

	},

	/**
	 * @return Volledige Enumeratie Path
	 */
	Enumeratie {

		private ArrayList<Point> coordinates;
		private long start;
		private long stop;
		private float lowestDistance;

		@Override
		public ArrayList<Point> calculatePath(ArrayList<Point> coordinates,
				Point initialPoint) {
			// System.out.println("Enumeratie");

			// TIMER START

			start = 0;
			stop = 0;
			lowestDistance = 0;

			start = System.currentTimeMillis();

			this.coordinates = coordinates;

			List<List<Point>> perm = new ArrayList<List<Point>>();
			HashMap<Float, List<Point>> hashmap;

			perm = generatePerm(this.coordinates);
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

			lowestDistance = lowest;

			this.coordinates = (ArrayList<Point>) hashmap.get(lowest);

			// TIMER STOP

			stop = System.currentTimeMillis();

			return this.coordinates;
		}

		public List<List<Point>> generatePerm(List<Point> original) {
			int i = 0;
			if (original.size() == 0) {
				List<List<Point>> result = new ArrayList<List<Point>>();
				result.add(new ArrayList<Point>());
				return result;
			}
			Point firstElement = original.remove(0);
			List<List<Point>> returnValue;
			returnValue = new ArrayList<List<Point>>();
			List<List<Point>> permutations = generatePerm(original);
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
			if (this.coordinates == null) {
				toReturn = "There is nothing to calculate.";
			} else {
				toReturn = "The shortest Enumeratie route is: \n\n";
				int i = 1;
				String add = "";
				for (Point coordinate : this.coordinates) {
					add = add + i + ": " + coordinate.toString() + "\n";
					i++;
				}
				toReturn = toReturn + add;
				toReturn = toReturn + "\n" + "Calculation Time is: \n"
						+ returnTime() + "Ms";
				toReturn = toReturn + "\n" + "The Distance is: \n"
						+ returnDistance();
			}
			return toReturn;
		}

		@Override
		public Long returnTime() {

			long toReturn;

			if (start != 0) {
				toReturn = stop - start;
			} else {
				toReturn = 0;
			}

			return toReturn;
		}

		@Override
		public float returnDistance() {
			float toReturn = lowestDistance;
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

	/**
	 * @return Distance of points {@link Algorithm}
	 */
	public abstract float returnDistance();

}
