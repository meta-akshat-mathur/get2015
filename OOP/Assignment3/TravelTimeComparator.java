import java.util.Comparator;

public class TravelTimeComparator implements Comparator<Train> {
	@Override
	public int compare(Train o1, Train o2) {
		Train train1 = (Train) o1;
		Train train2 = (Train) o2;

		return train1.duration.compareTo(train2.duration);
	}
}