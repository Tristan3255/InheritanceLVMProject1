import java.util.UUID;
import java.util.ArrayList;

public class VolumeGroup extends LVMSYSTEM{

    private ArrayList<PhysicalVolume> PV = new ArrayList<PhysicalVolume>();
    private ArrayList<LogicalVolume> LV = new ArrayList<LogicalVolume>();
    private int totalSize;
    public VolumeGroup(String name) {
        super(name, UUID.randomUUID());

    }


    public ArrayList<PhysicalVolume> getPV() {
        return PV;
    }

    public ArrayList<LogicalVolume> getLV() {
        return LV;
    }

    public boolean addPV(PhysicalVolume PhysicalVol){
        String volName = PhysicalVol.getName();
        String HDName = PhysicalVol.getHardDrive().getName();
        for(int i = 0; i < PV.size(); i++){
            String currentVol = PV.get(i).getName();
            String currentHD = PV.get(i).getHardDrive().getName();
            if(volName.equals(currentVol) || HDName.equals(currentHD)){
                return false;
            }
        }
        PV.add(PhysicalVol);
        totalSize += PhysicalVol.getHardDrive().getSize();
        return true;
    }

    public boolean addLV(LogicalVolume LogicalVol){
        String logName = LogicalVol.getName();
        for(int i = 0;i < LV.size(); i++){
            String currentLog = LV.get(i).getName();
            if(logName.equals(currentLog)){
                return false;
            }
        }
        if(totalSize > LogicalVol.getSize()){
            System.out.println("You do not have enough space to add a Logical Volume");
            return false;
        }
        LV.add(LogicalVol);
        return true;

    }
}
