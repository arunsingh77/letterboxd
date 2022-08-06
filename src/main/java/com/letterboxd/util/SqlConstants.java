package com.letterboxd.util;

public class SqlConstants {

	public static final String GET_MOVIE_QUERY = "SELECT M.MOVIE_NAME,M.DIRECTOR,M.DESCRIPTION,M.LANG,M.RATING,R.USER_ID,R.MOVIE_NAME,R.REVIEW,R.RATING AS USER_RATING FROM MOVIE M LEFT JOIN REVIEW R ON M.MOVIE_NAME=R.MOVIE_NAME WHERE M.MOVIE_NAME=?";
	public static final String ADD_MOVIE_QUERY = "INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,DESCRIPTION,LANG,RATING) VALUES(?,?,?,?,?)";
	public static final String UPDATE_MOVIE_QUERY = "UPDATE MOVIE SET DIRECTOR=?,DESCRIPTION=?,LANG=?,RATING=? WHERE MOVIE_NAME=?";
	public static final String DELETE_MOVIE_QUERY = "DELETE FROM MOVIE WHERE MOVIE_NAME=?";
	public static final String GET_USER_QUERY = "SELECT * FROM USER_DETAIL WHERE USER_ID=?";
	public static final String ADD_USER_QUERY = "INSERT INTO USER_DETAIL(USER_ID,USER_NAME,PHN_NO,STATUS) VALUES(?,?,?,?)";
	public static final String UPDATE_USER_QUERY = "UPDATE USER_DETAIL SET USER_NAME=?,PHN_NO=?,STATUS=? WHERE USER_ID=?";
	public static final String GET_REVIEW_QUERY = "SELECT * FROM REVIEW WHERE USER_ID=?";
	public static final String ADD_REVIEW_QUERY = "INSERT INTO REVIEW(USER_ID,MOVIE_NAME,REVIEW,RATING) VALUES(?,?,?,?)";
	public static final String UPDATE_REVIEW_QUERY = "UPDATE REVIEW SET REVIEW=?,RATING=? WHERE USER_ID=? AND MOVIE_NAME=?";
	public static final String UPDATE_RATING_QUERY = "UPDATE MOVIE SET RATING=(SELECT AVG(RATING) FROM REVIEW WHERE MOVIE_NAME=?) WHERE MOVIE_NAME=?";

}
