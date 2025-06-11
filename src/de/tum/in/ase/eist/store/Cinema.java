package de.tum.in.ase.eist.store;


import de.tum.in.ase.eist.ecommerce.Order;
import de.tum.in.ase.eist.ecommerce.ECommerceFacade;


// TODO 6 Remove all associations to the different controllers and use the facade instead.
public class Cinema {

	private final String address;
	private final String name;
	private final ECommerceFacade eCommerceFacade;
	private static int count = 1;

	private final int id;

	public Cinema(String address, String name) {
		this.address = address;
		this.name = name;
		this.id = generateCinemaId();
		eCommerceFacade = new ECommerceFacade();
	}
	public void advertise(int duration) {
		eCommerceFacade.playAdvertisement(duration);
	}

	private int generateCinemaId() {
		count *= 2;
		return count;
	}

		public void startLiveStream(int ageRestriction) {
			System.out.println("Let's watch some ads at the beginning.");
			eCommerceFacade.playAdvertisement(ageRestriction); // Use the facade to play advertisements
			System.out.println("The film starts. Your cinema " + name + " hopes you enjoy the movie.");
		}

		public void stopLiveStream(int ageRestriction) {
			System.out.println("Let's watch some more ads. ");
			eCommerceFacade.playAdvertisement(ageRestriction);
			System.out.println("Have a nice evening!");
			System.out.println("-----------------------------------------------------------------------------------------");
		}

		public void deliverPopcorn(String shippingAddress) {
			Order order=eCommerceFacade.retrieveLatestOrder(id);
			eCommerceFacade.processOrder(order);
			eCommerceFacade.shipOrder(order, shippingAddress);
		}

		@Override
		public String toString() {
			return "Cinema " + name + ", located at " + address;
		}


	}


