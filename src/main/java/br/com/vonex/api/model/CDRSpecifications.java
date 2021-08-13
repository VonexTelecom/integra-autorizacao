package br.com.vonex.api.model;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

public class CDRSpecifications {

	public static Specification<CDR> hasClientId(Long clientId) {
		if (clientId == null) {
			return (cdr, cq, cb) -> cb.conjunction();
		}
		return (cdr, cq, cb) -> cb.equal(cdr.get("clientId"), clientId);
	}

	public static Specification<CDR> hasCDRDate(LocalDateTime startDayInitial, LocalDateTime startDayFinal) {
		if (startDayInitial == null && startDayFinal == null) {
			return (cdr, cq, cb) -> cb.conjunction();
		}
		if (startDayInitial != null && startDayFinal == null) {
			return (cdr, cq, cb) -> cb.greaterThanOrEqualTo(cdr.get("date"), startDayInitial);
		}
		if (startDayInitial == null && startDayFinal != null) {
			return (cdr, cq, cb) -> cb.lessThanOrEqualTo(cdr.get("date"), startDayFinal);
		}
		return (cdr, cq, cb) -> cb.between(cdr.get("date"), startDayInitial, startDayFinal);
	}

	public static Specification<CDR> hasConferenceId(String conferenceId) {
		if (conferenceId == null) {
			return (cdr, cq, cb) -> cb.conjunction();
		}
		return (cdr, cq, cb) -> cb.equal(cdr.get("conferenceId"), conferenceId);
	}

}
