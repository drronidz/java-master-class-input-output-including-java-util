package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by com.timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile  randomAccessFile;

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("locations_rand.dat","rwd")){
            randomAccessFile.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + randomAccessFile.getFilePointer() + Integer.BYTES);
            randomAccessFile.writeInt(locationStart);

            long indexStart = randomAccessFile.getFilePointer();
            int startPointer  = locationStart;
            randomAccessFile.seek(startPointer);

            for(Location location : locations.values()) {
                randomAccessFile.writeInt(location.getLocationID());
                randomAccessFile.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                randomAccessFile.writeUTF(builder.toString());
                IndexRecord record = new IndexRecord(startPointer, (int) (randomAccessFile.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);
                startPointer = (int) randomAccessFile.getFilePointer();
            }

            randomAccessFile.seek(indexStart);
            for(Integer locationID : index.keySet()) {
                randomAccessFile.writeInt(locationID);
                randomAccessFile.writeInt(index.get(locationID).getStartByte());
                randomAccessFile.writeInt(index.get(locationID).getLength());
            }
        }
    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (byte 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700


    static {
        try {
            randomAccessFile = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = randomAccessFile.readInt();
            long locationStartPoint = randomAccessFile.readInt();

            while (randomAccessFile.getFilePointer() < locationStartPoint) {
                int locationID = randomAccessFile.readInt();
                int locationStart = randomAccessFile.readInt();
                int locationLength = randomAccessFile.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationID, record);

            }

        } catch (IOException e) {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }


    }

    public Location getLocation(int locationID) throws IOException {
        IndexRecord record = index.get(locationID);
        randomAccessFile.seek(record.getStartByte());
        int id  = randomAccessFile.readInt();
        String description = randomAccessFile.readUTF();
        String exits = randomAccessFile.readUTF();
        String [] exitPart = exits.split(",");
        Location location = new Location(locationID, description, null);

        if(locationID != 0) {
            for(int i=0; i<exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1]" + exitPart[i+1]);
                String direction = exitPart [i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        randomAccessFile.close();
    }
}
