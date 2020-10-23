/**
 * 
 */
package sic.autenticarda.adapter;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
enum TransactionState {
    OK,
    FAIL,
}

public class BaseResponseAdapter<T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T body;
	
    private String status;
    
    private String businessStatus;
    
    private String timeResponse;
    
    private String message;
    
    private String path;
    
    private TransactionState transactionState;

	/**
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(T body) {
		this.body = body;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the businessStatus
	 */
	public String getBusinessStatus() {
		return businessStatus;
	}

	/**
	 * @param businessStatus the businessStatus to set
	 */
	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	/**
	 * @return the timeResponse
	 */
	public String getTimeResponse() {
		return timeResponse;
	}

	/**
	 * @param timeResponse the timeResponse to set
	 */
	public void setTimeResponse(String timeResponse) {
		this.timeResponse = timeResponse;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the transactionState
	 */
	public TransactionState getTransactionState() {
		return transactionState;
	}

	/**
	 * @param transactionState the transactionState to set
	 */
	public void setTransactionState(TransactionState transactionState) {
		this.transactionState = transactionState;
	}

	/**
	 * @param body
	 * @param status
	 * @param businessStatus
	 * @param timeResponse
	 * @param message
	 * @param path
	 * @param transactionState
	 */
	public BaseResponseAdapter(T body, String status, String businessStatus, String timeResponse, String message,
			String path, TransactionState transactionState) {
		this.body = body;
		this.status = status;
		this.businessStatus = businessStatus;
		this.timeResponse = timeResponse;
		this.message = message;
		this.path = path;
		this.transactionState = transactionState;
	}

	/**
	 * 
	 */
	public BaseResponseAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

}