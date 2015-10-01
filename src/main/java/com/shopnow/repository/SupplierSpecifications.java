package com.shopnow.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.shopnow.entity.Supplier;

/**
 * 
 * @author Vishnu Awasthi
 *
 */
public class SupplierSpecifications {

	public static Specification<Supplier> hasName(final String name) {
		return new Specification<Supplier>() {
			@Override
			public Predicate toPredicate(Root<Supplier> root, CriteriaQuery<?> criteriaQuery,CriteriaBuilder criteriaBuilder) {
				Predicate predicate = criteriaBuilder.conjunction();
				if (!StringUtils.isEmpty(name)) {
					predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("name"), name));
				}
				return predicate;
			}
		};
	}
	
	/**
	 * 
	 * @return
	 */
	public static Sort sortByIdAsc() {
		return new Sort(Sort.Direction.ASC, "id");
	}
	/**
	 * Returns a new object which specifies the the wanted result page.
	 * @param pageIndex The index of the wanted result page
	 * @return
	 */
	public static Pageable constructPageSpecification(int pageIndex, int pageSize,
			Sort sortingOrderSpec) {
		Pageable pageSpecification = new PageRequest(pageIndex, pageSize, sortingOrderSpec);
		return pageSpecification;
	}
	/**
	 * Returns a Sort object which sorts Objects in ascending order by using the
	 * sortKey.
	 * @return
	 */
	public static Sort sortBySortkey() {
		return new Sort(Sort.Direction.ASC, "sortKey");
	}
}
