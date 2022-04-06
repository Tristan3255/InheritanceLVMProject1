import java.util.UUID;
import java.util.ArrayList;

public class VolumeGroup extends LVMSYSTEM{

    private ArrayList<PhysicalVolume> PV = new ArrayList<PhysicalVolume>();

    private int totalSize;
    private int availiableSize;


    public VolumeGroup(String name, PhysicalVolume Pv) {
        super(name);
        PV.add(Pv);
        for(PhysicalVolume p : PV){
            totalSize += p.getHardDrive().getSize();
            availiableSize += p.getHardDrive().getSize();
        }

    }

    public int getTotalSize(){
        return totalSize;
    }

    public int getAvailiableSize(){
        return availiableSize;
    }

    public void setAvailiableSize(int availiableSize){
        this.availiableSize -= availiableSize;
    }

    public void updateVGSize(int n){
        totalSize += n;
        availiableSize += n;
    }

    public ArrayList<PhysicalVolume> getPV() {
        return PV;
    }


    /*
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
    */
}
