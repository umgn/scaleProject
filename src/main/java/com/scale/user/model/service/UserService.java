package com.scale.user.model.service;

import static com.scale.common.JDBCTemplate.close;
import static com.scale.common.JDBCTemplate.commit;
import static com.scale.common.JDBCTemplate.getConnection;
import static com.scale.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.scale.bidding.model.vo.Bidding;
import com.scale.bidding.model.vo.Seller;
import com.scale.product.model.vo.Product;
import com.scale.user.model.dao.UserDao;
import com.scale.user.model.vo.Address;
import com.scale.user.model.vo.User;

public class UserService {

	public User userLogin(String userId, String userPwd) {
		Connection conn = getConnection();
		User loginUser = new UserDao().userLogin(conn, userId, userPwd);
		close(conn);
		return loginUser;
	}
	
	public int insertUser(User u, Address add) {
		Connection conn = getConnection();
		int result1 = new UserDao().insertUser(conn, u);
		int result2 = new UserDao().insertAdd(conn, add);

		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result1 * result2;
	}
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new UserDao().idCheck(conn, checkId);
		close(conn);
		return count;
	}
	
	public User findId(String userName, String email) {
		Connection conn = getConnection();
		User u = new UserDao().findId(conn, userName, email);
		close(conn);
		return u;
	}
	
	public User findPwd(String userId, String userName, String email) {
		Connection conn = getConnection();
		User u = new UserDao().findPwd(conn, userId, userName, email);
		close(conn);
		return u;
	}
	
	public int setNewPwd(String userId, String newPwd) {
		Connection conn = getConnection();
		int result = new UserDao().setNewPwd(conn, userId, newPwd);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	/**
	 * @param 김진우
	 * @param 회원 삭제용 메소드
	 * @return
	 */
	public int deleteUser(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new UserDao().deleteUser(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	


	/**
	 * @writer 먼지링
	 * @param 유저정보를 찾을 때 사용할 userNo
	 * @return User정보
	 */
	public User selectUserByUserNo(int userNo) {
		Connection conn = getConnection();
		User user = new UserDao().selectUserByUserNo(conn, userNo);
		close(conn);
		return user;
	}
	
	/**
	 * @author yurim
	 * @param userNo
	 * @return Address 기본배송지 정보
	 */
	public Address selectDefaultAddress(int userNo) {
		
		Connection conn = getConnection();
		Address ad = new UserDao().selectDefaultAddress(conn, userNo);
		
		close(conn);
		
		return ad;

	}
	/**
	 * @param 김진우
	 * @param phone : 사용자가 변경하기 위해 새로 입력한 연락처
	 * @return
	 */
	public User updatePhone(String userId, String phone) {
		Connection conn = getConnection();
		int result = new UserDao().updatePhone(conn, userId, phone);
		
		User updateUser = null;
		
		if(result > 0) {
			commit(conn);
			updateUser = new UserDao().selectUserForUpdateUser(conn, userId);
		}else{
			rollback(conn);
		}
		
		close(conn);
		return updateUser;

	}
	
	public User updatePwd(String userId, String updatePwd) {
		Connection conn = getConnection();
		int result = new UserDao().updatePwd(conn, userId, updatePwd);
		
		User updateUser = null;
		
		if(result > 0) {
			commit(conn);
			updateUser = new UserDao().selectUserForUpdateUser(conn, userId);
		}else{
			rollback(conn);
		}
		
		close(conn);
		return updateUser;

	}
	
	public User updateEmail(String userId, String email) {
		Connection conn = getConnection();
		int result = new UserDao().updateEmail(conn, userId, email);
		
		User updateUser = null;
		
		if(result > 0) {
			commit(conn);
			updateUser = new UserDao().selectUserForUpdateUser(conn, userId);
		}else{
			rollback(conn);
		}
		
		close(conn);
		return updateUser;
	}
	
	public ArrayList<Product> userSellList(int userNo) {
		Connection conn = getConnection();
		ArrayList<Product> list = new UserDao().userSellList(conn, userNo);
		close(conn);
		return list;
	}
	
	public ArrayList<Address> selectbasicAddressF(int userNo) {
		Connection conn = getConnection();
		ArrayList<Address> list = new UserDao().selectbasicAddressF(conn, userNo);
		close(conn);
		return list;
	}
	
	public User updateNickname(User u) {
		Connection conn = getConnection();
		int result = new UserDao().updateNickname(conn, u);
		User loginUser = null;
		if(result > 0) {
			commit(conn);
			loginUser = new UserDao().userLogin(conn, u.getUserId(), u.getUserPwd());
		} else {
			rollback(conn);
		}
		close(conn);
		return loginUser;
	}
	
	/**
	 * @author yurim
	 * @param userNo : 사용자의 계좌 정보를 찾기 위한 회원번호
	 * @return u
	 */
	public User selectUserAcc(int userNo) {
		
		Connection conn = getConnection();
		User u = new UserDao().selectUserAcc(conn, userNo);
		
		close(conn);
		
		return u;
	}
	

public Product userDetailImg(int userNo) {
		
		Connection conn = getConnection();
		Product p = new UserDao().userDetailImg(conn, userNo);
		
		close(conn);
		
		return p;
}
	
	/**
	 * @author yurim
	 * @param userNo : 사용자의 기본배송지 제외한 배송지 목록을 조회하기 위해 사용하는 회원번호
	 * @return list : 여러개의 배송지 Address가 담긴 ArrayList
	 */
	public ArrayList<Address> selectAddressList(int userNo){
		
		Connection conn = getConnection();
		ArrayList<Address> list = new UserDao().selectAddressList(conn, userNo);
		
		close(conn);
		
		return list;
		
	}
	
	
	/**
	 * @author yurim
	 * @param u: 회원번호, 계좌정보가 담겨있는 User객
	 * @return result: 정보변경 성공 유무를 담은 int형 변수
	 */
	public int updateUserAcc(User u) {
		
		Connection conn = getConnection();
		int result = new UserDao().updateUserAcc(conn, u);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public int updatePaymentAndShipping(Address ad) {
		
		
		Connection conn = getConnection();
		int result = new UserDao().updatePaymentAndShipping(conn, ad);
		
		
		if(result > 0) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
	public ArrayList<Product> userSellBidding(int userNo) {
		Connection conn = getConnection();
		ArrayList<Product> list = new UserDao().userSellBidding(conn, userNo);
		close(conn);
		return list;
	}
	
	public int userSellBiddingDrop(int biddingNo) {
		
		Connection conn = getConnection();
		int result = new UserDao().userSellBiddingDrop(conn, biddingNo);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Seller userDetailSellBidding1(int productCode2, String productSize) {
		
		Connection conn = getConnection();
		Seller s = new UserDao().userDetailSellBidding1(conn, productCode2, productSize);
		
		close(conn);
		
		return s;
	}
	
	public Product userDetailSellBidding2(int productCode2) {
		
		Connection conn = getConnection();
		Product p = new UserDao().userDetailSellBidding2(conn, productCode2);
		
		close(conn);
		
		return p;
	}
	
	public Bidding userDetailSellBidding3(int productCode2, String productSize, int userNo) {
		
		Connection conn = getConnection();
		Bidding b = new UserDao().userDetailSellBidding3(conn, productCode2, productSize, userNo);
		
		close(conn);
		
		return b;
	}
	
	
	public int insertAddress(Address ad) {
		
		Connection conn = getConnection();
		int result = 0;
		if(ad.getDefaultAdd().equals("Y")) {
			int result1 = new UserDao().changeDefAddress(conn, ad.getUserNo());
			int result2 = new UserDao().insertDefAdd(conn, ad);
			result = result1 * result2;
		} else {
			result = new UserDao().insertNewAdd(conn, ad);
		}
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public ArrayList<Address> selectBasicAddressList(int userNo){
		
		Connection conn = getConnection();
		ArrayList<Address> list = new UserDao().selectBasicAddressList(conn, userNo);
		
		close(conn);
		
		return list;
		
	}
	
	public int updateBasicAddress(int userNo, int addressNo) {
		
		Connection conn = getConnection();
		int result = new UserDao().updateBasicAddress(conn, userNo, addressNo);
		
		
		if(result > 0) {
			commit(conn);
			
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Bidding selectDetailSellList(int userNo, int biddingNo) {
		
		Connection conn = getConnection();
		Bidding b1 = new UserDao().selectDetailSellList(conn, userNo, biddingNo);
		
		close(conn);
		
		return b1;
	}
	
	public ArrayList<Product> userBuyList(int userNo) {
		
		Connection conn = getConnection();
		ArrayList<Product> list = new UserDao().userBuyList(conn, userNo);
		close(conn);
		return list;
	}
	
	
	
	public Bidding selectDetailBuyList(String paymentNo,int userNo,int biddingNo) {
		
		Connection conn = getConnection();
		Bidding b1 = new UserDao().selectDetailBuyList(conn, paymentNo, userNo, biddingNo);
		
		close(conn);
		
		return b1;
	}
	
	public Product userDetailImgForBuy(int userNo) {
		
		Connection conn = getConnection();
		Product p = new UserDao().userDetailImgForBuy(conn, userNo);
		
		close(conn);
		
		return p;
}
}
