package com.example.financialApp.models.enums;

public enum WalletItemType {
	
	ENTRY(1), 
	EXIT(2);

	private int code;

	private WalletItemType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static WalletItemType valueOf(int code) {
		for (WalletItemType value : WalletItemType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid WalletItemType code");

	}

}
