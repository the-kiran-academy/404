package com.tka.operation.projection;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class ProjectionEx2 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Product.class);

		PropertyProjection id = Projections.property("id");
		PropertyProjection name = Projections.property("name");
		PropertyProjection price = Projections.property("price");

		ProjectionList plist = Projections.projectionList();
		plist.add(id);
		plist.add(name);
		plist.add(price);

		criteria.setProjection(plist);

		List<Object[]> list = criteria.list();

		for (Object[] obj : list) {

			System.out.print(obj[0] + "\t");
			System.out.print(obj[1] + "\t");
			System.out.println(obj[2] + "\t");
		}

	}

}
