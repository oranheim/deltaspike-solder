package org.jboss.solder.literal;

import org.apache.deltaspike.core.api.exclude.annotation.Exclude;
import org.apache.deltaspike.core.api.literal.AnyLiteral;
import org.apache.deltaspike.core.api.literal.DefaultLiteral;

@Exclude
public class Literals {

	public static AnyLiteral ANY_LITERAL = new AnyLiteral(); 
	public static DefaultLiteral DEFAULT_LITERAL = new DefaultLiteral(); 
	
}
