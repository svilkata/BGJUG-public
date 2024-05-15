package com.toshev.martin.patterns.behavioral.interpreter;

public class ConfigureCiscoIOSExpression extends CiscoIOSExpression {
	
	public void execute(CiscoIOSContext context) {
		String configurationTarget = context.getConfigurationTarget();
		System.out.println("Configuring...");
		// execute configure <configurationTarget> ... 
	}
	
}
