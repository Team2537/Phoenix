package org.usfirst.frc.team2537.robot.vision;

import org.usfirst.frc.team2537.robot.Ports;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SerialSubsystem extends Subsystem {
	public final boolean DEBUG = true;
	public final int BAUDRATE = 38400;
	
	private SerialPort serial;
	private String buffer;
	private String lastCompletedString;
	private boolean recievedEmptyPacket;

	public SerialSubsystem(){
		serial = new SerialPort(BAUDRATE, Ports.RASPI);
		buffer = "";
		recievedEmptyPacket = true;
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ReadSerialCommand()); // automatically adds packets to the buffer
	}

	public Target[] getVisionPacket() {
		if(recievedEmptyPacket){
			return new Target[0];
		} else {
			return getVisionPacketNonEmpty();
		}
	}
	
	public Target[] getVisionPacketNonEmpty() {
		return decodeVisionPacket(lastCompletedString);
	}
	
	public static Target[] decodeVisionPacket(String packetToDecode) {
		if(packetToDecode == "" || packetToDecode == null){
			return new Target[0];
		}
		String[] stringTargets = packetToDecode.split("#");
		Target[] targets = new Target[stringTargets.length];
		for (int i = 0; i < stringTargets.length; i++) {
			String[] pointArr = stringTargets[i].split("\\|");
			Point[] points = new Point[pointArr.length];
			for (int j = 0; j < pointArr.length; j++) {
				String[] coordinates = pointArr[j].split(",");
				points[j] = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
			}
			targets[i] = new Target(points);
		}
		return targets;
	}
	
	public void addToBuffer() { // should run periodically
		if (serial.getBytesReceived() > 0) {
			try { // wrapped in a try/catch because if the pi inits before the rio it'll crash otherwise
				String stringToAppend = serial.readString();
				serial.flush();
				for (int i = 0; i < stringToAppend.length(); i++) {
					char charToAppend = stringToAppend.charAt(i);
					if (charToAppend == '>') { // is current character opening character?
						if(buffer.length() == 0){ // check for empty packets
							recievedEmptyPacket = true;
						} else {
							if(lastCompletedString == null) { // make sure to discard premature packets
								recievedEmptyPacket = true;
								lastCompletedString = "";
							} else {
								recievedEmptyPacket = false;
								lastCompletedString = buffer;
							}
						}
						buffer = "";
					} else { // otherwise, add current char to the buffer
						buffer += charToAppend;
					}
				}
			} catch (Exception e) {
				System.out.println("serial exception");
			}
		}
	}
	
	/*
	public void sendVisionPacket(Point[] packetsToSend) {
		serial.writeString(encodeVisionPacket(packetsToSend));
	}
	*/
}
