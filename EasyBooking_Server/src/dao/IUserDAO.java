package dao;

import java.util.List;

import easyBookingData.Reservation;
import easyBookingData.User;

public interface IUserDAO {
	public User getUser(String email);
	public void createUser(User u);
	public void updateUser(User u);
}
