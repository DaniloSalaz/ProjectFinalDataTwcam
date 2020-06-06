package es.uv.twcam.projects.airproject.service;

import java.util.List;

import javax.persistence.EntityManager;

import es.uv.twcam.projects.airproject.entity.Payment;
import es.uv.twcam.projects.airproject.repositoryDAO.DataDAOImpl;

public class PaymentDAOImpl extends DataDAOImpl<Integer,Payment> implements IPaymentDAO {

	public PaymentDAOImpl(EntityManager em) {
		super(em, Payment.class);
	}

	@Override
	public List<Payment> getPayments() {
		return this.findAll();
	}
	@Override
	public Payment getPayment(int id) {
		return this.findById(id);
	}
	@Override
	public void createPayment(Payment payment) {
		this.create(payment);
	}
	@Override
	public void updatePayment(Payment payment) {
		this.update(payment);
	}
	@Override
	public void deletePayment(Payment payment) {
		this.delete(payment);
	}

}