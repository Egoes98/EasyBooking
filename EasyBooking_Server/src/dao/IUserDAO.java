package dao;

import java.util.List;

import easyBookingData.Reservation;
import easyBookingData.User;

public interface IUserDAO {
	public void makeReservation(Reservation r);
	public List<Reservation> getReservation();
	public String getAuthorization();
	public User getUser(String email);
	public void createUser(User u);
	public void updateUser(User u);
}
