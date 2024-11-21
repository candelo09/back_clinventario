package com.clsystem.clinventario.entity;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.math.BigDecimal;
import java.util.Date;

@Entity()
@Table(name = "invoices")
@Data()
public class Invoice  {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private Integer invoice_code;

    private Integer customer_id;

    private Integer seller_id;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode products;

    private Double taxes;

    private BigDecimal before_total;

    private BigDecimal total;

    private  String payment_method;

    private Date created_at;

    private String note;
}
