package insurence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ProductCalculatorTest {

	/**
	 * Test if empty list is ok.
	 */
	@Test
	public void noProducts_ShouldBeZero() {
		// given
		List<Product> products = new ArrayList<>();

		// when
		int result = ProductCalculator.getTotalCarInsurencePrice(products);

		// then
		assertThat(result, equalTo(0));
	}

	/**
	 * Test the result if one Car-Product is summed up from the list.
	 */
	@Test
	public void oneCarProduct_ShouldBePriceOfCar() {
		// given
		List<Product> products = Arrays.asList(new Product(4, "Test", ProductType.Car));

		// when
		int result = ProductCalculator.getTotalCarInsurencePrice(products);

		// then
		assertThat(result, equalTo(4));
	}

	/**
	 * Test the result if 3 Car-Products are summed up from the list.
	 */
	@Test
	public void threeCarProducts_ShouldBeSumPriceOfCars() {
		// given
		List<Product> products = Arrays.asList(
				new Product(1, "Test1", ProductType.Car),
				new Product(2, "Test2", ProductType.Car), 
				new Product(3, "Test3", ProductType.Car));

		// when
		int result = ProductCalculator.getTotalCarInsurencePrice(products);

		// then
		assertThat(result, equalTo(6));
	}

	/**
	 * Test the result if only Car-Products are summed up from the list with
	 * different product-types.
	 */
	@Test
	public void onlyCarProducts_ShouldBeSumPriceOfCars() {
		// given
		List<Product> products = Arrays.asList(
				new Product(1, "Test1", ProductType.Car),
				new Product(2, "Test2", ProductType.Car), 
				new Product(3, "Test3", ProductType.Boat),
				new Product(4, "Test4", ProductType.House));

		// when
		int result = ProductCalculator.getTotalCarInsurencePrice(products);

		// then
		assertThat(result, equalTo(3));
	}
	
	/**
	 * Test the result if only unique Car-Products are summed up from the list with
	 * different product-types.
	 */
	@Test
	public void unique_ShouldBeSumPriceOfCars() {
		// given
		List<Product> products = Arrays.asList(
				new Product(1, "Test1", ProductType.Car),
				new Product(1, "Test1", ProductType.Car),
				new Product(2, "Test2", ProductType.Car), 
				new Product(3, "Test3", ProductType.Boat),
				new Product(3, "Test3", ProductType.Boat),
				new Product(4, "Test4", ProductType.House));

		// when
		int result = ProductCalculator.getTotalCarInsurencePrice(products);

		// then
		assertThat(result, equalTo(3));
	}
}
