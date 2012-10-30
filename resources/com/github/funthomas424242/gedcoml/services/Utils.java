package com.github.funthomas424242.gedcoml.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Utils {

	public static final String NAME_UNBEKANNT = "unbekannt";
	public static final String DATE_FORMAT_GERMAN = "dd.MM.yyyy";
	public static final String SEXUS_FEMALE = "weiblich";
	public static final String SEXUS_MALE = "männlich";
	public static final String SEXUS_UNKNOW = NAME_UNBEKANNT;
	public static final String DATE_FORMAT_UNKNOW = "??.??.????";

	public String getDateValue(Object obj) {

		if (obj != null &&  obj instanceof String && !obj.equals(SEXUS_UNKNOW)) {
			try {
				final String datum = (String) obj;
				final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_GERMAN);
				format.parse(datum);
				return datum;
			} catch (ParseException ex) {
				return DATE_FORMAT_UNKNOW;
			}
		}

		return DATE_FORMAT_UNKNOW;
	}

	public boolean isEmpty(Object[] obj){
		return (obj.length >0);
	}
	
	public String getSexus(Object obj){
		if( obj == null ){
			return SEXUS_UNKNOW;
		}
		if("male".equals(obj)){
			return SEXUS_MALE;
		}
		if("female".equals(obj)){
			return SEXUS_FEMALE;
		}
		return SEXUS_UNKNOW;
	}
	
	public String getName(final String firstName, final String lastName){
		if( firstName == null && lastName == null){
			return NAME_UNBEKANNT;
		}
		if( firstName == null ){
			return lastName;
		}
		if( lastName == null){
			return firstName;
		}
		return lastName+", "+firstName;
	}
	
	public String getBaseDir(Object obj){
		final Properties props=System.getProperties();
		//return props.getProperty("basedir");
		return props.getProperty("java.home");
	}
}
