/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * @author Tomás
 *
 */
public class ClienteRepositoryImpl implements ClienteRepositoryQuery {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
		
		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		
		Predicate[] predicates = this.criarRestricoes(clienteFilter, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		TypedQuery<Cliente> typedQuery = entityManager.createQuery(criteriaQuery);
		adicionarRestricaoDePaginacao(typedQuery, pageable);
		
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, this.total(clienteFilter));
	}
	
	
	private Long total(ClienteFilter clienteFilter) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		
		Predicate[] predicates = this.criarRestricoes(clienteFilter, criteriaBuilder, root);
		
		criteriaQuery.where(predicates);
		
		criteriaQuery.select(criteriaBuilder.count(root));
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
		
	}



	private void adicionarRestricaoDePaginacao(TypedQuery<?> typedQuery, Pageable pageable) {
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		typedQuery.setFirstResult(primeiroRegistroDaPagina);
		typedQuery.setMaxResults(totalRegistroPorPagina);
	}



	private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder criteriaBuilder, Root<Cliente> root) {
		
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(clienteFilter.getNome())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("nome")), 
									"%"+clienteFilter.getNome()+"%"));
		}
		
		if(!StringUtils.isEmpty(clienteFilter.getTelefone())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("telefone")), 
									"%"+clienteFilter.getTelefone()+"%"));
		}
		
		if(!StringUtils.isEmpty(clienteFilter.getEmail())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("email")), 
									"%"+clienteFilter.getEmail()+"%"));
		}
		
		if(!StringUtils.isEmpty(clienteFilter.getCpf())) {
			listaPredicates.add(criteriaBuilder.like(
									criteriaBuilder.lower(root.get("cpf")), 
									"%"+clienteFilter.getCpf()+"%"));
		}		
		
		return listaPredicates.toArray(new Predicate[listaPredicates.size()]);
	}

}
