package com.marolix.session.JuneJulySpringBoot.exception;

import java.time.LocalDateTime;

public class ErrorInfo {
private String errorMessage;
private Integer errorCode;
private LocalDateTime occuredAt;
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public Integer getErrorCode() {
	return errorCode;
}
public void setErrorCode(Integer errorCode) {
	this.errorCode = errorCode;
}
public LocalDateTime getOccuredAt() {
	return occuredAt;
}
public void setOccuredAt(LocalDateTime occuredAt) {
	this.occuredAt = occuredAt;
}



}
