
public class LocationBuilder {

	private LocationObjectMother mother;

	public LocationBuilder() {
		this.mother = new LocationObjectMother();
	}

	public LocationBuilder withState(State s) {
		this.mother.State = s;
		return this;
	}

	public LocationBuilder withCity(City c) {
		this.mother.City = c;
		return this;
	}

	public LocationObjectMother build() {
		return this.mother;
	}
}