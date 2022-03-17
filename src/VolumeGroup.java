import java.util.UUID;
import java.util.ArrayList;

public class VolumeGroup extends SUPERCLASS{

    private ArrayList<PhysicalVolume> PV = new ArrayList<PhysicalVolume>();
    private ArrayList<LogicalVolume> LV = new ArrayList<LogicalVolume>();
    public VolumeGroup(String name){
        super(name, UUID.randomUUID());
    }


    public ArrayList<PhysicalVolume> getPV() {
        return PV;
    }

    public ArrayList<LogicalVolume> getLV() {
        return LV;
    }


}
