import java.util.UUID;
public class PhysicalVolume extends LVMSYSTEM{

    private PhysicalDrive physicalDrive;
    private boolean inVG;

    public PhysicalVolume(String name, PhysicalDrive physicalDrive){
        super(name, UUID.randomUUID());
        this.physicalDrive = physicalDrive;
        inVG = false;
    }

    public PhysicalDrive getHardDrive(){
        return physicalDrive;
    }

    public boolean isInVG(){
        return inVG;
    }

    public void setInVG(boolean VG){
        inVG = VG;
    }




}
