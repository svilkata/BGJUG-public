package com.toshev.martin.patterns.creational.singleton;

public class LazyCiscoRouterControllerWithStatic {
	private static class InstanceHolder {
		private static final LazyCiscoRouterControllerWithStatic controller = new LazyCiscoRouterControllerWithStatic();
	}

	private LazyCiscoRouterControllerWithStatic() {
		System.out.println("Creating an instance");
	}
	
	public static LazyCiscoRouterControllerWithStatic instance() {
		return InstanceHolder.controller;
	}

	public static void main(String[] args) {
		System.out.println("Hello");

		// When we call for the 1st time it initializes
		System.out.println(instance());
		System.out.println(instance());
	}
}
