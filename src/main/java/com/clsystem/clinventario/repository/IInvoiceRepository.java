package com.clsystem.clinventario.repository;


import com.clsystem.clinventario.entity.Invoice;

import java.util.Optional;

public interface IInvoiceRepository {

    public Iterable<Invoice> findAllInvoice();

    public Optional<Invoice> findByIdInvoice(Integer id);

    public void addInvoice(Invoice customer);

    public void removeInvoice(Invoice customer);

    public void updateInvoice(Invoice customer);
}
