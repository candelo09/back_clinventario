package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface IInvoiceDaoRepository extends CrudRepository<Invoice, Integer> {
}
