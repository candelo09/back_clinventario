package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IInvoiceDaoRepository;
import com.clsystem.clinventario.entity.Invoice;
import com.clsystem.clinventario.repository.IInvoiceRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceRepository {

    @Autowired
    private IInvoiceDaoRepository invoiceDao;

    @Override
    public Iterable<Invoice> findAllInvoice() {
        return invoiceDao.findAll();
    }

    @Override
    public Optional<Invoice> findByIdInvoice(Integer id) {
        return invoiceDao.findById(id);
    }

    @Override
    public void addInvoice(Invoice invoice) {

        invoiceDao.save(invoice);

    }

    @Override
    public void removeInvoice(Invoice invoice) {

        invoiceDao.delete(invoice);

    }

    @Override
    public void updateInvoice(Invoice invoice) {

        invoiceDao.save(invoice);

    }
}
