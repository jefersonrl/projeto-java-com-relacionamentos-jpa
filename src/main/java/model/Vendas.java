package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_vendas")
public class Vendas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_venda;
	
	@ManyToOne
	private Cliente cliente;
	
	private Date data;
	private Double vlr_total; 
	private Double desconto;
	private Double vlr_pago;
	public Integer getId_venda() {
		return id_venda;
	}
	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getVlr_total() {
		return vlr_total;
	}
	public void setVlr_total(Double vlr_total) {
		this.vlr_total = vlr_total;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getVlr_pago() {
		return vlr_pago;
	}
	public void setVlr_pago(Double vlr_pago) {
		this.vlr_pago = vlr_pago;
	}

	}
