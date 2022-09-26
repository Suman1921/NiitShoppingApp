package com.Project.NiitShoppingApp_Backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.NiitShoppingApp_Backend.dao.ProductDao;
import com.Project.NiitShoppingApp_Backend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	
	@Autowired
	private SessionFactory sessionFactory;

	public Product get(int productId) 
	{
		try 
		{
			return sessionFactory.getCurrentSession()
					.get(Product.class , Integer.valueOf(productId));
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		return null;
	}

	public List<Product> list() 
	{

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product" , Product.class)
				.getResultList();
		

	}

	public boolean add(Product product) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(product); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;

	}

	public boolean update(Product product) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(product); 
			return true;
		}
		catch(Exception e )
		{
			e.printStackTrace();

		}
		return false;

	}

	public boolean delete(Product product) 
	{
		
		
		try
		{
			product.setIs_active(false);
			return this.update(product);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public List<Product> listActiveProducts() 
	{
		String selectActiveProducts = "FROM Product WHERE is_active = :active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts , Product.class)
				.setParameter("active", true).getResultList();
		
		
	}

	public List<Product> listActiveProductsByCategory(int categoryId) 
	{
		String selectActiveProductsByCategory = "FROM Product WHERE is_active = :active AND category_id = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory , Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
