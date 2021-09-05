package com.tcc.receituario.domain.enums;

public enum TipoPerfil {

	ADMIN(1,"ADMIN"),
	FARMACEUTICO(2,"FARMACEUTICO"),
	MEDICO(3, "MEDICO"),
	PACIENTE(4,"PACIENTE");
	
	private int cod;
	private String descricao;
	
	private TipoPerfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoPerfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoPerfil x : TipoPerfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
