package com.behrooz.merchant.util;

/**
 * The type Response structure.
 *
 * @param <T> the type parameter
 */
public class ResponseStructure<T> {

  private String msg;
  private T data;

  /**
   * Instantiates a new Response structure.
   */
  public ResponseStructure() {
  }

  /**
   * Instantiates a new Response structure.
   *
   * @param data the data
   */
  public ResponseStructure(T data) {
    this(data, "ok");
  }

  /**
   * Instantiates a new Response structure.
   *
   * @param data the data
   * @param msg  the msg
   */
  public ResponseStructure(T data, String msg) {
    this.msg = msg;
    this.data = data;
  }

  /**
   * Gets msg.
   *
   * @return the msg
   */
  public String getMsg() {
    return msg;
  }

  /**
   * Sets msg.
   *
   * @param msg the msg
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data the data
   */
  public void setData(T data) {
    this.data = data;
  }
}
