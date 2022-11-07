import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedState = "Texas";
		
		var actualState = States.Texas.Name;
		
		var errorMessage = "State name should be returned.";
		Assert.assertEquals(actualState, expectedState, errorMessage);
	}

	@Test
	public void canGetStateAbbreviation() {
		var expectedAbbreviation = "TX";
		
		var actualAbbreviation = States.Texas.Abbreviation;
		
		var errorMessage = "City abbreviation should be returned.";
		Assert.assertEquals(actualAbbreviation, expectedAbbreviation, errorMessage);  
	}

	@Test
	public void canGetStateName2() {
		var expectedState = "Florida";
		
		var actualState = States.Florida.Name;
		
		var errorMessage = "State name should be returned.";
		Assert.assertEquals(actualState, expectedState, errorMessage);
	}

	@Test
	public void canGetStateAbbreviation2( ) {
		var expectedAbbreviation = "FL";
		
		var actualAbbreviation = States.Florida.Abbreviation;
		
		var errorMessage = "City abbreviation should be returned.";
		Assert.assertEquals(actualAbbreviation, expectedAbbreviation, errorMessage);  
	}

	@Test
	public void canGetCity() {
		var expectedCity = "Houston";
		
		var actualCity = Cities.Houston.Name;
		
		var errorMessage = "City name should be returned";
		Assert.assertEquals(actualCity, expectedCity, errorMessage);  
	}

	@Test
	public void canGetCity2() {
		var expectedCity = "Miami";
		
		var actualCity = Cities.Miami.Name;
		
		var errorMessage = "City name should be returned";
		Assert.assertEquals(actualCity, expectedCity, errorMessage);  
	}

	@Test
	public void canGetState() {
		var expectedState = "Louisiana";
		
		var actualState = getState(LocationObjectMothers.NewOrleans());
		
		var errorMessage = "State should be returned";
		Assert.assertEquals(actualState, expectedState, errorMessage);
	}

	@Test
	public void canGetState2() {
		var expectedState = "Texas";
		
		var actualState = getState(LocationObjectMothers.Houston());
		
		var errorMessage = "State should be returned";
		Assert.assertEquals(actualState, expectedState, errorMessage);
	}

	private String getState(LocationObjectMother mother) {
		return mother.State.Name;
	}
}
