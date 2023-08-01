//package com.avengers.bus.dao.implementation;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.AdminDAO;
//import com.avengers.bus.models.entityModels.Admin;
//
//public class AdminDAOImplTest {
//
//	@Mock
//	private EntityManager entityManager;
//
//	@Mock
//	private TypedQuery<Admin> query;
//
//	@InjectMocks
//	private AdminDAO adminDAO = new AdminDAOImpl();
//
//	@BeforeClass
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testFindByUserId_WithExistingUser() {
//		// Mocking the required objects and data
//		String userId = "test_user";
//		Admin admin = new Admin();
//		admin.setUser_id(userId);
//
//		List<Admin> admins = new ArrayList<>();
//		admins.add(admin);
//
//		// Mocking the EntityManager and TypedQuery behavior
//		when(entityManager.createQuery(anyString(), eq(Admin.class))).thenReturn(query);
//		when(query.setParameter(eq("uname"), eq(userId))).thenReturn(query);
//		when(query.getResultList()).thenReturn(admins);
//
//		// Calling the method to be tested
//		Admin result = adminDAO.findByUserId(userId);
//
//		// Verifying the method behavior and assertions
//		verify(entityManager).createQuery(anyString(), eq(Admin.class));
//		verify(query).setParameter(eq("uname"), eq(userId));
//		verify(query).getResultList();
//
//		Assert.assertEquals(result, admin);
//	}
//
//	@Test
//	public void testFindByUserId_WithNonExistingUser() {
//		// Mocking the required objects and data
//		String userId = "non_existing_user";
//
//		List<Admin> admins = new ArrayList<>(); // Empty list for non-existing user
//
//		// Mocking the EntityManager and TypedQuery behavior
//		when(entityManager.createQuery(anyString(), eq(Admin.class))).thenReturn(query);
//		when(query.setParameter(eq("uname"), eq(userId))).thenReturn(query);
//		when(query.getResultList()).thenReturn(admins);
//
//		// Calling the method to be tested
//		Admin result = adminDAO.findByUserId(userId);
//
//		// Verifying the method behavior and assertions
//		verify(entityManager).createQuery(anyString(), eq(Admin.class));
//		verify(query).setParameter(eq("uname"), eq(userId));
//		verify(query).getResultList();
//
//		Assert.assertNull(result);
//	}
//}
