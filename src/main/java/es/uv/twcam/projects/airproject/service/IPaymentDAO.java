package es.uv.twcam.projects.airproject.service;

import java.util.List;

import es.uv.twcam.projects.airproject.entity.Payment;

public interface IPaymentDAO {

	public List<Payment> getPayments();

	public Payment getPayment(int id);

	public void createPayment(Payment payment);

	public void updatePayment(Payment payment);

	public void deletePayment(Payment payment);


}