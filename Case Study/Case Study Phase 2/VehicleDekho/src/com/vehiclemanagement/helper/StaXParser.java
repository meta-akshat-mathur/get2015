package com.vehiclemanagement.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.vehiclemanagement.model.Bike;
import com.vehiclemanagement.model.Car;
import com.vehiclemanagement.model.Vehicle;

public class StaXParser {

	static final String ROW = "row";
	static final String TYPE = "type";
	static final String VEHICLEID = "vehicleId";
	static final String MAKE = "make";
	static final String MODEL = "model";
	static final String ENGINEINCC = "engineInCC";
	static final String FUELCAPACITY = "fuelCapacity";
	static final String MILEAGE = "mileage";
	static final String PRICE = "price";
	static final String ROADTAX = "roadTax";
	static final String AC = "ac";
	static final String POWERSTEERING = "powerSteering";
	static final String ACCESSORYKIT = "accessoryKit";
	static final String SELFSTART = "selfStart";
	static final String HELMETPRICE = "helmetPrice";

	@SuppressWarnings("unchecked")
	public List<Vehicle> readConfig(String config) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(config);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// System.out.println("eventReader:" + eventReader);
			// read the XML document
			Vehicle vechile = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (ROW)) {
						Iterator<Attribute> attributes = startElement
								.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals(TYPE)) {
								if (attribute.getValue()
										.equalsIgnoreCase("car")) {
									vechile = new Car();
								} else {
									vechile = new Bike();
								}
							}
						}

					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(VEHICLEID)) {
						event = eventReader.nextEvent();
						vechile.setVehicleId(Double.parseDouble(event
								.asCharacters().getData()));

					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(MAKE)) {
						event = eventReader.nextEvent();
						vechile.setMake(event.asCharacters().getData());

					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(MODEL)) {
						event = eventReader.nextEvent();
						vechile.setModel(event.asCharacters().getData());

					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(ENGINEINCC)) {
						event = eventReader.nextEvent();
						vechile.setEngineInCC(Integer.parseInt(event
								.asCharacters().getData()));

					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(FUELCAPACITY)) {
						event = eventReader.nextEvent();
						vechile.setFuelCapacity(Integer.parseInt(event
								.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(MILEAGE)) {
						event = eventReader.nextEvent();
						vechile.setMileage(Integer.parseInt(event
								.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(PRICE)) {
						event = eventReader.nextEvent();
						vechile.setPrice(Float.parseFloat(event.asCharacters()
								.getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(ROADTAX)) {
						event = eventReader.nextEvent();
						vechile.setRoadTax(Float.parseFloat(event
								.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(AC)) {
						event = eventReader.nextEvent();
						((Car) vechile).setAC(Boolean.parseBoolean(event
								.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(POWERSTEERING)) {
						event = eventReader.nextEvent();
						((Car) vechile).setPowerSteering(Boolean
								.parseBoolean(event.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(ACCESSORYKIT)) {
						event = eventReader.nextEvent();
						((Car) vechile).setAccessoryKit(Boolean
								.parseBoolean(event.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(SELFSTART)) {
						event = eventReader.nextEvent();
						((Bike) vechile).setSelfStart(Boolean
								.parseBoolean(event.asCharacters().getData()));
					}

					else if (event.asStartElement().getName().getLocalPart()
							.equals(HELMETPRICE)) {
						event = eventReader.nextEvent();
						((Bike) vechile).setHelmetPrice(Integer.parseInt(event
								.asCharacters().getData()));
					}
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (ROW)) {
						vehicles.add(vechile);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
}
