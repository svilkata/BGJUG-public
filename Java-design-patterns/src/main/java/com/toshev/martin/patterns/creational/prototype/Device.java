package com.toshev.martin.patterns.creational.prototype;

public abstract class Device implements Cloneable {

	@Override
	protected abstract Device clone() throws CloneNotSupportedException;
}
